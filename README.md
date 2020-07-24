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

* Set up the Angular and Spring framework.[x]
* add Dependencies to Spring framework (MongoDB, Jackson, spring boot, jpa, devtools, maybe h2 database).[x]

* Grab the tournament data from an ITTF Endpoint eg https://results.ittf.com/ittf-web-results/html/TTE5146/brackets/M.SINGLES-----------.json.
* Save it to DB.
* Load the Data from the DB into a Java repository.
* grab data in Angular from Spring repository and display it on the website.

* add Project to Firebase and use their User Authentication.
* Enable User Login.
* Keep a DataBase of registered Users and the corresponding Bets.
