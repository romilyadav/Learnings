(function(){
	angular.module('TaskList')
			.controller('TaskListController', TaskListController);
	
	TaskListController.$inject = ['TaskListService']
	function TaskListController(TaskListService){
		var vm = this;
		class Task{
			constructor(userName, taskDescription, taskStatus){
				this.userName = userName,
				this.taskDescription = taskDescription;
				this.taskStatus = taskStatus;
			}
		}
		
		init();
		
		function init(){
			vm.message = "Hello World"; 
			getTasks();
		}
		
		function markTaskComplete(){
			TaskListService.markTaskComplete(7);
		}
		
		function addTask(){
			const task = new Task("joliver", "Fold Launday", 'N');
			TaskListService.addTask(task);
		}
		
		function deleteTask(){
			TaskListService.deleteTask(6);
		}
		
		function getTasks(){
			TaskListService.getTasks("joliver");
		}

	}
})();