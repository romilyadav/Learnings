(function(){
	angular.module('TaskList')
			.factory('TaskListService', TaskListService);
	
	TaskListService.$inject = ['$http']
	function TaskListService($http){
		
		function addTask(task){
			return $http.post("http://localhost:8080/TaskList/addTask", task);
		}

		return {
			addTask
		}
	}
})();