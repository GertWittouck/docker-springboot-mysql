# docker-springboot-mysql
Test example of Springboot application with MySQL running in docker

# Starting the MySQL container
* Pull the MySQL docker image from Docker Hub. Version 5.6 is used:
  `docker pull mysql:5.6`
* Verify the list of imaged in local server
  `docker image ls`
* Run the MySQL server as a docker container in DEV mode
  `docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=transaction-management -e MYSQL_USER=sa -e MYSQL_PASSWORD=password -d -p 127.0.0.1:3307:3306 mysql:5.6`
  adding the -p 127.0.0.1:3307:3306 will bind the docker port 3306 to the localhost port 3307 which will allow connection to Intellij DB browser
* Run the MySQL server as a docker container in PROD mode
    `docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=transaction-management -e MYSQL_USER=sa -e MYSQL_PASSWORD=password -d mysql:5.6`
* Spring profiles will be used to selected the correct mode in the spring boot application
* Verfify the MySQL start up logs
  `docker container logs mysql-standalone`
