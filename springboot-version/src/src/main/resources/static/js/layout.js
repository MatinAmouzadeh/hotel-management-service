const role = localStorage.getItem("role");

const menuConfig = {
  Employee: [
    { id: "reservations", label: "Reservations" },
    { id: "guests", label: "Guests" },
    { id: "payments", label: "Payments" }
  ],
  SuperAdmin: [
    { id: "dashboard", label: "Dashboard" },
    { id: "reservations", label: "Reservations" },
    { id: "rooms", label: "Rooms" },
    { id: "guests", label: "Guests" },
    { id: "payments", label: "Payments" },
    { id: "employees", label: "Employees" },
    { id: "activity", label: "Activity History" },
    { id: "reports", label: "Reports" }
  ]
};

// role label
document.querySelector(".user-role").textContent = role;

// menu render
const menu = document.querySelector(".menu");
menu.innerHTML = "";

(menuConfig[role] || []).forEach((item, index) => {
  const el = document.createElement("div");
  el.className = "menu-item";
  el.textContent = item.label;

  if (index === 0) el.classList.add("active");

  el.addEventListener("click", () => {
    document
      .querySelectorAll(".menu-item")
      .forEach(i => i.classList.remove("active"));
    el.classList.add("active");
    document.querySelector(".page-title").textContent = item.label;
  });

  menu.appendChild(el);
});

// logout
document.querySelector(".logout-btn").onclick = () => {
  localStorage.clear();
  window.location.href = "/index.html";
};
