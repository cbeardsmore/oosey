# oosey
-
###### Object Oriented Software Engineering 200: Design Patterns
-

##### Purpose

A Company training simulator, used to demonstrate the implementation of various design patterns in a Java environment

##### File List

```
src/ - All Java source code
dist/ - Distributed code and complete .jar file
build/ - All .class compiled files
resources/ - Testing files
documentation/ - Assignment report and Specification
build.xml - Ant build file
```

##### Command Line Arguments

The simulator takes 5 command line parameters, specified in the following order:

```
START YEAR
END YEAR
PROPERTY FILE
EVENT FILE
PLAN FILE
```

##### Instructions to Run

An ant build file is included for easy building of the entire system. To build the project:

```
ant
```

To clean the project:

```
ant clean
```

To run the project

```
ant run
```