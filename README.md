# User-Service-Spring-CRUD-API

***Setup***

*Using Docker compose:* 

                  run-> docker-compose up -d 

*Without Docker:*  

                   Open it any IDE like Eclipse/Intellij.
                   Set Up a database and put database information to application.properties file.
                   Run the application.
                  
***Documentation***

To use the api's with Swagger Documentation goto: http://localhost:8080/api/v1/swagger-ui.html

*Besides:* 

The Api's of this application given below:

**API-1**:    *Add a User*

  Method: Post
  
  URL:   http://localhost:8080/api/v1/user/add

  Request Body Sample:
  
          {
              "name": "string",
              "email": "string",
              "phoneNo": "string",
              "address": {
                  "division": "string",
                  "district": "string",
                  "upazilla": "string"
              },
              "userType": "STUDENT",
              "isActive": true
         }

**API-2**:    *Add a List of Users*

  Method: Post

  URL:   http://localhost:8080/api/v1/user/add/all

  Request Body Sample:
  
     [
          {
              "name": "string",
              "email": "string",
              "phoneNo": "string",
              "address": {
                  "division": "string",
                  "district": "string",
                  "upazilla": "string"
              },
              "userType": "STUDENT",
              "isActive": true
         },
         {
              "name": "string",
              "email": "string",
              "phoneNo": "string",
              "address": {
                  "division": "string",
                  "district": "string",
                  "upazilla": "string"
              },
              "userType": "STUDENT",
              "isActive": true
         }
     ]
     
     
**API-3**:    *Get All Users*

  Method: Get

  URL:   http://localhost:8080/api/v1/user/get/all
  
  
**API-4**:    *Get User by ID*

  Method: Get

  URL:   http://localhost:8080/api/v1/user/get/id-{id as path variable}
  
  
**API-5**:    *Get User by Email*

  Method: Get

  URL:   http://localhost:8080/api/v1/user/get/email-{email as path variable}

**API-6**:    *Get User by Phone Number*

  Method: Get

  URL:   http://localhost:8080/api/v1/user/get/phone-{phone number as path variable}
  
  
**API-7**:    *Get ALL User by Active Status*

  Method: Get

  URL:   http://localhost:8080/api/v1/user/get/status-{status will be true/false}
  


**API-8**:    *Get ALL User by Catagory*

  Method: Get

  URL:   http://localhost:8080/api/v1/user/get/catagory-{catagory like student, teacher, authority-1 and so on}
  
  
**API-9**:    *Update a User*

  Method: Post
  
  URL:   http://localhost:8080/api/v1/user/update

  Request Body Sample:
  
          {
              "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
              "name": "string",
              "email": "string",
              "phoneNo": "string",
              "address": {
                  "id": 0,
                  "division": "string",
                  "district": "string",
                  "upazilla": "string"
              },
              "userType": "STUDENT",
              "isActive": true
         }
  
**API-10**:    *Delete a User*

  Method: Post

  URL:   http://localhost:8080/api/v1/user/delete
