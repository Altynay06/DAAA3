Sorting Algorithms – Assignment 2
Project Overview

This project is developed as part of Assignment 2 for the course Data Analysis and Algorithms.
The goal of this work is to implement and test different sorting algorithms in Java, using Maven for project management and JUnit for testing.

In this part of the project, the Insertion Sort algorithm is implemented and verified through unit tests.

Algorithm Description

Insertion Sort is a simple sorting algorithm that works similarly to how people arrange playing cards in their hands.
It builds the sorted array one element at a time by comparing each new element to those already sorted and inserting it into the correct position.

Main idea:

Start from the second element.

Compare it with the previous elements.

Insert it into the correct position.

Repeat until all elements are sorted.

Time Complexity:

Best case: O(n) (already sorted array)

Worst case: O(n²) (reversed array)

Space Complexity: O(1)

Project Structure
src/
 └── main/
     └── java/
         └── daaa2/algorithms/
             └── InsertionSort.java
 └── test/
     └── java/
         └── daaa2/algorithms/
             └── InsertionSortTest.java
pom.xml
README.md

How to Run the Project

Make sure Java 17+ and Maven are installed.

Open the project folder in the terminal.

Run the following command:

mvn clean test


The tests will run automatically, verifying that the sorting algorithm works correctly.

Testing

JUnit 5 is used for testing.
The test file InsertionSortTest.java compares the output of the custom algorithm with Java’s built-in Arrays.sort() to ensure correctness.

Conclusion

The Insertion Sort algorithm was successfully implemented and tested.
All test cases passed, confirming that the algorithm sorts integer arrays correctly.
The project structure follows Maven standards and is ready for further extensions (e.g., adding Merge Sort or Quick Sort).
