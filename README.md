# Java Student Services Desk

This is a console-based student management system developed in Java. It allows users to manage student records, including adding, modifying, deleting, and viewing students and their enrolled classes using a simple command-line interface.

## Table of Contents

- [Features](#features)  
  - [General Features](#general-features)  
  - [Student Information Management](#student-information-management)  
  - [Class Enrollment System](#class-enrollment-system)  
  - [Command-Line Interface](#command-line-interface)  
- [Class Overview](#class-overview)  
- [Installation and Setup](#installation-and-setup)  
- [Technologies Used](#technologies-used)  
- [License](#license)

## Features

### General Features

- **Auto-Incremented IDs:** Automatically assigns unique IDs to new student records.
- **Persistent Student Map:** Stores student data using a TreeMap for ordered access and search.
- **Input Validation:** Handles user input gracefully and prevents crashes due to bad input.

### Student Information Management

- Add, find, delete, or modify student records using a simple menu.
- Updates student names and class lists interactively.
- Supports listing all registered students in the system.

### Class Enrollment System

- Each student can have multiple classes.
- Modify existing class enrollments interactively.
- Add or remove specific classes from a student’s schedule.

### Command-Line Interface

- Clean, text-based user experience.
- Prompts guide the user through each function step-by-step.
- Case-insensitive command entry for user convenience.

## Class Overview

- `Student` – Represents a student with ID, first name, last name, and list of enrolled classes.
- `Student_Services_Desk` – Main driver class that manages the interactive menu and operations.

## Installation and Setup

1. Clone or download this repository.
2. Open a terminal in the project directory.
3. Compile the Java files:
   ```bash
   javac Student.java Student_Services_Desk.java
4. Run the application:
   ```bash
   java ShoppingMain
   ```

## Technologies Used

- Java  
- Java Collections Framework  
- Object-Oriented Programming

## License

This project is licensed under the MIT License. You are free to use, modify, and distribute this project with attribution.  
