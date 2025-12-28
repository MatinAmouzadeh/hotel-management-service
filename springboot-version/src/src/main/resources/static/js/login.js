// ===== Background Gallery =====
const galleryItems = document.querySelectorAll(".gallery-item");

galleryItems.forEach(item => {
    item.addEventListener("click", () => {
        galleryItems.forEach(i => i.classList.remove("active"));
        item.classList.add("active");

        document.body.style.backgroundImage = `url('${item.src}')`;
    });
});

// Default background
document.body.style.backgroundImage = `url('${galleryItems[0].src}')`;

// ===== Login =====
const form = document.getElementById("loginForm");
const errorMessage = document.getElementById("errorMessage");

form.addEventListener("submit", function(e) {
    e.preventDefault();

    const username = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value.trim();
    const isAdmin = document.getElementById("isAdmin").checked;

    if (!username || !password) {
        errorMessage.innerText = "Username and password are required";
        return;
    }

    errorMessage.innerText = "";

	fetch("/api/auth/login", {
	    method: "POST",
	    headers: {
	        "Content-Type": "application/json"
	    },
	    body: JSON.stringify({
	        username: username,
	        password: password,
			role: isAdmin ? "SuperAdmin" : "Employee"
	    })
	})
	.then(response => response.json())
	.then(data => {

		if (data.message === "Login successful") {

		    localStorage.setItem("employeeId", data.employeeId);
		    localStorage.setItem("username", data.username);
		    localStorage.setItem("role", data.role);

			window.location.href = "/dashboard.html";


	    } else {
	        errorMessage.innerText = data.message;
	    }
	})
	.catch(error => {
	    console.error(error);
	    errorMessage.innerText = "Server connection error";
	});

});
	const roleSwitch = document.getElementById("isAdmin");
	const loginBtn = document.querySelector(".login-btn");
	const adminWarning = document.getElementById("adminWarning");

	roleSwitch.addEventListener("change", () => {
	    if (roleSwitch.checked) {
	        loginBtn.textContent = "Enter Management Panel";
	        loginBtn.classList.add("manager");
	        adminWarning.classList.remove("hidden");
	    } else {
	        loginBtn.textContent = "Sign In";
	        loginBtn.classList.remove("manager");
	        adminWarning.classList.add("hidden");
	    }
	});
