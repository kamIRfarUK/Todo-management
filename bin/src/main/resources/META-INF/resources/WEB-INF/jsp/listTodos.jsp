

<%@ include file="common/navigation.jspf" %>
<%@ include file="common/header.jspf" %>
					
		<div class="container">
		
			<div>Todo List Page</div>
			<div>WELCOME ${todo.username} </div>
			
			<div>Here are your todos </div>
			
			<table class="table">
				<thead>
					<tr>
						
						<th>DESCRIPTION</th>
						<th>TARGET DATE</th>
						<th>TASK COMPLETED?</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="todo">
						<tr>
							
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>	
							<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a></td>
							<td><a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE</a></td>			
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<a href="add-todo"class="btn btn-success">ADD TODO </a>
		</div>	
		
				
<%@ include file="common/footer.jspf" %>		
		