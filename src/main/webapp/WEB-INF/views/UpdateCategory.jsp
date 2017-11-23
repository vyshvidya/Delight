<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.model.Category "
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
     <%@ taglib  uri="http://www.springframework.org/tags/form" prefix= "form" %>
    <%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category-DelightFrontEnd</title>

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
function formCategory() {
var categoryName = document.getElementById('category_name');
var description = document.getElementById('description_fr');
if (notEmpty(categoryName, " Category Name Should not be empty")) 
{
	
	if (isAlphabet(categoryName, "Please enter only letters for Category Name "))
		{
		if (notEmpty(description, "Description Should not be empty")) 
		{
			if (isAlphanumeric(description, "Please enter alpha-numeric characters for Description"))
				{
		return true ;
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
	
</script>

<body>

<!--<form action="AddCategory" method="post">-->
<security:authorize access="hasRole('ROLE_ADMIN')">
<c:url value="/admin/updateCategory" var="update"/>
<form:form action="${update}" modelAttribute="category" onsubmit="return formCategory()">
<table border="2" cellspacing="5px" cellpadding="10px" style="margin:auto">
<tr >
<td colspan="2" class="text-center" style="color:blue";>Category Module</td>
</tr>
<tr>
<!--<td><input type="text" name="catId"/></td>-->
<td><form:hidden path="catId"/></td>
</tr>
<tr>
<td>Category Name</td>
<!--<td><input type="text" name="catName"/></td>-->
<td><form:input path="catName" id="category_name"/></td>
</tr>
<tr>
<td>Category Desc</td>
<!--<td><input type="text" name="catDesc"/></td>-->
<td><form:input path="catDesc" id="description_fr"/></td>
</tr>
<tr>
<td colspan="2">
<center><input type="submit" class="btn" value="UpdateCategory"/></center>
</td>
</tr>
</table>
</form:form>
</security:authorize>
<table class="roundedCorners" style="margin:auto">
<tr bgcolor="gray">
<td>Category ID</td>
<td>Category Name</td>
<td>Category Description</td>
<td>Operation</td>
</tr>
<c:forEach items="${CategoryList }" var="category">
<tr bgcolor="white">
<td>${category.catId}</td>
<td>${category.catName}</td>
<td>${category.catDesc}</td>
<security:authorize access="hasRole('ROLE_ADMIN')">
<td>
<c:url value="/admin/deleteCategory/${category.catId}" var="del"/>
<a href="${del}">DELETE</a>
<c:url value="/admin/updateCategory/${category.catId}" var="update"/>
<a href="${update}">UPDATE</a>
</td>
</security:authorize>
</tr>
</c:forEach>
</table>
</body>
</html>
 <%@ include file="Footer.jsp"%>