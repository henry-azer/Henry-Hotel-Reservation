# Hotel-Reservation
Project Deployment
Here is a host of this project to view and try it live on Heroku website:

https://henry-hotel-reservation.herokuapp.com

Limited free Database.

username: henry@yahoo.com , 
password: henry0123

Hotel Room Booking Management System,
 It’s a Web project using Spring Framework in java, Spring Boot in back-end with Thymeleaf template engine for manage front-end, In addition to Spring Security to handle authentication and authorization, And Java Persistence API (JPA) with entity manager to handle MySql connector with database.
Entity classes defined and two Structural Patterns Services and Dao, And using Maven build tool to manage project architecture for classes, resources and dependencies.
In the website you can sign up and get a new account of your own and login, every account can book, update and delete reservation form (CRUD) features.

UML System Design

 ![UML](https://github.com/Henry-Azer/Hotel-Reservation/blob/master/src/main/resources/static/github%20images/Hotel%20Room%20Booking%20Management%20System%20UML.jpg?raw=true)
 
Hotel System Design Architecture

•	Using Maven Build Tool.

![Maven](https://github.com/Henry-Azer/Hotel-Reservation/blob/master/src/main/resources/static/github%20images/maven.png?raw=true)
 
•	Back-End Packages

![back-end](https://github.com/Henry-Azer/Hotel-Reservation/blob/master/src/main/resources/static/github%20images/back-end.png?raw=true)

•	Front-End Packages

![front-end](https://github.com/Henry-Azer/Hotel-Reservation/blob/master/src/main/resources/static/github%20images/front-end.png?raw=true)

Database Design Architecture

•	Using MySql open source database.

![database](https://github.com/Henry-Azer/Hotel-Reservation/blob/master/src/main/resources/static/github%20images/database.png?raw=true)
 
System Engineering Life Cycle

•	Data Access Object Pattern (DAO):

It’s a pattern that used deal with retrieve data from database and to save data too, using JPA with entity manager we can make a custom query with JPQL or can use modified methods.
Example: Reservation Dao Implementation Class.

![dao](https://github.com/Henry-Azer/Hotel-Reservation/blob/master/src/main/resources/static/github%20images/reservation%20dao.png?raw=true)
 
•	Service Pattern:

It’s a pattern used between DAO and Controller that’s modify data, manage the service inventory, manage transactional and control all database layers to handle requests between server and client.
Example: Reservation Service Implementation Class.

![service](https://github.com/Henry-Azer/Hotel-Reservation/blob/master/src/main/resources/static/github%20images/reservation%20service.png?raw=true)
 
•	Entity Package:

It’s the Java POJOs classes that represents a stored table in database, entity annotation scan it so can connect with entity manager (JPA) in DAO pattern.
Example: Reservation (Entity Class).

![entity](https://github.com/Henry-Azer/Hotel-Reservation/blob/master/src/main/resources/static/github%20images/reservation%20entity.png?raw=true)
 
•	Temporary Package:

This package for handle data input and match client inputs with required data, save data temporary in this class and after checking it using service pattern we pass it to entity classes.
Example: Current Reservation Class.

![temp](https://github.com/Henry-Azer/Hotel-Reservation/blob/master/src/main/resources/static/github%20images/temp%20reservation.png?raw=true)
 
•	Validation Package:

It’s some custom annotations with custom pattern regex or custom feature required to match data input with required data in Temporary Package.
Example: Field Match Annotation.

![valid](https://github.com/Henry-Azer/Hotel-Reservation/blob/master/src/main/resources/static/github%20images/field%20match%20annotation.png?raw=true)
 
•	Controller Package:

Controller is a Model View Controller (MVC) that’s handle the developing of user interfaces and manage data by represent and accept data to and from client using Service pattern.
Example: Hotel Reservation Controller Class.

![controller](https://github.com/Henry-Azer/Hotel-Reservation/blob/master/src/main/resources/static/github%20images/controller.png?raw=true)
 
•	Security Package:

It’s a Spring Security class that handle the authentications and authorizations of the project and manage client and his role.
Manage login and logout operations and all security features.
Example: Security Config Class.

![security](https://github.com/Henry-Azer/Hotel-Reservation/blob/master/src/main/resources/static/github%20images/security%20config.png?raw=true)
 
Project Interface Test

•	Sign In:

You can’t open any another page without sign in, you will directly transfer automatic to this page.

![signin](https://github.com/Henry-Azer/Hotel-Reservation/blob/master/src/main/resources/static/github%20images/sign%20in.png?raw=true)
 
•	Sign Up

Here you can Sign Up new account of your own and will be saved next time you can just sign in directly.

![signup](https://github.com/Henry-Azer/Hotel-Reservation/blob/master/src/main/resources/static/github%20images/sign%20up.png?raw=true)
 
•	Home:

There are many sections about the hotel to view it and information about it, Rooms, Services, Review. Etc
It’s a full page with header and content and footer.
You can use features like, Log Out, New Reservation or view logged in user reservations. 

![home](https://github.com/Henry-Azer/Hotel-Reservation/blob/master/src/main/resources/static/github%20images/home.png?raw=true)
 
•	New Reservation:

Reservations page, here you can book a room.

![new](https://github.com/Henry-Azer/Hotel-Reservation/blob/master/src/main/resources/static/github%20images/new%20reservation.png?raw=true)
 
•	Booking Form: 

Here is a form that you can choose your required choices, with live price counter.

![form](https://github.com/Henry-Azer/Hotel-Reservation/blob/master/src/main/resources/static/github%20images/booking%20form.png?raw=true)
 
•	Reservations List:

In this page you can modify your reservation and see list of user logged in reservations and can delete it or can update it with another choices.

![list](https://github.com/Henry-Azer/Hotel-Reservation/blob/master/src/main/resources/static/github%20images/reservation%20list.png?raw=true)

Conclusion

This was the documentation of the Hotel Room Booking Management System, What I’m learn in programming language two by resource from schoology was used and also some of the extra curriculum was used such as Spring Framework and Front-End code with as these were essential components to build full project.
This project included many properties and capabilities where you can create account, sign in and the website keep you in cycle to sign out in the end.
Then you can see information and pictures about hotel and rooms and see the reviews, services and packages.
After that you can create new reservation by filling the book form. Then you can modify it in your reservations page that provide a list of your reservations that you can update or delete.
This project will help the real life to book a far hotels without going to it so you can easily book from the internet so that make the operation faster and easier.
