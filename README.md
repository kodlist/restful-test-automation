## Objective: RESTFul API Test cases and Test automation using ** [Karate](https://github.com/intuit/karate#quickstart)**  

1. I have used ** [imgur account and its webservices](https://imgur.com)**
2. Test CRUD operations. 
3. In this project work I have automated basic CRUD operations, and considered only positive cases.
4. This work is restful webservices testing.

Technology stack:
-----------------

1. java 8
2. karate open-source tool
3. maven
4. junit 4
5. windows 10 OS
6. cucumber-reporting


Download code:
---------------

Do git clone for downloading the project to your local machine and then import project to your IDE.

Install with [git](https://git-scm.com/downloads):
	
```sh
$ git clone 
``` 


Running test from command line:
------------------------------

1. You can use git bash or any choice of shell.

2. Go to your project directory from terminal and hit below command:

```sh
$ mvn test -Dtest=DemoTestSelected
```

3. Test results or reports can be found in `cucumber-html-reports` folder which is under `target` directory.



Running test from Jenkins:
-------------------------------

1. in progress...


Cucumber feature files:
------------------------


# Few things to understand before executing:

I have seperated `api` to respective feature files and I consider them as called feature files, in other words, the test feature files `e2e` will call
`api` feature file. see below image;

1. Calling feature and called feature




&nbsp;&nbsp;
![](images/big_pic.JPG)



Project Structure:
------------------

&nbsp;&nbsp;
![](images/project_Structure.JPG)


