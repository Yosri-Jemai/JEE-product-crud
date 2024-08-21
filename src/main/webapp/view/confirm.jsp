<%@ include file="/lib.jsp" %>
<%@page import="entities.Product"%>
<%
    Product p = (Product) request.getAttribute("newProduct");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/products.css">
<title>Products - Confirmation</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="container d-flex justify-content-center align-items-center">
		<div class="card border-primary mt-5 w-75">
		<div class="card-header bg-primary text-white text-center fs-3  ">Product saved</div>
			<div class="card-body text-dark">

			  <table class="table table-hover">
				  <thead>
				    <tr>
				      <th scope="col" class="px-4">ID</th>
				      <th scope="col" class="ps-2">Designation</th>
				      <th scope="col" class="px-4">Price</th>
				      <th scope="col" class="pe-4">Quantity</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <th scope="row" class="px-4"><%=p.getId()%></th>
				      <td class="ps-2"><%=p.getDesignation()%></td>
				      <td class="px-4"><%=p.getPrice()%></td>
				      <td class="pe-4"><%=p.getQuantity()%></td>
				    </tr>
				  </tbody>
			</table>
			</div>
		</div>
	</div>
	
</body>
</html>