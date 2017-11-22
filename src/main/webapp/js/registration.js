function validateEmptyField(inputField)
{
	if(inputField.value.length == 0)
	{
		inputField.style.borderColor="red";
		inputField.style.borderWidth="3px"
		inputField.style.backgroundColor="#e89292";
		document.getElementById(inputField.id+"_help").innerHTML="*";	
		return false;
	}
	else
	{
		inputField.style.borderColor="white";
		inputField.style.borderWidth="1px";
		inputField.style.backgroundColor="white";
		document.getElementById(inputField.id+"_help").innerHTML="";
		return true;
	}
}

function validateEmail(inputField)
{
	var regexp = /@\w/;
	
	if( regexp.test(inputField.value))
	{
		inputField.style.borderColor="white";
		inputField.style.borderWidth="1px";
		inputField.style.backgroundColor="white";
		document.getElementById(inputField.id+"_help").innerHTML="";
		return true;
	}
	else
	{
		inputField.style.borderColor="red";
		inputField.style.borderWidth="3px"
		inputField.style.backgroundColor="#e89292";
		document.getElementById(inputField.id+"_help").innerHTML="*";	
		return false;
	}
}

function validateBtn(form)
{
	var flag = false;
	
	var required_inputs = document.getElementsByClassName("required");
	
	for(var i =0; i<required_inputs.length; i++){
		flag = validateEmptyField(required_inputs[i]);
		if (!flag) break;
	}
	
	if(flag){
		document.getElementsByName("btn")[0].disabled = false;
		document.getElementsByName("btn")[0].setAttribute("class", "btn_enabled");
		document.getElementById("help_form").style.color = "green";
		document.getElementById("help_form").innerHTML="Поля заполнены корректно";
	} else {
		document.getElementsByName("btn")[0].disabled = true;
		document.getElementsByName("btn")[0].setAttribute("class", "btn_disabled");
		document.getElementById("help_form").style.color = "red";
		document.getElementById("help_form").innerHTML="Заполните обязательные поля";
	}
	
	/*
	for(var i =0; i<form.length; i++)
	{
		if(i!= 3 && i!=4 && i!= 6)
		{
			if(validateEmptyField(form[i]))
			{
				flag = true;
			}
			else
			{
				flag = false;
			}
			//flag = validateEmptyField(form[i]);
		}
	}
	if(flag)
	{
		if(validatePassword(form[5]))
		{
			document.getElementById("help_form").innerHTML="";
			form.submit;
		}
		else
		{
		
		}
	}
	else
	{
		document.getElementById("help_form").innerHTML="Заполните обязательные поля";
	}
	*/
}

function onfousEmail()
{
	document.getElementById("email_tooltip").innerHTML="Формат e-mail должен быть вида: example@mail.com"
}

function hideEmailTip()
{
	document.getElementById("email_tooltip").innerHTML="";
}

function validatePassword(inputField)
{
	var value = inputField.value;
	alert('value=' + value);
	var regex =  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{8,}$/;
	
	if(regex.test(value))
	{
		document.getElementById("password_help").innerHTML="";
		document.getElementById("help_form").innerHTML="";
		inputField.style.borderColor="white";
		inputField.style.borderWidth="1px";
		inputField.style.backgroundColor="white";
		alert('true');
	}
	else
	{
		document.getElementById("password_help").innerHTML="*";
		document.getElementById("help_form").innerHTML="Пароль должен содержать не менне 8 символов";
		inputField.style.borderColor="red";
		inputField.style.borderWidth="3px"
		inputField.style.backgroundColor="#e89292";
		alert('false');
	}
}
function allFieldsFull()
{
	var form = document.getElementById("table");
	var flag = false;
	
	for(var i = 0; i< form.length;i++)
	{
		if(i != 3 && i !=4 && i != 6)
		{
			if(!(validateEmptyField(form[i])))
			{
				break;
			}
			flag = true;
		}				
	}
	document.getElementById("button").disabled = !flag;
}

function validateDate()
{
	var currentDate = new Date();
	var inputDate   = Date.parse(document.getElementById("birth_date"));
	alert("current date "+currentDate+"/n"+"inputDate "+inputDate);
	if(inputDate > currentDate)
	{
		document.getElementById("help_form").innerHTML="Дата рождение не может быть больше текущей даты";
	}
}