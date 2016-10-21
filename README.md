#oosey
-
######Object Oriented Software Engineering 200: Design Patterns
-

#####Purpose

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

asddadsdadsdsa

##### Instructions to Run

The make command will render 30 frames in the rendered folder and convert all the PNG images to a single GIF animation. To manually render the images in povray use:

```
povray povray.ini
```

To convert the rendered images into a single gif. This enables antialiasing and gives a framerate of 100/n frames per second. The convert program requires the *imagemagick* package to run.

```
convert -antialias -delay N rendered/*.png rendered/ani.gif
```