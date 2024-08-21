<%@ include file="/lib.jsp" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light bg-gradient border-bottom border-5 border-secondary fs-5">
  <div class="container-fluid ">
    <div class="collapse navbar-collapse " id="navbarNav">
      <ul class="navbar-nav">
         <li class="nav-item">
          <a class="nav-link <%= "/search.do".equals(request.getAttribute("currentPath")) ? "fw-bold" : "" %>" href="search.do">Home</a>
        </li>
        <li class="nav-item ms-3">
          <a class="nav-link <%= "/save.do".equals(request.getAttribute("currentPath")) ? "fw-bold" : "" %>" href="save.do">Add Product</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

