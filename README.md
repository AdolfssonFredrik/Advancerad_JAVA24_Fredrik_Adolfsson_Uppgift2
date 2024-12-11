# Student system

--- 


## About

This is a console based system for adding, removing, displaying and storing students using studentID as an identifier. The program is written in Java and is based around a singelton for handling the students. It also stores its data in JSON files.


---

## Getting started

To use this repo do the following:

1. Open Git Bash
2. Go to the directory where you want the project
3. Write the following command
```
git clone https://github.com/AdolfssonFredrik/Advancerad_JAVA24_Fredrik_Adolfsson_Uppgift2.git
```

4. Open the project in your ide of choice and hit run.
5. Done!

---


## Explination

### ClassList

- This class is a singelton and is used for storing and handling the students. The students are stored in a HashMap with the studentID as the ket and the student object as the value. Using this you can get access to the student object with its properties and methods just using the id as an identifier.

### Student

- This class is where the variable for the different students get stored. 
- The variables that get stored are:
  - name (private final String)
  - studentId (private final int)
  - grade (private String)

### Menu
- This class is responsible for the console menu used to interact with the system. It is a pretty simple system, however it does use regex for validating the inputs from the user.
- The regex Strings are as follows:
  - Validating grades: "^[A-F]$".
  - validating name: "[A-Z]"
  - validating studentID: "^\\d+$"


---