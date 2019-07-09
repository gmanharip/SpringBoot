<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="page-heading" style="padding-left: 80px;">

<!-- Page Heading -->
<h1>Subject Details</h1>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script src="<c:url value="/resources/js/main.js" />"></script>
	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" >

<script>
jQuery(document).ready(function($) {//${book};//
	var ii = ${subject};//[{"subjectId":"1","subtitle":"aaa","durationInHours":"12"},{"subjectId":"2","subtitle":"bbb","durationInHours":"12"}];
	var nn = $('#sub').DataTable({
		"aaData": ii,
		"columns": [
            { "data": "subject_id" },
            { "data": "subtitle" },
            { "data": "duration_in_hours" }
        ]
	});
	
	$('#sub tfoot th').each( function () {
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
	
	$('#sub tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
        	nn.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );
 
 $('#delSub').click( function () {
	 var sss = $.map(nn.rows('.selected').data(), function (item){
		return item.subject_id;
	 });
	 alert(sss);
	 $.ajax({
		type: "POST",
		url: 'subjectDelete',
		data: 'subid='+sss,
		success: function(data){
			alert('done');
		}
	 });
    } );
});
</script>
<button action="subjectDelete" modelAttribute="subjectIdVal" id="delSub">Delete Book</button>
<br>
<div class="row" style="padding-left: 15px;">

	<table id="sub" class="display" style="width:100%">
        <thead>
            <tr>
                <th>SubjectId</th>
                <th>Subject Title</th>
                <th>Duration in Hours</th>
            </tr>
        </thead>
        <tfoot>
        	<tr>
                <th>SubjectId</th>
                <th>Subject Title</th>
                <th>Duration in Hours</th>
            </tr>
        </tfoot>
        
    </table>
	
</div>
	<br>
<h4>Add new Book</h4>
<form:form method="POST"
   action="subjectAdd" modelAttribute="subjectForm">
      <table>
      	<tr>
             <td><div class="input-group-prepend"><form:label class="input-group-text" path="subject_id">subjectId</form:label></div></td>
             <td><form:input class="form-control" placeholder="Add Subject ID" path="subject_id"/></td>
         </tr>
         <tr>
             <td><div class="input-group-prepend"><form:label class="input-group-text" path="subtitle">subtitle</form:label></div></td>
             <td><form:input class="form-control" placeholder="Add Subject Title" path="subtitle"/></td>
         </tr>
         <tr>
             <td><div class="input-group-prepend"><form:label class="input-group-text" path="duration_in_hours">durationInHours</form:label></div></td>
             <td><form:input class="form-control" placeholder="Add Subject Duration in Hours" path="duration_in_hours"/></td>
         </tr>
         <tr>
             <td><input type="submit" value="Submit"/></td>
         </tr>
     </table>
 </form:form>
<div  >
<!-- <div class="input-group mb-3" style="width: 500px;">
  <div class="input-group-prepend">
	<span class="input-group-text" id="basic-addon1">Subject Title</span>
  </div>
  <input type="text" id="subId" class="form-control" placeholder="Add Project number" aria-label="Subject Title" aria-describedby="basic-addon1">
</div>
<div class="input-group mb-3" style="width: 500px;">
  <div class="input-group-prepend">
	<span class="input-group-text" id="basic-addon2">Duration in Hours</span>
  </div>
  <input type="text" id="subDurInHours" class="form-control" placeholder="Add Project Name" aria-label="Duration in hours" aria-describedby="basic-addon2">
</div>
<br>
<button id="addSubject">Add new Subject</button> -->
</div>
</div>