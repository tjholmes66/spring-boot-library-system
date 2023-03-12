# spring-boot-library-system
Spring Boot Library System

Evolution happens!  I used to have an old project called 'library-system' which started off with Spring, not Spring Boot.  
It had a lot of XML Configuration Files rather than Configuration Classes, and generally it was getting older and more dated.  
This project was a multi-maven project, which is now considered monolithic.  
You would create a WAR file and deploy to an existing Tomcat, maybe one sitting on an EC2 instance.  
I decided to make that project Private and create this new Public Project.

In the world of Microservices and Containers like Docker, the technology world has changed.
So, I decided to go with a new Spring Boot application, and I envision this as one Microservice to be put into a Docker container.
Then with my AWS Account use the ECR Services for deployment, and use GitHub Actions for my CI/CD process.

There was an old project I have which is my introduction to React, and is the UI side to this back-end.  
That UI project would work for the old library-system I created, and it will also work for this new Spring Boot project.

This project will also be using Flyway for Database Migrations.
As any new technologies are introduced, I will make sure I highlight them.
