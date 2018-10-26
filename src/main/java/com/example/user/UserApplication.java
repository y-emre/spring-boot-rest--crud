package com.example.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}

/*	TEST WITH POSTMAN (FOR CHROME) OR RESTMAN (FOR OPERA)


	SAVING A USER
--------------------------------
	METHOD :		POST
	URI : 			http://localhost:8080/rest/api/users
	Content-type : 	application/json
	DATA :			{ "name" : "Emre", "age" : 24 }


	GETTING ALL USER
--------------------------------
	METHOD :		GET
	URI : 			http://localhost:8080/rest/api/users
	Content-type : 	application/json
	
	FINDING A USER BY ID
---------------------------------
	METHOD :		GET
	URI : 			http://localhost:8080/rest/api/users/1
	Content-type : 	application/json
	
	FINDING A USER BY NAME
---------------------------------
	METHOD :		GET
	URI : 			http://localhost:8080/rest/api/users/byname/Emre
	Content-type : 	application/json
	
	UPDATING A USER
---------------------------------
	METHOD :		PUT
	URI : 			http://localhost:8080/rest/api/users/1
	Content-type : 	application/json
	DATA :			{ "name" : "Yunus", "age" : 25 }
	
	DELETING A USER
---------------------------------
	METHOD :		DELETE
	URI : 			http://localhost:8080/rest/api/users/1
	Content-type : 	application/json
	
*/
