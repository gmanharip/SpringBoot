<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="page-heading" style="padding-left: 80px;">

<!-- Page Heading -->
<h1>Book Details</h1>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script src="<c:url value="/resources/js/main.js" />"></script>
	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" >

<script>
jQuery(document).ready(function($) {//${book};//

	
	var ii = ${book};//[{"bookId":"1","title":"aaa","price":"12","volume":"12","publishDate":"12-02-88"},{"bookId":"2","title":"bbb","price":"12","volume":"12","publishDate":"12-02-88"}];
	var nn = $('#bok').DataTable({
		"aaData": ii,
		"columns": [
            { "data": "book_id" },
            { "data": "title" },
            { "data": "price" },
            { "data": "volume" },
            { "data": "publish_date" }
        ]
	});
	
	$('#bok tfoot th').each( function () {
        var title = $(this).text();
        $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
    });
	
	nn.columns().every( function () {
        var that = this;
 
        $( 'input', this.footer() ).on( 'keyup change', function () {
            if ( that.search() !== this.value ) {
                that
                    .search( this.value )
                    .draw();
            }
        } );
    } );
	
	 $('#bok tbody').on( 'click', 'tr', function () {
	        if ( $(this).hasClass('selected') ) {
	            $(this).removeClass('selected');
	        }
	        else {
	        	nn.$('tr.selected').removeClass('selected');
	            $(this).addClass('selected');
	        }
	    } );
	 
	 $('#del').click( function () {
		 var sss = $.map(nn.rows('.selected').data(), function (item){
			return item.book_id;
		 });
		 alert(sss);
		 $.ajax({
			type: "POST",
			url: 'bookDelete',
			data: 'id='+sss,
			success: function(data){
				alert('done');
			}
		 });
	    } );
	 
	 //alert(nn.row('selected').data);
	
	
});
</script>
<button action="bookDelete" modelAttribute="bookIdVal" id="del">Delete Book</button>
<br>
<div class="row" style="padding-left: 15px;">

	<table id="bok" class="display" style="width:100%">
        <thead>
            <tr>
                <th>BookID</th>
                <th>Book Title</th>
                <th>Price</th>
				<th>Volume</th>
				<th>publishDate</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>BookID</th>
                <th>Book Title</th>
                <th>Price</th>
				<th>Volume</th>
				<th>publishDate</th>
				
            </tr>
        </tfoot>
        
    </table>
	
</div>
	<br>
<div  >
<h4>Add new Book</h4>
<form:form method="POST"
          action="bookAdd" modelAttribute="bookForm">
             <table>
             	<tr>
                    <td><div class="input-group-prepend"><form:label class="input-group-text" path="book_id">bookId</form:label></div></td>
                    <td><form:input class="form-control" placeholder="Add Book ID" path="book_id"/></td>
                </tr>
                <tr>
                    <td><div class="input-group-prepend"><form:label class="input-group-text" path="title">title</form:label></div></td>
                    <td><form:input class="form-control" placeholder="Add Book Title" path="title"/></td>
                </tr>
                <tr>
                    <td><div class="input-group-prepend"><form:label class="input-group-text" path="price">price</form:label></div></td>
                    <td><form:input class="form-control" placeholder="Add Book price" path="price"/></td>
                </tr>
                <tr>
                    <td><div class="input-group-prepend"><form:label class="input-group-text" path="volume">volume</form:label></div></td>
                    <td><form:input class="form-control" placeholder="Add Book volume" path="volume"/></td>
                </tr>
                <tr>
                    <td><div class="input-group-prepend"><form:label class="input-group-text" path="publish_date">publishDate(dd/mm/yyyy)</form:label></div></td>
                    <td><form:input class="form-control" placeholder="Add Book publishDate" path="publish_date"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
<!--  <div class="input-group mb-3" style="width: 500px;">
  <div class="input-group-prepend">
	<span class="input-group-text" id="basic-addon1">Book Title</span>
  </div>
  <input type="text" id="bokTitle" class="form-control" placeholder="Add Project number" aria-label="Subject Title" aria-describedby="basic-addon1">
</div>
<div class="input-group mb-3" style="width: 500px;">
  <div class="input-group-prepend">
	<span class="input-group-text" id="basic-addon2">Price</span>
  </div>
  <input type="text" id="price" class="form-control" placeholder="Add Project Name" aria-label="Duration in hours" aria-describedby="basic-addon2">
</div>
<div class="input-group mb-3" style="width: 500px;">
  <div class="input-group-prepend">
	<span class="input-group-text" id="basic-addon2">Volume</span>
  </div>
  <input type="text" id="volume" class="form-control" placeholder="Add Project Name" aria-label="Duration in hours" aria-describedby="basic-addon2">
</div>
<div class="input-group mb-3" style="width: 500px;">
  <div class="input-group-prepend">
	<span class="input-group-text" id="basic-addon2">Publish Date</span>
  </div>
  <input type="text" id="publishDate" class="form-control" placeholder="Add Project Name" aria-label="Duration in hours" aria-describedby="basic-addon2">
</div>
<br>
<button id="addBook">Add new Book</button> -->
</div>
</div>
