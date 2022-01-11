# KnightTourSolution

## Presentation

It is a solution to this problem.
The algorithm uses recursion and backtracking.

There are no test files or a Main class therefore you have to create :

1. Position Object which takes two parameters(int values) that point to the starting position of the knight.

2. KnightProblem Obkect wich takes two parameters, this Position Object and a value(int) which is the size of the table.

There are two methods(without parameters) to find one or more solutions :

1. findKnightSolution() looks for all possible solutions and then we can have the number of solution found with getNumberOfSolution().

2. findOneKnightSolution() looks for one solution, return true if this method find one, else false. You can print this solution with printChessBoard().
