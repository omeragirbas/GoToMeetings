Go To Programming Challenge Task – Mutlu Bilge

Automation Framework has been created according to “Programming Challenge” document.

General Information
The framework is built with maven - build automation tool which has pom.xml file that allows
me to manage my dependencies/versions easily.

IntelliJ is used as IDE Tool.

Java – Selenium – TestNG and Junit are implemented the actual coding logic with inside of the
“Tests” package and it their own respective/related classes.

Page Object Model is used to simplify managing and maintaining the framework.

BasePage (Abstract) is created and initiated with “PageFactory” class using “Driver” and “BasePage” constructor.

“ChatPage”, “LoginPage”, “HomePage” and “LoginPage” are created and extended to “BasePage”.

Those pages keeps the respective webelements and some custom methods in the classes in order to call from Test Classes with the help of page objects,
during the code implementation.

TestBase class (Abstract) is created in order to implement some TestNG annotations such as BeforeTest, AfterTest.

“MessageTest”, “ContactTest” and GroupTest” classes are created and extended to the “TestBase” class in order to have resuable codes.
Singleton Design Pattern is used in the "Driver Class" to allow the framework to pass the same instance of the webdriver in one session.

"BrowserUtils Class" is created from existing java library to have some reusable codes.

"ConfigurationReader Class" is created from existing java library to read specific data from configuration.properties file.

"configuration.properties" type of file is created in order to keep the important test data about the framework and some personal data.

“log4j2.xml” file is used for logging the automation steps. With the help of “log4J-core” dependency, user has better tracking ability while automated steps are executing.

“GoToMeeting.log” file is generated automatically. User can find all the logs here.

Test Cases
Note: Those steps below are implemented in the TestBase class with the help of TestNG Annotations (BeforeTest – AfterTest)
Navigating to URL: “https://global.gotomeeting.com”
Login (UserName= ”g2m-user-1@jedix.com”, Password= ”7jx59riE”)
Navigating to Chat Page
Logout

Test Case - 1: Send a message to a user – Implemented in “MessageTest” Class
Steps:

1-Click user name from Contacts List
2-Click message input box
3-Text your message to message input box
4-Click submit button
5-Verify that your message is listed at the bottom

Test Case - 2: Add a new contact to "Contacts" and remove it - Implemented in “ContactTest” Class
Steps:

1-Click "+" icon from right side of "Contacts" title
2-Type to search box a unique part of a contact name or email and verify that Testad76a User15984 has been listed each attempt
3-Click listed contact name
4-Verify that contact name is visible under "Contacts"
5-Hover over mouse to new contact name
6-Click "x" icon
7-Verify that new contact is not visible anymore

Test Case - 3: Create a new group, add some users and delete - Implemented in “GroupTest” Class
Steps:

1-Click "+" icon from right side of "Groups" title
2-Click "New group" button
3-Type a name for new group to "New group name input box"
4-Type contacts name to "Group members" text box and select listed user
5-Click "Create group" button
6-Verify that new group name is listed at top
7-Click human icon at top right in new group window
8-Verify that members' name are correct
9-Click gear icon left side of human icon in new group window
10-Click "Delete Group" button
11-Verify that new group name is not visible anymore

How To Run The Framework

A) With The IDE Tool: IntelliJ is recommended
Inside Test Classes:
Open “GoToMeetings\src\test\java\com\GoTo\tests\MessageTest or
Open “GoToMeetings\src\test\java\com\GoTo\tests\ContactTest or
Open “GoToMeetings\src\test\java\com\GoTo\tests\GroupTest then
Go to class title and click “Green Play Button” left side of the “Class Name” or
Go to @Test annotation and click “Green Play Button” left side of the “Method Name”

With The Help of XML Files:
Run Specific Test:
Go to “ MessageTest.xml”, “ ContactTest.xml” or “ GroupTest.xml” files
Right click
Select “Run”

Run All Tests:
Go to “ AllTests.xml” file
Right click
Select “Run”

With The Help of IntelliJ Maven Lifecycle Menu:
Run All Tests:
Click Maven menu at the right up corner and extend "Lifecycle"
Click "test" or "verify"
“It will trigger all the test classes in alphabetical order.”

With The Help of IntelliJ Terminal:
Run Specific Test:
Go to Intellij Terminal
Type this command to terminal:
mvn test -Dtest=”MessageTest” or
mvn test -Dtest=”ContactTest” or
mvn test -Dtest=”GroupTest” and hit the “Enter”
“It will trigger only specific test class.”

Run All Tests:
Go to Intellij Terminal
Type this command to terminal:
mvn test or
mvn verify and hit the “Enter”
“It will trigger all the test classes in alphabetical order.”

B) Without IDE Tool:
You should download maven and install the maven from that link:
https://maven.apache.org/download.cgi then,
Open your Terminal or Powershell in your PC
Type this command: cd "the directory of the project folder" and hit the enter. (make sure that current
working directory is the project folder)

Run Specific Test:
mvn test -Dtest=”MessageTest” or
mvn test -Dtest=”ContactTest” or
mvn test -Dtest=”GroupTest” and hit the “Enter”
“It will trigger only specific test class.”

Run All Tests:
Type "mvn test" or "mvn verify" and hit the enter
“It will trigger all the test classes in alphabetical order.”

Reports
You can find the reports here: Click to the link TestNG Report or
You can navigate to file path: “GoToMeetings\target\surefire-reports\emailable-report.hmtl” and open with browser

Mutlu Bilge – Software Development Engineer in Test
mutlubilgee@gmail.com
linkedin.com/in/mutlubilge