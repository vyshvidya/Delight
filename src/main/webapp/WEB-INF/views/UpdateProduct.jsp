<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.model.Product"
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
<!--<form action="AddCategory" method="post">-->
<c:url value="/updateProduct" var="update"/>
<form:form action="${update}" modelAttribute="product">
<table align="center" cellspacing="2" >
<tr >
<td colspan="2">Product Module</td>
</tr>
<tr>
<td>Product ID</td>
<!--<td><input type="text" name="catId"/></td>-->
<td><form:input path="productId"/></td>
</tr>
<tr>
<td>Product Name</td>
<!--<td><input type="text" name="catName"/></td>-->
<td><form:input path="productName"/></td>
</tr>
<tr>
<td>Product Desc</td>
<!--<td><input type="text" name="catDesc"/></td>-->
<td><form:input path="productDesc"/></td>
</tr>
<tr>
<td>Product Stock</td>

<td><form:input path="stock"/></td>
</tr>

<tr>
<td>Product Price</td>

<td><form:input path="price"/></td>
</tr>
<tr>
<td>Category</td>

<td>
<form:select path="catId">
<form:option value="0" label="---Select---"/>
<form:options items="${categoryList}"/>
</form:select>

</td>
</tr>

<tr>
<td>Supplier</td>
<td><form:input path="supplierId"/></td>
</tr>

<tr>
<td colspan="2">
<center><input type="submit"  value="UpdateProduct"/></center>
</td>
</tr>
</table>
</form:form>
<table cellspacing="2" align="center">
<tr bgcolor="green">
<td>Product ID</td>
<td>Product Name</td>
<td>Product Description</td>
<td>Operation</td>
</tr>
<c:forEach items="${productList}" var="product">
<tr bgcolor="cyan">
<td>${product.productId}</td>
<td>${product.productName}</td>
<td>${product.productDesc}</td>

<td>
<a href="<c:url value="deleteProduct/${product.productId}"/>">DELETE</a>
<a href="<c:url value="updateProduct/${product.productId}"/>">UPDATE</a>
</td>
</tr>
</c:forEach>
</table>


</body>
</html>