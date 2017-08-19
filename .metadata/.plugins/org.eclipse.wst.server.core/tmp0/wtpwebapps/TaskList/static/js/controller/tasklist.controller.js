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
				constructor(userName, taskDescription, taskStatus){
					this.userName = userName;
					this.taskDescription = taskDescription;
					this.taskStatus = taskStatus;
				}
			}
			
			const task = new Task("joliver", "Fold laundary", 'N');
			TaskListService.addTask(task);
				
		}

	}
})();