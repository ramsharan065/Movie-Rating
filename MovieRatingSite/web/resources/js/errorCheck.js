function loginValidate(){
	var username=document.forms["loginForm"]["username"].value;
	var password=document.forms["loginForm"]["password"].value;
	var error = false;
	var message="";
	document.getElementById("usernameError").innerHTML="";
	document.getElementById("passwordError").innerHTML="";
	if(username==null || username==""){
		error = true;
		document.getElementById("usernameError").innerHTML="username is null ";
	}
	if(password==null || password==""){
		error = true;
		document.getElementById("passwordError").innerHTML="password is null ";
		message+="password is null";
	}
	return (!error);
}

function signupValidate(){
	var name = document.forms["signupForm"]["name"].value;
	var username = document.forms["signupForm"]["username"].value;
	var password = document.forms["signupForm"]["password"].value;
	var rePassword = document.forms["signupForm"]["rePassword"].value;
}