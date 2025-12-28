const role = localStorage.getItem("role");
const employeeId = localStorage.getItem("employeeId");

if (!role || !employeeId) {
    window.location.href = "/index.html";
}