# Longest Compound Word Finder

This Java program implements a Trie data structure to find the longest and second longest compound words from a list of words.

## Table of Contents

- [Intuition & Approach](#Intuition-&-Approach)
- [How it Works](#how-it-works)
- [Prerequisites](#prerequisites)
- [How to Run and Test code in local machine](#How-to-Run-and-Test-code-in-local-machine)
- [Time Complexity](#Time-Complexity)

## Intuition & Approach

When I received the assignment, I was not familiar with the trie data strucure practically. 

1. I reasearched about the problem and related problems like "Longest word in a dictionry". While looking at them, I found out that while all of them can be solved using the traditional methods such as DP, the Trie data structure was as the best way to solve any problem inolving the prefix/suffix strings. 
2. I learned basics of Trie data structures and then implemented it on my local device. 
3. While implementing insertion of word in the trie data structure, I thaghut, what if we can simultaniously check if another word can be formed using the current string.
4. I implemented a recursive function to check if a given word can be formed by concatenating two or more words from the list. The function traverses the Trie for each character in the word, checking for valid prefixes.
5. For each word, I inserted it into the Trie and checked if it could be formed by calling the recursive function. I kept track of the longest and second longest compound words as I iterated through the list.


## How it Works

1. Words are inserted into a Trie data structure using the `insert` method.
2. For each word, the program checks if it can be formed by concatenating two or more words using the `isCompoundWord` method.
3. The program then finds the longest and second longest compound words based on the above criteria.

## Prerequisites

- Java Development Kit (JDK) installed

   ```
       java 21.0.1 2023-10-17 LTS
       Java(TM) SE Runtime Environment (build 21.0.1+12-LTS-29)
       Java HotSpot(TM) 64-Bit Server VM (build 21.0.1+12-LTS-29)
   ```
## How to Run and Test code in local machine

- Download or Clone the repository to your local machine
- Open the repository in your code editor (i.e. VS Code)
- Open "Trie.java" file -> look for the "main" method
- change file name here to : "Input_01.txt", "Input_02.txt"

    ```
        File inputFile = new File("Input_01.txt");    
    ```
- Run Java Code to check the output

## Time Complexity
In worst case the time complexity will be determined by combining :
- insert(): O(L\*N)           (L -> average Length of each word, N -> Number of characters in each word )
- isCompundWord(): O(L\*M)     (L -> average Length of each word, M -> Number of words in each list)

So the worst case Time Complexity: O(L\*N+L\*M)

