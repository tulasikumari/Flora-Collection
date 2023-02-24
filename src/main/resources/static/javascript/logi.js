const sign_in_btn = document.querySelector("#sign-in-btn");
const sign_up_btn = document.querySelector("#sign-up-btn");
const container = document.querySelector(".container");

sign_up_btn.addEventListener("click", () => {
  container.classList.add("sign-up-mode");
});

sign_in_btn.addEventListener("click", () => {
  container.classList.remove("sign-up-mode");
});


$("#search-icon").click(function() {
  $(".nav").toggleClass("search");
  $(".nav").toggleClass("no-search");
  $(".search-input").toggleClass("search-active");
});

$('.menu-toggle').click(function(){
   $(".nav").toggleClass("mobile-nav");
   $(this).toggleClass("is-active");
});

// var attempt = 3; // Variable to count number of attempts.
// // Below function Executes on click of login button.
// function validate(){
//     const username = document.getElementById("username").value;
//     const password = document.getElementById("password").value;
//     if ( username == "admin" && password == "admin"){
//         alert ("Login successfully");
//         // window.location = "homepage.html"; // Redirecting to other page.
//         return false;
//     }
//     else{
//         attempt --;// Decrementing by one.
//         alert("You have left "+attempt+" attempt;");
// // Disabling fields after 3 attempts.
//         if( attempt == 0){
//             document.getElementById("username").disabled = true;
//             document.getElementById("password").disabled = true;
//             document.getElementById("submit").disabled = true;
//             return false;
//         }
//     }
// }

// var attempt = 3; // Variable to count number of attempts.
// // Below function Executes on click of login button.
// function validate() {
//     var username = document.getElementById("username").value;
//     var password = document.getElementById("password").value;
//     if (username == "admin" && password == "admin") {
//         alert("Login successfully");
//         window.location = "success.html"; // Redirecting to other page.
//         return false;
//     } else {
//         attempt--;// Decrementing by one.
//         alert("You have left " + attempt + " attempt;");
// // Disabling fields after 3 attempts.
//         if (attempt == 0) {
//             document.getElementById("username").disabled = true;
//             document.getElementById("password").disabled = true;
//             document.getElementById("submit").disabled = true;
//             return false;
//         }
//     }
// }


const validate= () => {
    const usernameValue = username.value.trim();
    const emailValue = email.value.trim();
    const passwordValue = password.value.trim();
    const password2Value = password2.value.trim();

    if(usernameValue === '') {
        setError(username, 'Username is required');
    } else {
        setSuccess(username);
    }

    if(emailValue === '') {
        setError(email, 'Email is required');
    } else if (!isValidEmail(emailValue)) {
        setError(email, 'Provide a valid email address');
    } else {
        setSuccess(email);
    }

    if(passwordValue === '') {
        setError(password, 'Password is required');
    } else if (passwordValue.length < 5 ) {
        setError(password, 'Password must be at least 5 character.')
    } else {
        setSuccess(password);
    }

    if(password2Value === '') {
        setError(password2, 'Please confirm your password');
    } else if (password2Value !== passwordValue) {
        setError(password2, "Passwords doesn't match");
    } else {
        setSuccess(password2);
    }

};
