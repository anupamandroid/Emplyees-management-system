
/****************************************** Java Script ********************************************/


function signupvalidation()
{
	var error=document.getElementById("error");
	var text=document.getElementsByClassName("text_error");
	var email=document.getElementById("pwd_error");	
	var pwd=document.getElementById("pwd_error");
	var cpwd=document.getElementById("cpwd_error");

/****************************************** Check Empty Field****************************************/
	for(var i=0;i<text.length;i++)
		{
		if(text[i].value=="")
			{
			error.innerText="Empty field";
			return false;
			}
		}
/****************************************** Check Password Match****************************************/
	
		if(pwd.value !=cpwd.value)
			{
				error.innerText+="and Missmatch password"
				return false;
			}
		return true;
}

/****************************************** Check Login ****************************************/
function loginvalidation()
{
	var error=document.getElementById("error");
	var user=document.getElementById("user").value;
	var pwd=document.getElementById("pwd").value;
	
		if(user=="" && pwd=="")
			{
			error.innerText="Empty field";
			return false;
			}
		return true;
}

function emailvalidtion() {
    var x = document.forms["myForm"]["email"].value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        alert("Not a valid e-mail address");
        return false;
    }
    return true;
}


/************************************************** JavaScript *******************************************/
