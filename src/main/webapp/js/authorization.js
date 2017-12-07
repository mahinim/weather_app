function validateEmptyField(inputField)
{
	if(inputField.value.length == 0)
	{
		inputField.style.borderColor="red";
		inputField.style.borderWidth="3px"
		inputField.style.backgroundColor="#e89292";
		return false;
	}
	else
	{
		inputField.style.borderColor="white";
		inputField.style.borderWidth="1px";
		inputField.style.backgroundColor="white";
		return true;
	}
}

function validateBtn()
{
	var form1 = validateEmptyField(document.getElementById("email"));
	var form2 = validateEmptyField(document.getElementById("password"));
	
	if(form1 && form2)
	{
		form.submit;
	}
}