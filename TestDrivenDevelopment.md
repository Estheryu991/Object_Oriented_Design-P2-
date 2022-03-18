# *Test Driven Development* (TDD). 
In TDD, test cases 
are written in order to check whether a component behaves as expected. Good 
tests cover as much code as possible and use diverse method inputs. Complex 
methods should have multiple tests in order to cover all paths, and one should 
think of corner cases and special circumstances in which a method could be 
executed. In this exercise, we will revisit the Snakes & Ladders game and 
practice writing good tests using JUnit and Mockito.


## Mocking Frameworks

For this exercise, you will need to use the [Mockito](http://mockito.org/) 
framework for mocking objects. A quick introduction is given in the exercise 
session slides, but you should check the project website to familiarize 
yourself with the framework. In particular, take a look at [the 
documentation](http://mockito.github.io/mockito/docs/current/org/mockito/Mockito.html)
to find out how can you mock objects to your advantage.

In your repo, you have lib folder which contains all the required jars. 
Try to run 'StandardSquareTest', if it runs properly (green), it means mockito is working fine in your machine. 
If you face any problem configuring, try the points mentioned in the Guidelines for your respective IDE.

### Guidelines to use Mockito:
 *Import from 'lib' folder*
- In your repo, you will find a folder names 'lib' which keeps all the external jar you need to use for the exercise.
- Usually it works without any set up, just import the project from file source as usual and you should be good to go; if not refer to one of the given instructions below:
- If you are using *Intellij*, Go to Intellij-> Project structure -> Project setting -> Modules -> Dependencies -> Click on '+' icon -> select 'Library' -> Choose 'lib' under Project Libraries -> Add selected -> Apply -> Ok.
- If you are using *Eclipse*, right-click on the project -> build path -> configure build path -> go to tab 'libraries' -> select 'Add exeternal Jars' -> navigate to the 'lib' folder of the exercise -> select All -> open -> Ok.


## Code coverage

You have seen different qualitative criteria that make up good tests. For 
example, you should keep edge cases in mind when writing tests, and you should 
test one thing at a time, using few assertions per test method.

One quantitative criterion is called *test coverage*. Test coverage measures 
how much code is reached by your tests. For example, this measurement tells 
you whether your tests can reach both branches in an `if then else` construct. 
Of course, it is desirable to cover as much code with the tests as possible. A 
lack of coverage may indicate that you do not use certain kinds of inputs in 
your tests.

To help you determine the coverage of your tests, there are many tools that 
trace which parts of the source code are reached by the tests. For example in IntelliJ
you can right click on a test or test folder and then select `More Run/Debug` -> `Run All tests' with Coverage`.
In case you do not find the coverage option, you can
- Go to the 'setting'(in case of windows) or 'preferences'( in case of mac)-> Plugins->
  search for 'Emma', verify if it is already installed or not. If not installed, install it by selecting "Install JetBrains plugin".

For other IDEs there will also be coverage tools like EclEmma for Eclipse available.

You should use this or any other code coverage tool during this exercise in 
order to make sure that your tests sufficiently cover your code. We will use 
the build in coverage tool from IntelliJ during the corrections to check how well your code is covered. Note 
that you are not required to cover 100% of your code. Your focus should still 
be on the qualitative criteria, but a coverage tool can and will help you come 
up with better tests. An example of code that you probably do not want to test 
is a trivial getter method (e.g. `int getDestination()` which simply returns 
the field `int destination`).


## Problem Description

Your task this week is to improve the code of your Snakes & Ladders and add 
tests. In order to pass this exercise, you must do the tasks described in the 
following two sections (*Testing Snakes & Ladders* and *Covering the code*).


### Testing Snakes & Ladders

You are given an implementation of the Snakes & Ladders game. Unfortunately, this 
implementation is almost untested. Only the test from the exercise session 
slides is there. Your job of course is to change this situation.

`Game#play(Die)` is not properly covered by unit tests. To test this method, 
you must write a test that mocks the `Die` class. In order to do that, you 
should first use the *extract interface* feature (right-click on the 
class `Die`, then choose *Refactor*, and finally choose *extract 
interface...*) to create an interface `IDie` with the method `roll()`. Make 
sure that `Game#play(IDie)` now takes an `IDie` as an argument. Next, write 
unit tests that cover the `Game#play(IDie)` method. You must implement two 
different types of tests that cover `Game#play(IDie)` by using two different 
approaches to mocking as follows:

- In the first variant, you must mock an `IDie` object using Mockito. This 
  way, you can specify the behaviour of some die and do not have to rely on a 
  correct implementation of some die.
- Another approach to mocking is creating explicit mock objects without 
  relying on a framework or library. To do that, you should create a class 
  `MockDie` that implements `IDie`. In this `MockDie`, you should implement 
  the die behaviour as you need it for your test (you are of course free to do 
  whatever you want in `MockDie`).

In the exercise_04 folder of your group repository, create a new text file 
(.txt, .md, pdf - NO docx (this type of file will be ignored by the .gitignore)) 
and write a short paragraph about these two approaches to  mocking. Tell us which 
approach is better in your opinion and why.

Note that you are not allowed to copy the `DieTest` from exercise 2 or the 
files available on the course site.

**You should also write tests for all squares in your game**. Again, you 
should use Mockito to mock the objects that are unrelated to the current test. 
Take a look at the exercise session slides for an example on how to use 
mocking properly in these cases. Make sure that your tests cover various 
scenarios. A single test per square is not enough.

Example scenarios you should test are the following: Does the game work 
correctly when there are `SkipSquare` with 2 players and more than 2 players? Or are the `WormHoleEntrance` and
`WormHoleExit` behave as intended? When you specify the expected 
behaviour (which is your decision), you need to make sure that the tests all pass. If the program 
does not behave as specified in your  tests, change the program.

### A new square

In addition to the existing squares, you have to create, implement, and test 
a new on: the `RollAgainSquare`. When a player steps on this square he/she can
roll the die again and move forward a second time.

Your task here is to implement the square, specify its behaviour, and 
rigorously test it. Use JavaDoc to describe its behaviour and write unit tests 
to cover important cases.

### Covering the code

Use a code coverage tool (default or the above-mentioned ones) to find out which parts of your code 
are covered by your tests. You do not need to achieve 100% coverage (see 
comment in section *Code coverage*). However, if there are parts of your games 
that are not covered, you should write a short statement explaining why you 
don't need to cover these particular parts (i.e. create a .md, txt or pdf file with your
explanation). When you check coverage by running  a single test class, the target class 
should be covered (for example, your `LadderSquareTest` should cover the code of the `LadderSquare`).

### Notes

- The focus in this exercise is on unit tests that test an individual method. 
  Nevertheless, if you feel that it helps with your work, you are free to use 
  tests similar to what we have used in exercise 2 to test the behaviour of 
  the whole system. This does not free you from testing the die and squares 
  with mocking techniques.

- The provided implementation may contain bugs. If you encounter any, you 
  should first double-check whether your test assertions express how you 
  expect the program to behave. Then, fix the bug in the implementation. 
  Changing the tests to make them green is not TDD!
  
## **Do not forget** to mention your contributions for the exercise in the `Contributions.md` file.

## Deadline

Submit your solutions by pushing your code to the git repository by
___Friday, 25 March, 12:00___.
