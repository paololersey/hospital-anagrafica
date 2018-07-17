# bank-academy
Project containing an implementation of a bank-academy sample, built for academy purposes.
Please consult the documentation in redmine.

Briefly:
In order to have the front-end working on Angular6, change to front_end/angular-bank-academy and perform:
- npm install in order to install all dependencies;
- check environment.ts and eventually change the port, which is referred the backend one (localhost:8080)
- ng serve --open

The front-end will open at 

    http:/localhost:4200
    

In order to have the front-end working on Angularjs, simply go to:

    http://localhost:8080/bank-academy/index.html

In order to have the backend working, deploy the JAVA 8 application on top of Wildly 11 AS container 
Rest service are working completing this url

    http://localhost:8080/bank-academy/rest/**/*

