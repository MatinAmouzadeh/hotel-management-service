const container = document.getElementById("dashboardContent");

// utils
const formatMoney = (num) =>
  new Intl.NumberFormat("en-US").format(num ?? 0);

// loading state
container.innerHTML = "<p>Loading dashboard...</p>";

Promise.all([
  fetch("/api/dashboard/summary").then(r => r.json()),
  fetch("/api/activityHistory?limit=5").then(r => r.json())
])
.then(([summaryRes, activityRes]) => {

  const summary = summaryRes.data || summaryRes;
  const activities = activityRes.data || activityRes || [];

  container.innerHTML = `
    <section class="stats">
      <div class="stat-card glass">
        <p>Total Reservations</p>
        <h2>${summary.totalReservations}</h2>
      </div>

      <div class="stat-card glass">
        <p>Available Rooms</p>
        <h2>${summary.availableRooms}</h2>
      </div>

      <div class="stat-card glass">
        <p>Reserved Rooms</p>
        <h2>${summary.reservedRooms}</h2>
      </div>

      <div class="stat-card glass">
        <p>Today Revenue</p>
        <h2>${formatMoney(summary.todayRevenue)}</h2>
      </div>

      <div class="stat-card glass warning">
        <p>Pending Payments</p>
        <h2>${summary.pendingPayments ?? 0}</h2>
      </div>
    </section>

    <section class="activity glass">
      <h3>Recent Activity</h3>
      <ul>
        ${
          activities.length
            ? activities.map(a => `
              <li>
                <span class="action">${a.action}</span>
                <span class="desc">${a.description}</span>
                <span class="time">${new Date(a.time).toLocaleString()}</span>
              </li>
            `).join("")
            : "<li>No recent activity</li>"
        }
      </ul>
    </section>
  `;
})
.catch(err => {
  console.error(err);
  container.innerHTML =
    "<p>Dashboard data could not be loaded</p>";
});
