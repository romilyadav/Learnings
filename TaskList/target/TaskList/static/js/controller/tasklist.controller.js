(function(){
	angular.module('TaskList')
			.controller('TaskListController', TaskListController);
	
	TaskListController.$inject = ['TaskListService']
	function TaskListController(TaskListService){
		var vm = this;
		
		init();
		
		function init(){
			vm.message = "Hello World"; 
			Class Task {
				contructor(taskName){
					this.taskName = taskName;
				}
			}
			const task = new Task("help");
			TaskListService.addTask(task):
				
		}

	}
})();