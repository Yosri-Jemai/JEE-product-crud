<%@ include file="/lib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="css/products.css">
<title>Product - Add</title>
</head>
<body>
	<%@include file="header.jsp" %>
	
	<div class="container d-flex justify-content-center align-items-center">
		<div class="card border-primary mt-5 w-75">
		<div class="card-header bg-primary text-white text-center fs-3  ">Add Product</div>
			<div class="card-body text-dark">
				
				<form action="confirmation.do" method="post">
					<div class="input-group mb-3">
					  <span class="input-group-text" style="width:130px;" >Designation</span>
					  <input type="text" class="form-control" name="designation" required>
					</div>
					<div class="input-group mb-3">
					  <span class="input-group-text" style="width:130px;" >Price</span>
					  <input type="number" class="form-control" step="any" name="price" required>
					  
					  <span class="input-group-text" style="width:130px;">Quantity</span>
					  <input type="number" class="form-control" name="quantity" required>
					</div>
					<button class="btn btn-outline-secondary w-25" type="submit" >save</button>
					
				</form>
				
			</div>
		</div>
	</div>
</body>
</html>