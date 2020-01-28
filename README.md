# MicroEcommerce-Demo-Spring
Spring Boot project created to present the fundamentals of microservice architecture.


For further details, comments explaining the annotations and other information, can  be found in different places in the code.
Project Description : 
creating a project to manage products

# V1.0 Setting up code structure 
1- Creating Product Model
2- Creating ProductDao interface and ProductDaoImpl class that will implement it 
3- Creating the controller that uses the ProductDao to call the requested service ( calling methods from ProductDao)
5- Testing  with Postman 
	- Note : we can create testing scenario (testing several requests), using 'Collections' in Postman, this is quiet useful to avoid reinserting data and URLs.)
						 (for example : 1/ Display the list of products 2/Adding a product 3/Display the products list to check the update))
	- Links for testing can be found above each method
	
# V1.1 Added static/dynamic filtering exmaple
1- Added the type of response while sending a Post request ( add a product) so we can check whether it was successfully added and return its URI
2- Added static filter ( using @JsonIgnore / @JsonIgnoreProperties annotations in Product Bean ), it's used to hide a specific/multiple properties
3- Replaced it using a dynamic one to filter properties depending on condition ( using @JsonFilter , and editing listProducts() in ProductController)

# V2.0 Connecting with a database
1- Editinig class Produt (added @Entity, @Id, @GeneratedValue)  (Note : added JPA dependency to pom..xml)
2- preparing h2 database ( auto-configured Spring Boot database) 
	- added H2 dependency to pom.xml &  edit application.properties
	- added 'data.sql' to ressource folder, it will be used to add static data in the database for testing ( this file will be automatically excuted after creating the table in the database)
3- Added CRUD methods
	- Commented producDaoImpl and extended JpaRepository in the ProductDao interface
	- added JPA methods in ProductDao interface 

# V3.0 Handling exceptions, validators, documentation using Swagger2
1- Created ProductNotFoundException class and call it when given an 'id' that doesn't exist in delete method
2- Added validators in Product Bean , to add constraints to some fields (Note : Do not forget @Valid annotaion in add method in ProductController)
3- Configuring Swagger for docmentation of methods ( link used to see documentqtion : http://localhost:8080/swagger-ui.html )
	- Creating SwaggerConfig class for general documentation
	- added documenation of methods using annotaions in ProductController class
	
	This is a picture that summeraizes the different implemented APIs and the Product model preperties :
	
![Summary](https://user-images.githubusercontent.com/22817092/73225959-ae9db300-416e-11ea-9a59-b052651e6efc.PNG)




