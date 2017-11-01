<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.model.Supplier "
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
     <%@ taglib  uri="http://www.springframework.org/tags/form" prefix= "form" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="AddSupplier" modelAttribute="supplier">
<table align="center" >
<tr >
<td colspan="2">Supplier Details</td>
</tr>

<%-- <tr>
<td>Supplier ID</td>
<td><form:input path="supplierId"/></td>
</tr>
 --%>
<tr>
<td>Supplier Name</td>

<td><form:input path="supplierName"/></td>
</tr>
<tr>
<td>Supplier Address</td>

<td><form:input path="supplierAddress"/></td>
</tr>
<tr>
<td colspan="2">
<center><input type="submit"  value="Insert"/></center>
</td>
</tr>
<table cellspacing="2" align="center">
<tr bgcolor="green">
<td>Supplier ID</td>
<td>Supplier Name</td>
<td>Supplier Address</td>
<td>Operation</td>
</tr>
<c:forEach items="${supplierList }" var="supplier">
<tr bgcolor="cyan">
<td>${supplier.supplierId}</td>
<td>${supplier.supplierName}</td>
<td>${supplier.supplierAddress}</td>

<td>
<c:url value="/deleteSupplier/${supplier.supplierId}" var="del"/>
<a href="${del}">DELETE</a>
<c:url value="/updateSupplier/${supplier.supplierId}" var="update"/>
<a href="${update}">UPDATE</a>
</td>

</tr>
</c:forEach>

</table>
</form:form>
</body>
</html>