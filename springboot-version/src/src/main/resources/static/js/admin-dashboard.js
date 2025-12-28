// ================================
// Role Handling (Staff / Manager)
// ================================

// بعداً این مقدار از پاسخ API لاگین یا localStorage میاد
// مثال:
// const role = localStorage.getItem("userRole");
const role = "ADMIN"; // یا "STAFF"

const body = document.body;
const roleLabel = document.getElementById("userRoleLabel");

// تنظیم نقش و UI
if (role === "ADMIN") {
    body.classList.remove("role-staff");
    body.classList.add("role-manager");
    roleLabel.textContent = "Manager";
} else {
    body.classList.add("role-staff");
    roleLabel.textContent = "Staff";
}

// ================================
// Logout
// ================================
const logoutBtn = document.getElementById("logoutBtn");

logoutBtn.addEventListener("click", () => {
    // بعداً: پاک کردن token / session
    // localStorage.clear();

    window.location.href = "/login.html";
});
