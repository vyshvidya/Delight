<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<table cellspacing="2" align="center">
<tr bgcolor="gray">
<td>Price</td>
<td>Product Name</td>
<td>Category</td>
<td>Stock</td>
<td>Photo</td>
</tr>
<c:forEach items="${productList }" var="product">
<tr>
<td>${product.price}</td>
<td>${product.productName}</td>
<td>${product.catId}</td>
<td>${product.stock}</td>
<td>
<a href="productDesc/${product.productId}"></a>
<c:out value="resources/product images/${product.productId}.jpg"/>
<td><img src="<c:url value="/resources/product images/${product.productId}.jpg"/>" width="50px" height="50px"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>