I am starting a new Project
The Technologies used will be Java/Spring and Angular.
The Goal is to create a Webapp that allows Users to place bets against other users on ITTF Pro Tour tournament matches.
I will use IntelliJ for Spring(Java) and VSCode for Angular(JS/HTML/CSS/TS).

## Goals

* Displaying the current running tournament on a Website.
* Allowing Users to crreate an account.
* Allow a User to offer bets.
* Allow other Users to accept these bets.
* Save the Bets in some Database (MongoDb for now).

## Todos

* [x] Set up the Angular and Spring framework.
* [x] add Dependencies to Spring framework (MongoDB, Jackson, spring boot, jpa, devtools, maybe h2 database).
* [x] Grab the tournament data from an ITTF Endpoint eg https://results.ittf.com/ittf-web-results/html/TTE5146/brackets/M.SINGLES-----------.json.
* [x] Save it to JPA repository.
* Save it to DB.
* Load the Data from the DB into a Java repository.
* [x] grab data in Angular from Spring repository and display it on the website.
* [x] Set up Routes eg. Login.
* [x] add Project to Firebase and use their User Authentication.
* [x] Enable User Login.
  * Email
  * [x] Google
* Block Logged In Users from seeing Login and Register page
* Set up user space that is only accessible when logged in. eg. firebase auth-guard
* set up API in Spring to forward operations.

* Keep a DataBase of registered Users and the corresponding Bets.

### Styling

* Get a real NavBar





