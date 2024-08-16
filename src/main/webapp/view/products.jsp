<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/products.css">
<title>Products</title>
</head>
<body>
	
	<div class="container d-flex justify-content-center align-items-center">
		<div class="card border-primary mt-5 w-75">
		<div class="card-header bg-primary text-white text-center fs-3  ">Products</div>
			<div class="card-body text-dark">
				<form action="search.do" method="get">			
					<div class="input-group mb-3">
	  					<input type="text" class="form-control " placeholder="Keyword" name="keyword">
	  					<button class="btn btn-outline-secondary w-25 " type="submit" >search</button>
					</div>
					
					  <c:if test="${not empty param.keyword}">
						  <c:if test="${empty model.p}">
						  	<p class="text-center text-danger">No corresponding data found for your search.</p>
						  </c:if>
					  </c:if>
					  
					  <c:if test="${not empty model.p}">
					  	<table class="table">
                      	<thead class="thead-dark">
                        	<tr>
                    	        <th scope="col" class="px-4">ID</th>
                                <th scope="col" class="ps-2">DESIGNATION</th>
                                <th scope="col" class="px-4">PRICE</th>
                                <th scope="col" class="pe-4">QUANTITY</th>
                        	</tr>
                      	</thead>
                      
						<tbody>					    
							<c:forEach items="${model.p}" var="p">
						 		<tr>
							  		<th scope="row" class="px-4">${p.id}</th>
							  		<td class="ps-2">${p.designation}</td>
							  		<td class="px-4">${p.price}</td>
							  		<td class="pe-4">${p.quantity}</td>
							  	</tr>
						  	</c:forEach>
						</tbody>
						</table>
					  </c:if>
					  
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>