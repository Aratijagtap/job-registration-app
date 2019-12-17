------------------------------------------------------------------------------------

Job Registration Application - README.md

-------------------------------------------------------------------------------------
I. LICENSE

The license agreement (EULA) can be found in the same
directory.

II. DOCUMENTATION

III. DIRECTORY LAYOUT
	1. src
		- main
			- java
				- com.job.register
					- controller
					- dao
					- dto
						- request
						- response
					- entities
					- exception
					- service
		- resources
			- application.properties
			- job-registration.json
	2. pom.xml
	
IV. Steps to build application
Execute "mvn clean install" command on root directory of project

V. Step to run application
Execute "mvn spring-boot:run" command on root directory of project

VI. Import "job-registration.json" file from resources in Postman.

VII. Sequence of REST API.
	When we are giving exam details with candidate then it will create new entry in Exam table for each candidate
	But it will create redundant record in Exam table so considering this approach i used to add Exam details fiest in Exam table and then 
	Candidate can give thier details with List of Exam name.
        - Create exam by providing position and date in string format
        - Create candidate by providing information and passing array of exam name created in previous step.