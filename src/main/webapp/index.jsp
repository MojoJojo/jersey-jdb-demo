<!DOCTYPE HTML>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/styles/style.css"/>
<script src="<%=request.getContextPath()%>/resources/scripts/jquery-2.1.4.min.js"></script>
<script type="text/javascript">

function validateForm() {
	
	if($('#txtProductName') && $('#txtProductPrice') ) {
		if(($.isNumeric($('#txtProductPrice').val())) && (/^[A-Za-z]+$/.test($('#txtProductName').val())))
			return true;
		console.log('Not valid');
		return false;

	}
	 

	}
</script>
</head>
<body>

	<div class="body-container">
		<form action="api/products" method="post" class="product-form" onsubmit="return validateForm(this)">
			<fieldset>
				<legend>Add a new product:</legend>
					<label for="productName">Name:</label>
					<input type="text" name="productName" id="txtProductName">
					<label for="productPrice">Price:</label> 
					<input type="text" name="productPrice" id="txtProductPrice"> 
					<div class="submit-area">
						<input type="submit" value="submit">
					</div>
			</fieldset>
		</form>
	</div>
</body>
</html>
