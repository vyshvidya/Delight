<%@include file="/WEB-INF/views/header.jsp"%>
<%-- <%@include file="/WEB-INF/views/Navbar.jsp"%> --%>

	<div class="container" style="min-height:500px;margin:20px auto;">
	<p><b>Pay via cash or card</b></p>
	<c:url value="/cart/thankyou" var="action" />
	<div class="row">
	<a href="${action}" class="btn btn-success" >Cash On Delivery</a></div>
	<br />
		<div class="row" style="marging:10px auto;">
	<a onclick="myFunction()" id="app"
		class="btn btn-success btn-default " >Card</a></div>
	<div id="myDIV">
		<form action="${action}" class="payment" method="post"
			onsubmit="return formCC()">

			<div class="panel panel-default credit-card-box">
				<div class="panel-heading display-table">
					<div class="row display-tr">
						<h3 class="panel-title display-td">Payment Details</h3>
					</div>
				</div>
			</div>
			<br> <label for="cardNumber">CARD NUMBER</label> <input
				type="text" size="16" id="cname" name="cardNumber"
				placeholder="Valid Card Number"> <label for="cardExpir">EXPIRATION
				DATE</label> <input type="text" size="5" id="cexp" name="cardExpiry"
				placeholder="MM-YY"> <label for="cardCVC">CV CODE</label> <input
				type="text" size="3" id="cvc" name="cardCVC" placeholder="CVC">

			<br> <input type="submit" class="blueButton"
				style="float: right;" value="Confirm Paymet"> <br> <br>
		</form>
	</div>
	</div>
	<%@include file="/WEB-INF/views/Footer.jsp"%>