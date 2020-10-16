# User Guide

This user guide will help you use your duke task manager assistant.

## Features 

### Feature 1 
Adding new tasks with or without date.

### Feature 2
List all tasks or list task with given date.

### Feature 3
Find a list of tasks with given keyword or keyphrase.

### Feature 4
Ability to mark tasks as done.

### Feature 5
Ability to delete tasks.

### Feature 6
Ability to save tasks and load them.

## Usage

### Set up the program

Copy indiproj.jar to any location of your computer as you desire.
Copy path information of indiproj.jar

Open command prompt.

Enter - `java -jar <path>`


### `todo` - Add a simple task

With this command you can add a simple task.

Example of usage:

`todo wash clothes`

Expected outcome:

`Got it. I've added this task:`

`[T][n] wash clothes`

`Now you have 1 tasks in the list.`


### `deadline` - Add a task by given date

This command allows you to add a task by given deadline.

Example of usage:

`deadline programming assignment/2020-10-10`

Expected outcome:

`Got it. I've added this task:`

`[D][n] programming assignment (by: Oct 10 2020)`

`Now you have 2 tasks in the list.`


### `event` - Add a task at given date

This command allows you to add a task at given event.

Example of usage:

`event dell computer sales/2020-12-24`

Expected outcome:

`Got it. I've added this task:`

`[E][n] dell computer sales (at: Dec 24 2020)`

`Now you have 3 tasks in the list.`


### `done` - Mark task as done

This command marks a task as done.

Example of usage:

`done 1`

Expected outcome:

`Nice! I've marked this task as done:`

`[T][y] wash clothes`


### `delete` - Delete task

This command removes a task from the list.

Example of usage:

`delete 1`

Expected outcome:

`Noted. I've removed this task:`

`[T][y] wash clothes`

`Now you have 2 tasks in the list.`


### `list` - List all tasks or tasks with given date

This command lists all tasks or only tasks with matching date.

Example of usage:

`list 2020-10-10`

Expected outcome:

`Here are the tasks in your list:`

`1.[D][n] programming assignment (by: Oct 10 2020)`


### `find` - Find a list of tasks with given keyword

With the find command, you can conveniently locate all the tasks
you want with the given keyword.

Example of usage: 

`find dell`

Expected outcome:

`Here are the tasks in your list:`

`2.[E][n] dell computer sales (at: Dec 24 2020)`


### Save and Load feature

You can safely exit the program be assured that all information will
be stored

Example of usage:

`bye`

`java -jar <path>`

`list`

Expected outcome:

`Here are the tasks in your list:`

`1.[D][n] programming assignment (by: Oct 10 2020)`

`2.[E][n] dell computer sales (at: Dec 24 2020)`
