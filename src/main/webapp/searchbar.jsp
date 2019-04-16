<header class="section-header">
	<section class="header-main shadow-sm">
		<div class="container">
			<form action="shop/search" method="post">
				<div class="input-group w-100">
					<select class="custom-select" name="category">
						<option value="all">All Furniture</option>
						<option value="types">Types</option>
						<option value="rooms">Rooms</option>
					</select>
				
				    <input name="search" type="text" class="form-control" style="width:50%;" placeholder="Search">
				    <div class="input-group-append">
					    <button class="btn btn-warning" type="submit">
					        <i class="fa fa-search"></i>  Search
					    </button>
					</div>
					&nbsp;&nbsp;&nbsp; <!-- Spaces -->
					<button class="btn" type="button" data-toggle="modal" data-target="#filterForm">
						<i class="fa fa-filter"></i>  Filter
					</button>
					&nbsp;&nbsp;&nbsp; <!-- Spaces -->
			    </div>
			</form>
		</div>
		<br>
	</section>
</header>

<jsp:include page="filterModal.jsp"></jsp:include>
<br>