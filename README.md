open-council-portal
===================

Initial goal of the project is:
  With the help of open-source software make the work of municipal government transparent to common people.


This particular module is responsible for providing
 * possibility to track planned versus actual expenses
 * provide interface to easily search through decisions made
at city-hall level

Further goals  
 * facilities to perform data analysis
 * city infrastructure-related information

How to run:
 * Current working branch is https://github.com/okucher/city-hall/tree/hibernate
 * install java6, maven 2.2.1, postgres latest version
 * Database params https://github.com/okucher/city-hall/blob/hibernate/src/main/resources/env/city-hall-dev.properties
 * Test schema to create on db https://github.com/okucher/city-hall/blob/hibernate/src/main/resources/com/opencouncil/db/example/Test.hbm.xml
 * Test that everything is working http://localhost:8080/hello.html. Should display entries form Test schema if exists
