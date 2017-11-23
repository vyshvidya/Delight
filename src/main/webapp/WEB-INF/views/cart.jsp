<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.row{
margin-top: 50px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
		<c:if test="${count!=0}">
		<c:url value="/cart/removecart/${i.id}" var="clear"></c:url>
		<a href="${clear}" class="btn btn-danger pull-left"><span
			class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
		<c:url value="/cart/shippingaddressform" var="order"></c:url>
		<a href="${order}" class="btn btn-success pull-right"><span
			class="glyphicon glyphicon-shopping-cart"></span>Check out</a>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ProductName</th>
					<th>Quantity</th>
					<th>Total price</th>
					<th>Remove</th>
				</tr>
			</thead>
			<c:set var="grandtotal" value="0"></c:set>
			<tbody>
				<c:forEach items="${i.cartitems}" var="c">
					<tr>
						<c:url value="/resources/productimages/${c.products.productId}.jpg" var="image"></c:url>
						<td><img src="${image}" height="50" width="70" />
							${c.products.productName}</td>
							
						<td><c:url value="/cart/minus/${c.products.productId}" var="minus"></c:url>
							<a href="${minus}"><span
								class="glyphicon glyphicon-minus-sign"> </span></a> <input
							type="text" value="${c.quantity}"
							style="width: 36px; text-align: center;"> <c:url
								value="/cart/plus/${c.products.productId}" var="plus"></c:url> <a
							href="${plus}"><span class="glyphicon glyphicon-plus-sign">
							</span></a></td>
						<td>${c.totalprice}</td>
						<td><c:url value="/cart/removecartitem/${c.id}" var="remove"></c:url>
							<c:set var="grandtotal" value="${c.totalprice + grandtotal}"></c:set>
							<a href="${remove}" class="label label-danger pull-left"><span
								class="glyphicon glyphicon-remove"></span>Remove</a></td>
					</tr>
						</c:forEach>
							
			</tbody>
		</table>
		<h4 class="text-right">Grandtotal: &#8377; ${grandtotal}</h4>
				
		</c:if>
		<c:if test="${count==0}">
			<center>
			<h4>
				<font color="red">Your Cart is empty :(</font>
			</h4>
			<br>
			<c:url value="/product" var="h"></c:url>
			<a href="${h}" class="btn btn-success"> Add Cart to Products </a> 
			</center>
		</c:if>
		</div>
	</div>
</body>
</html>
