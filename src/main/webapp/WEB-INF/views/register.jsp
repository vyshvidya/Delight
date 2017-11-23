<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ include file="header.jsp"%>
 
    <%@ taglib  uri="http://www.springframework.org/tags/form" prefix= "spr" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel=stylesheet href="/resources/registration.css"/>
<script type="text/javascript">
	function formRegister() {
		// Make quick references to our fields
		
		var username = document.getElementById('user_name_fr');
		var email = document.getElementById('email_id_fr');
		var password = document.getElementById('password_fr');
		var phone = document.getElementById('contactNumber_fr');
		//var address = document.getElementById('address_fr');
	
		// Check each input in the order that it appears in the form!
		
					if (notEmpty(user_name_fr, "Username Should not be empty")) {
							if (isAlphabet(username,
									"Please enter only letters for Username")) {
								if (notEmpty(email,
								"EmailId Should not be empty")) {
									if(emailValidator(email, "Please Enter a valid Email id")){ 
								if (notEmpty(password,
										"password Should not be empty")) {
									if (isAlphanumeric(password,
											"Numbers and Letters Only for Passwords")) {
										if (notEmpty(phone,
												"PhoneNumber Should not be empty")) {
											if (isNumeric(phone,
													"Please enter only number for PhoneNumber")) {
												
																return true;
															
														
													
												}
											}
										}
									}
								}
							}
						}
  }
		return false;
	}
  
  function notEmpty(elem, helperMsg) {
		if (elem.value.length == 0) {
			alert(helperMsg);
			elem.focus(); // set the focus to this input
			return false;
		}
		return true;
	}
  
	function isNumeric(elem, helperMsg) {
		var numericExpression = /^[0-9]+$/;
		if (elem.value.match(numericExpression)) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}
	function isAlphabet(elem, helperMsg) {
		var alphaExp = /^[a-z A-Z]+$/;
		if (elem.value.match(alphaExp)) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}
	function isAlphanumeric(elem, helperMsg) {
		var alphaExp = /^[0-9a-zA-Z]+$/;
		if (elem.value.match(alphaExp)) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}
	function emailValidator(elem, helperMsg) {
		var emailExp = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
		if (elem.value.match(emailExp)) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}
  
	
  </script>


</head>
<body>
<div><div class="container">
<h1>Customer sign up Form</h1>
<div class="col-lg-12">
<div class="row">
<spr:form  action="saveregister" modelAttribute="user" method="post" onsubmit="return formRegister()">
<div class= "col-lg-12">

<div class="form-group">
<label>Email</label>
<spr:input path ="email" placeholder="Enter email id...." class="form-control" id="email_id_fr"/>
</div>

<div class="form-group">
<label>Name</label>
<spr:input path="name" placeholder="Enter name...." class="form-control" id="user_name_fr"/>
</div>

<div class="form-group">
<label>Password</label>
<spr:input path="password" placeholder="Enter password...." class="form-control" id="password_fr"/>
</div>

<div class="form-group">
<label>Phone</label>
<spr:input path="phone" placeholder="Enter phone...." class="form-control" id="contactNumber_fr"/>
</div>

<div class="form-group">
<label>Door no</label>
<spr:input path="billingaddress.doorno" placeholder="Enter Door no...." class="form-control" id="address_fr"/>
</div>

<div class="form-group">
<label>Street name</label>
<spr:input path="billingaddress.streetname" placeholder="Enter Street name...." class="form-control" />
</div>

<div class="form-group">
<label>city</label>
<spr:input path="billingaddress.city" placeholder="Enter city...." class="form-control"/>
</div>

<div class="form-group">
<label>State</label>
<spr:input path="billingaddress.state" placeholder="Enter State...." class="form-control"/>
</div>

<div class="form-group">
<label>Country</label>
<spr:input path="billingaddress.country" placeholder="Enter country...." class="form-control"/>
</div>

<div class="form-group">
<label>Zipcode</label>
<spr:input path="billingaddress.zipcode" placeholder="Enter Zipcode...." class="form-control"/>
</div>
</div>
<button type="submit" class="btn btn-lg btn-info">Submit</button>
<button type="reset" class="btn btn-lg btn-info">Cancel</button>
</spr:form>
</div>
</div>
</div>
</div>


</body>
</html>
<%-- <%@ include file="Footer.jsp"%>
 --%>