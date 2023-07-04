let login = document.querySelector(".loginButton");
let register = document.querySelector(".registerButton");
let loginForm = document.querySelector(".login-form");
let registerForm = document.querySelector(".register-form");
let goBack = document.querySelector(".return");

var loginTrue = false;
var registerTrue = false;
var buttonsShow = false;

login.addEventListener("click", showForm);

function showForm(){
    if(buttonsShow == true){
        login.classList.remove("loginButton-show");
        register.classList.remove("registerButton-show");
    }
    
    loginForm.classList.add("login-form-move");
    login.classList.add("loginButton-hide");
    register.classList.add("registerButton-hide");
    loginTrue = true;  
}

goBack.addEventListener("click", returning);

function returning(event){
    event.preventDefault();
    if (loginTrue == true){
        loginForm.classList.remove("login-form-move");
        loginTrue = false;
    }

    if (registerTrue == true){
        registerForm.classList.remove("register-form-move");
        registerTrue = false;
    }

    login.classList.replace("loginButton-hide", "loginButton-show");
    register.classList.replace("registerButton-hide","registerButton-show");
    buttonsShow = true;
}