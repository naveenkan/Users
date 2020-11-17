# Users
This is spring boot Maven project which provides an api to list the users within 50 miles of london
> This project uses **net.sf.geographiclib** api which provides classes/methods useful to calculate the distance by using latitude and longitude co-ordinates
# How to Use this Project:
Run the application by importing in to IDE/ Using below Maven command line. This project uses swagger, which provides swagger-ui to test the application. 
# Run application using Maven command line
mvn spring-boot:run
# Swagger-ui:
http://localhost:8080/swagger-ui/index.html
# direct url(It is a get request can be trigger directly in browser which returns list of users in json within 50 miles of london):
http://localhost:8080//users/london