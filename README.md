I am starting a new Project

The Technologies used will be Java/Spring and Angular.
The Goal is to create a Webapp that allows Users to place bets against other users on ITTF Pro Tour tournament matches.
I will use IntelliJ for Spring(Java) and VSCode for Angular(JS/HTML/CSS/TS).

My main motivation for this project is to learn basic full-stack development and gain experience using the Angular and Spring frameworks.

## Goals

* Displaying the current running tournament on a Website.
* [x] Allowing Users to crreate an account.
* Allow a User to offer bets.
* Allow other Users to accept these bets.
* Save the Bets in some Database (MongoDb for now).

## Todos

### Angular

* [x] Set up the Angular and Spring framework
* [x] add Dependencies to Spring framework (MongoDB, Jackson, spring boot, jpa, devtools, maybe h2 database)
* [x] Grab the tournament data from an ITTF Endpoint eg https://results.ittf.com/ittf-web-results/html/TTE5146/brackets/M.SINGLES-----------.json
* [x] Save it to JPA repository
* [x] Install MongoDB DataBase
* [x] Connect DB to Spring Framework
* Save tournament data to MongoDB.
* Load the Data from the DB into a Java repository
* [x] grab data in Angular from Spring repository and display it on the website
* [x] Set up Routes eg. Login
* [x] add Project to Firebase and use their User Authentication
* [x] Enable User Login
  * Email
    * [x] sign in
    * [x] login
* [x] research canActivate and be able to check if a user is logged in or not
* [x] Block Logged In Users from seeing Login and Register page
* [x] Set up user space that is only accessible when logged in. eg. firebase auth-guard
* [x] get UserID from firebase api
* [x] post UserData on register to Spring
* [x] request bets of this user from Spring
* [x] display userspecific bets
* [x] set up user specific userspace
* [x] set up API in Spring to forward operations
* [x] request all open bets(except same User) from Spring

### Spring

* [x] create MongoDB instance
* [x] save Bets to MongoDb
* [x] save registered User to DB
* [x] create Endpoint to create a Bet
* [x] save created Bet to DBrepository
* [x] create Endpoint to accept Bet
* [x] mark Bet as saved and add AccepterID
* [x] create Endpoint to send Bets of certain User
* [x] Keep a DataBase of registered Users and the corresponding Bets.

### Styling

* [x] Get a real NavBar
* [x] Use Bootstrap Cards to style bets





