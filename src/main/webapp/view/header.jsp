<%@ include file="/lib.jsp" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
         <li class="nav-item">
          <a class="nav-link <%= "/index.do".equals(request.getAttribute("currentPath")) ? "fw-bold" : "" %>" href="index.do">Home</a>
        </li>
        <li class="nav-item ms-3">
          <a class="nav-link <%= "/addProduct.do".equals(request.getAttribute("currentPath")) ? "fw-bold" : "" %>" href="addProduct.do">Add Product</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

