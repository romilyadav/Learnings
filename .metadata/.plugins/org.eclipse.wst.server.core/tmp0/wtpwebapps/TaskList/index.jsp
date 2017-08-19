<html>
<body>
<h2>Hello World!</h2>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.0.0/css/font-awesome.css" />

 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.9/angular.js"></script>
 

<script src="<c:url value='/static/js/app.js' />"></script>
<script src="<c:url value='/static/js/controller/tasklist.controller.js' />"></script>
<script src="<c:url value='/static/js/service/tasklist.service.js' />"></script>



<div ng-app="TaskList">
	<div ng-controller="TaskListController as ctrl">
		<div>{{ctrl.message}}</div>
	</div>
</div>


</body>
</html>
