
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h1>Enter Todo Details</h1>
	<form:form method="post" modelAttribute="todo">
		<!--Mapping this todo with addNewTodoPage function parameter todo  -->

		<fieldset class="mb-1">
			<form:label path="description">Description:</form:label>
			<form:input type="text" path="description" />
			<!-- Mapping description bean of Todo class with this description -->
			<form:errors path="description" cssClass="text-warning" />
		</fieldset>

		<fieldset class="mb-1">
			<form:label path="targetDate">Target Date:</form:label>
			<form:input type="text" path="targetDate" />
			<!-- Mapping description bean of Todo class with this description -->
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>



		<form:input type="hidden" path="id" />
		<form:input type="hidden" path="done" />


		<input type="submit" class="btn btn-success" />
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>

<script type="text/javascript">
	$('#targetDate').datepicker({
		format : 'yyyy-mm-dd',
		startDate : '-3d'
	});
</script>