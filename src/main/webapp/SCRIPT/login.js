function validateForm() {
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    let emailError = document.getElementById("emailError");
    let passwordError = document.getElementById("passwordError");

    // Reset error messages
    emailError.textContent = "";
    passwordError.textContent = "";

    // Email pattern check
    let emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!emailPattern.test(email)) {
        emailError.textContent = "Please enter a valid email address.";
        return false;
    }

    // Password pattern check
    if (password.length < 3) {
        passwordError.textContent = "Password must be at least 3 characters long.";
        return false;
    }

    // If validation passes--
    console.log("Credentials Validated");
    return true;
}

window.onunload = function() { 

  document.getElementById("loginForm").reset(); 

};