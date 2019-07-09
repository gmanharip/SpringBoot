<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<title>Spring MVC Hello World,nbkbkgiuhbk</title>
</head>

<body>
	<h2>All Employees in Systemnbv</h2>

	<table border="1">
		<tr>
			<th>Employee Id</th>
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
		<c:forEach items="${employees}" var="employee1">
			<tr>
				<td>${employee1.id}</td>
				<td>${employee1.firstName}</td>
				<td>${employee1.lastName}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>