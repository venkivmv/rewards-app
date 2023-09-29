# Rewards-Service 


# Getting Started


# Overview



The following APIs were implemented as part of building this project:

1.Used Java 8 for the Project.

2. Spring Boot, Spring Data JPA has been used in this microservice

3.We are using in memory database.

4.Below are the REST APIs

   a. For Posting the Purchase
	  i. post list of purchase

   b. For  Rewards
	  i.   get total rewards for given time frame
	  ii.  get rewards by each customer for given time frame
	  iii. get each purchase for a customer with rewards for given time frame
	  

	


Postman collection of APIs
https://www.getpostman.com/collections/5b6c15148c82d94f0678
	




###  Prerequisite
- PostgreSQL Database
- Java 8
- Maven 	
- React

###  Build Backend Project
- Go to project dir rewards
- mvn clean install


###  Build Frontend and Run Project
- Go to project dir reward-app
- npm i
- npm start


###  Run Project
java -jar rewards-0.0.1.jar

###
- Application will open at http://localhost:3000
- You can upload sample purchase data by the upload tab on UI
- Then you can check rewards for any given month
- Also we can check a particular customer transactions

