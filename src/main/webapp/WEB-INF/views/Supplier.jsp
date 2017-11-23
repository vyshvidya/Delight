<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.model.Supplier "
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
     <%@ taglib  uri="http://www.springframework.org/tags/form" prefix= "form" %>
     <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
     <%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
table.roundedCorners { 

 
  border: 1px solid DarkOrange;
  border-radius: 13px; 
  border-spacing: 0;
  }
table.roundedCorners td, 
table.roundedCorners th { 
  /* border-bottom: 1px solid DarkOrange; */
  padding: 10px; 
  }
table.roundedCorners tr:last-child > td {
  border-bottom: none;
}
.btn {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 10px 22px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 2px 1px;
    cursor: pointer;
}
.btn{background-colou: r#f44336;}

</style>


</head>
<script>
function formSupplier() {
	var supplierName = document.getElementById('supplierName_fr');
	
	
	
	if (notEmpty(supplierName_fr, " Supplier Name Should not be empty")) 
	{
		
		if (isAlphabet(supplierName, "Please enter only letters for Supplier Name "))
			{
					
				
			return true ;
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
	
	
	
	
</script>

<body>
<security:authorize access="hasRole('ROLE_ADMIN')">
<c:url value="/admin/AddSupplier" var="supp"></c:url>	

<form:form action="${supp}" modelAttribute="supplier" onsubmit="return formSupplier()">
<table border="2" cellspacing="5px" cellpadding="10px" style="margin:auto">
<tr >
<td colspan="2" class="text-center" style="color:blue";>Supplier Details</td>
</tr>

<%-- <tr>
<td>Supplier ID</td>
<td><form:input path="supplierId"/></td>
</tr>
 --%>
<tr>
<td>Supplier Name</td>

<td><form:input path="supplierName" id="supplierName_fr"/></td>
</tr>
<tr>
<td>Supplier Address</td>

<td><form:input path="supplierAddress" /></td>
</tr>
<tr>
<td colspan="2">
<center><input type="submit" class="btn" value="Insert"/></center>
</td>
</tr>
</table>
</form:form>

</security:authorize>
<table class="roundedCorners" style="margin:auto">
<tr bgcolor="gray">

<td>Supplier Name</td>
<td>Supplier Address</td>
<security:authorize access="hasRole('ROLE_ADMIN')">
<td>Operation</td>
</security:authorize>
</tr>
<c:forEach items="${supplierList }" var="supplier">
<tr bgcolor="white">
<%-- <td>${supplier.supplierId}</td> --%>
<td>${supplier.supplierName}</td>
<td>${supplier.supplierAddress}</td>
<security:authorize access="hasRole('ROLE_ADMIN')">
<td>
<c:url value="/admin/updateSupplier/${supplier.supplierId}" var="update"/>
<a href="${update}">UPDATE</a>
<c:url value="/admin/deleteSupplier/${supplier.supplierId}" var="del"/>
<a href="${del}">DELETE</a>

</td>

</security:authorize>
</tr>
</c:forEach>

</body>
</html>
 <%@ include file="Footer.jsp"%>