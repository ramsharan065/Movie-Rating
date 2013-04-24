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
	var error = false;
	//reset all error statements
	document.getElementById("fullNameError").innerHTML = "";
	document.getElementById("usernameError").innerHTML = "";
	document.getElementById("passwordError").innerHTML = "";
	document.getElementById("rePasswordError").innerHTML = "";
	//for name
	if(name==null || name==""){
		error = true;
		document.getElementById("fullNameError").innerHTML = "It should not be empty";
	}else{
		var regex = new RegExp("^\\s*[a-zA-Z ]{1,50}\\s*$");
		if(!regex.test(name)){
			error = true;
			document.getElementById("fullNameError").innerHTML = "It must contain alphabet and space is optional";
		}
	}
	//for username
	if(username==null || username==""){
		error = true;
		document.getElementById("usernameError").innerHTML = "It should not be empty";
	}else{
		var regex = new RegExp("^[\\w]{1,50}$");
		if(!regex.test(username)){
			error = true;
			document.getElementById("usernameError").innerHTML = "It can contain letter only";
		}
	}
	//for password
	if(password==null || password==""){
		error = true;
		document.getElementById("passwordError").innerHTML = "It should not be empty";
	}else{
		var regex = new RegExp("^.{6,50}$");
		if(!regex.test(password)){
			error = true;
			document.getElementById("passwordError").innerHTML = "length should be atleast 6";
		}
	}
	//for rePassword and password
	if(password!=rePassword){
		error = true;
		document.getElementById("rePasswordError").innerHTML = "Both passwords didn't match";
	}
	return (!error);
}
var mainNav = $('.navs'),
    dropDownLink = $('a[data-toggle=dropdown]');
mainNav.each(function() {
    if ($(this).is(':first-child')) {
        $(this).find('a').addClass('homeLink');
    } else if ($(this).is(':last-child')) {
        $(this).find('a').addClass('lastLink');
    }
});
$('.sub-menu li').each(function() {
    if ($(this).is(':first-child')) {
        $(this).find('a').addClass('innerLinkFirst');
    } else if ($(this).is(':last-child')) {
        $(this).find('a').addClass('innerLinkLast');
    }
    $(this).hover(function() {
        $(this).parent().parent().addClass('open');
    }, function() {
        $(this).parent().parent().removeClass('open');
    });
});
dropDownLink.dropdown();
dropDownLink.each(function() {
    mainNavWidth = $(this).parent().width() - 2,
        mainNavSub = $(this).parent().find('.sub-menu');
    mainNavSub.css({'width': mainNavWidth});
    $(this).append('<span class=\"arrow\" />');
    $(this).click(function() {
        var thisUrl = $(this).attr('href');
        window.location = thisUrl;
    });
});
