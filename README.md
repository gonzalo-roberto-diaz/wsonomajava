# Williams Sonoma Java Assignment
Java Code Challenge given by Williams Sonoma

## Overview
The problem consists in processing pairs of integers, representing ranges of US zip codes that have to be
avoided for some reason.

Ranges are given in no particular order, and no guarantees of them being connected, disjoint or overlapping.

The goal of the exercise is to process those pairs, and output a collection of pairs representing the same
information in the most compact way possible.

## Setup
  * java 9+ is needed
  * `git clone https://github.com/gonzalo-roberto-diaz/wsonomajava.git`
  * `cd wsonomajava`
  * [in Windows] `gradlew clean build`
  * [in Unix] `./gradlew clean build`


## Usage
  The challenges are solved by executing in the test class `com.sonoma.MainTest`
  
## Implementation
  A processing utility takes an initial list of ranges, sorts it, and then traverses it while merging 
  overlapping elements as necessary.
  
## Efficiency  
  The complexity of this approach is `sorting complexity + traversing complexity`
  
  (A more refined approach perhaps could have attempted both at the same time).
  
  The time complexity is `O(n*2)`  (worst case scenario if the number of elements is < 47) + 
   `O(n)` for the traversing part.
  
  The space complexity is `O(1)` for both the sorting and traversing parts.
  
  (In this solution, the number of comparisons is higher because of some extra validations and the 
  object equality implementation).
   
  
   