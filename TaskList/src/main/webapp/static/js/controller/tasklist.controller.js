(function(){
	angular.module('TaskList')
			.controller('TaskListController', TaskListController);
	
	TaskListController.$inject = ['TaskListService']
	function TaskListController(TaskListService){
		var vm = this;
		
		init();
		
		function init(){
			vm.message = "Hello World"; 
			class Task{
				constructor(userName){
					this.userName = userName;
				}
			}
			
			const task = new Task("ashok");
			TaskListService.addTask(task);
				
		}

	}
})();