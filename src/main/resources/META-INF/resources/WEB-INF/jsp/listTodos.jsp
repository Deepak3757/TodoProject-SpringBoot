<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<title>List of Todos</title>
</head>
<body>
	<div class="container">
		<h1>Welcome ${name}</h1>
		<h2>Your Todos list is below: </h2>
		<table class="table">
			<thead>
				<tr>
					<th>id</th>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Done?</th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete ${todo.id}</a></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add-todo" class="btn btn-success">Add Todo</a>
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	
</body>
</html>