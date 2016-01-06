<!DOCTYPE HTML>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/styles/style.css"/>
<script src="<%=request.getContextPath()%>/resources/scripts/jquery-2.1.4.min.js"></script>
<script type="text/javascript">

function validateForm() {
	
	if($('#txtProductName') && $('#txtProductPrice') ) {
		if(!/^[A-Za-z]+$/.test($('#txtProductName').val())) {
			$('#txtProductName').addClass('error');
			$('#txtProductNameError').text('*Alphabets only');
			return false;
		} 
		else {
			$('#txtProductName').removeClass('error');
			$('#txtProductNameError').text('');
		}
		if(!$.isNumeric($('#txtProductPrice').val())) {
			$('#txtProductPrice').addClass('error');
			$('#txtProductPriceError').text('*Numbers only');
			
			return false;
			
		} 
		else {
			$('#txtProductPrice').removeClass('error');
			$('#txtProductPriceError').text('');
			
		}
			
		return true;
		

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
					<label id="txtProductNameError" class="error-label"></label>
					
					<label for="productPrice">Price:</label> 
					<input type="text" name="productPrice" id="txtProductPrice">
					<label id="txtProductPriceError" class="error-label"></label>
					 
					<div class="submit-area">
						<input type="submit" value="submit">
					</div>
					
			</fieldset>
		</form>
	</div>
</body>
</html>
