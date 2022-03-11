# Training 3
The third lecture covers *Design By Contract*, a methodology for designing 
systems by specifying pre- and post conditions (i.e., input requirements and 
output guarantees), as well as class invariants (i.e., conditions that must 
hold between public method calls). In this exercise, we practice this 
methodology by implementing a simple interactive game. 


## Problem Description
ITDM Inc. wants to show through a study that children grown up driving a virtual car
(using car simulator) could increase their chance to pass the driving exam in their first attempt.
Your goal is to help ITDM Inc. in writing a simulation program that will facilitate the users
to drive their own car around and get familiar with the basic car moves.

The program is composed of the following commands (one command per 
line), instructing a car (the object to be moved around) on how to drive over a computer screen:
So your goal for this Exercise is to help ITDM Inc. to write a program that allows users
to drive their own car around and get familiar with the basic moves.

In essence, we expect you to write programs composed of the following commands (one command per 
line), telling a Car (the object to be moved around) how to drive over the screen:



- `left`
	- Turns the car left 90° (counterclockwise).
- `right`
    - Turns the car right 90° (clockwise).
- `forward n`
    - Moves the car by `n` steps in the direction it is facing.
- `backward n`
    - Moves the car by `n` steps in the opposite direction it is facing.
- `drive x y`
    - Creates a straight line (as far as possible) to the given point `x, y`.
    - It should follow the board coordinates (the car should reach at the x,y point).
    - In which direction should the car first move is up to you.

You start with an empty class `BoardMaker`, which returns a 100x100 `boolean[][]`
matrix. An entry in the matrix denotes whether that particular field has been 
touched (thus resulting in the drawing of the red trace) or not.

Your task is to implement the driving car simulator. 
You are free to add as many classes as you 
want, and you are allowed to modify the existing ones except for `CarRenderer` class.

In order to pass this exercise, your solution *must* meet the following 
criteria:

* Split parsing and execution of programs in separate classes / objects.

* In your API documentation, explicitly state pre- and post conditions.

* Check pre- and post conditions using the `assert` keyword.

- Check class invariants.

* Your solution must reasonably deal with all input programs, in exactly the 
  place that your contracts prescribe.

* Write proper class comments. You should explain the class responsibilities 
  and state invariants.Try to document maximally possible details of classes in the class comment.

* Include a UML class diagram that shows the communication and connections 
  between your classes.

* Include a UML sequence diagram that shows the method invocations that happen 
  in your program when the method `makeBoardFrom` (from class `BoardMaker`) is
  called.

* Both UML diagrams must be created manually (you are not allowed to use tools 
  that generate diagrams from source code). Scan your handwritten diagrams or 
  take a photo.

* Note that you can not assume that the input is always a correct car 
  program. For example, if you run the GUI, `BoardMaker.makeBoardFrom` is 
  called after every single keystroke. Your program should deal with invalid 
  input, for example by ignoring commands that can not be parsed.

ITDM Inc. Thank you in advance for your cooperation to make the world a better place!


## Hints
- You can play the game interactively by running the main method of the 
  `CarRenderer` class. This class implements a simple GUI where you can 
  enter a car program which is used with the `BoardMaker` class in 
  order to render the trail of the car.

- You can proceed to solve the tasks by creating e.g. (names can be changed) North/South/East/West classes to represent the Board directions. This approach will make it easier for you to write code for the car turns (when turning left or right). This will help you for the part in which the car is supposed to make the moves according to the last direction it is facing.

- **Make sure that assertions are turned on**. Otherwise, the contracts are 
  not checked when you run the program.

- Keep the reading material from the last exercise (in particular the sections on how to format doc comments) in mind.

- Remember that class invariants only need to hold before and after *public* 
  method calls.

- **Read the comment in `BoardMaker.makeBoardFrom`**, which outlines an 
  approach you could take for solving the exercise.


## Mandatory Reading Material
- *Applying 'Design by Contract'* by Bertrand Meyer (available on the course 
  website). The contents are relevant to the exam.


## Optional Tasks
Quick note: Please before trying to do an optional task, finish the mandatory
tasks, since optional tasks will not substitute the mandatory tasks.

If you are interested in pursuing more in this exercise, here are some other optional features you can implement by yourself (you can do whatever you want, you don't have to choose from these examples):

- `teleport x y`: The car will reach a new position in the board without leaving a red path behind.

- `invert`: All the commands previously programmed will be inverted and perform
the opposite as they were supposed to do.

## **Do not forget** to mention your contributions for the exercise in the `Contributions.md` file.

## Deadline
Submit your solutions by pushing your code to the git repository by
___Friday, 18 March, 12:00___.
