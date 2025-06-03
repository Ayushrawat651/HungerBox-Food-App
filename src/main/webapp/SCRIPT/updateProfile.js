function onEdit(){
    event.preventDefault();
    console.log("ghjsdf");
    document.getElementById("edit").style.display = "none";
    document.getElementById("save").style.display = "block";
    var cl = Array.from(document.getElementsByClassName("editInput"));
    console.log(cl);
    cl.forEach(element => {
        console.log(element)
        element.readOnly = false;
    });
}
/*
function checkpwd(){
	let password = document.getElementById("password").value;
	let confirmPassword = document.getElementById("confirmPassword").value;
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
}*/