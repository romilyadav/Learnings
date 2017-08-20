(function(){
	angular.module('TaskList')
			.factory('TaskListService', TaskListService);
	
	TaskListService.$inject = ['$http']
	function TaskListService($http){
		
		function addTask(task){
			return $http.post("http://localhost:8080/TaskList/addTask", task);
		}
		
		function markTaskComplete(id){
			
			return $http.post("http://localhost:8080/TaskList/markTaskComplete/" + id);
		}
		
		function deleteTask(id){
			return $http.post("http://localhost:8080/TaskList/deleteTask/" + id);
		}
		
		function getTasks(task){
			return $http.get("http://localhost:8080/TaskList/getTasks", {params:{userName: "joliver"}});
		}

		return {
			addTask,
			markTaskComplete,
			deleteTask,
			getTasks
		}
	}
})();