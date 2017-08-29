README

I implemented a stack using two single linked lists,
one for the main stack where elements are added in a LIFO fashion and
the secondary list to store and track the max value of the stack.

I did a very simple Console app. as the UI for demo purposes, 
and added unit tests to test the functionality.


Requirements
------------
	JDK 1.7 or higher
	Maven 3.3, I used the latest available version Maven 3.3.3
	

Steps to compile and build
--------------------------
1- Unzip ZIP file

	unzip stack.zip

2- Go to ./stack sub directory

	cd ./stack

3- Run Maven using this cmd. line:
	
	mvn package

4- You should see the following success message:

[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ stack ---
[INFO] Building jar: C:\Users\Rogelio\Documents\Projects\stack\target\stack-1.0.0-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS


Steps to run the java console app
----------------------------------
1- In the same ./stack sub directory, launch the console app using this Maven 
cmd. line:

	mvn exec:java 

2- You would see something like this:
...
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building stack 1.0.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- exec-maven-plugin:1.4.0:java (default-cli) @ stack ---

STACK
Please select your choice
...

3- You can interact with the app menu:

	STACK
	Please select your choice
	
	 1 Push
	 2 Pop
	 3 Get Current Max Value
	 4 Get Current Size of the Stack
	 5 Display Stack Content
	 6 Exit
	
	Type your numeric choice number:


End
---
I'm using Maven to build and execute the application.

Thank you!
