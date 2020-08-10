Project Background

This is an automation project that navigates user to: http://www.way2automation.com/angularjs-protractor/webtables/

- Firstly it launches the URL mentioned above.
- It's then adds the user using the methods created on Add_New_User_To_User_Table class
- After the user is added, the next step is to verify that the user was added correctly using method called Verify_Added_User:
  To Verify if the user is added correctly I use Excel data sheet to read first line and user firstname and lastname to verify if they were added.
  

Functionality

- Under I created a class called Add_New_User_To_User_Table that will get all the browser elements 
- I then Created an Add_And_Verify_USer_Tests class that will add user and verify that the user is added correctly

How to run the tests

- Firstly you need to make sure you a row on TestData.x;sx file
- Expand Tests >> right click and run Add_And_Verify_USer_Tests 
- The wait until the tests finishes running the confirm they all passed
