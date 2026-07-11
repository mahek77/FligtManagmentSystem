function signup() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;

    if (username === "" || password === "" || confirmPassword === "") {
        alert("Please fill all fields");
        return;
    }

    if (password !== confirmPassword) {
        alert("Password and Confirm Password do not match");
        return;
    }

    fetch("/login/signup?username=" + username + "&password=" + password, {
        method: "POST"
    })
    .then(function(response) {
        if (response.ok) {
            alert("Account created successfully. Now login");
            window.location.href = "login.html";
        } else {
            alert("Username already exists or signup failed");
        }
    })
    .catch(function(error) {
        alert("SignUp error. Check backend.");
        console.log(error);
    });
}