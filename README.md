# Number Range Summarizer

## Overview
This project implements the provided `NumberRangeSummarizer` interface in Java.  
It takes a comma-delimited string of numbers, collects them into a `Collection<Integer>`, and summarizes them into a string where sequential numbers are grouped into ranges.

**Example:**

Input: `"1,3,6,7,8,12,13,14,15,21,22,23,24,31"`  
Output: `"1, 3, 6-8, 12-15, 21-24, 31"`

## Requirements
- Java 21
- Maven

## Build & Test
From the root, run the following commands.

1. Clean and compile the project:

```bash
mvn clean compile
mvn test
```

