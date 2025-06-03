function validateRegistrationForm() {
    let fullName = document.getElementById("fullName").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("confirmPassword").value;

    let nameError = document.getElementById("nameError");
    let emailError = document.getElementById("emailError");
    let phoneError = document.getElementById("phoneError");
    let passwordError = document.getElementById("passwordError");
    let confirmPasswordError = document.getElementById("confirmPasswordError");

    // Reset error messages
    nameError.textContent = "";
    emailError.textContent = "";
    phoneError.textContent = "";
    passwordError.textContent = "";
    confirmPasswordError.textContent = "";

    // Name validation (non-empty)
    if (fullName.trim() === "") {
        nameError.textContent = "Please enter your full name.";
        return false;
    }

    // Email pattern check
    let emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!emailPattern.test(email)) {
        emailError.textContent = "Please enter a valid email address.";
        return false;
    }

    // Phone pattern check (10-digit phone number)
    let phonePattern = /^[0-9]{10}$/;
    if (!phonePattern.test(phone)) {
        phoneError.textContent = "Please enter a valid 10-digit phone number.";
        return false;
    }

    // Password validation (min length 3)
    if (password.length < 8) {
        passwordError.textContent = "Password must be at least 8 characters long.";
        return false;
    }

    // Confirm password validation (must match password)
    if (confirmPassword !== password) {
        confirmPasswordError.textContent = "Passwords do not match.";
        return false;
    }

    // If validation passes
    console.log("Registration successful");
    return true;
}

window.onunload = function() { 

  document.getElementById("loginForm").reset(); 

};