# docker-springboot-mysql
Test example of Springboot application with MySQL running in docker

# Starting the MySQL container
* Pull the MySQL docker image from Docker Hub. Version 5.6 is used:
  `docker pull mysql:5.6`
* Verify the list of imaged in local server
  `docker image ls`
* Run the MySQL server as a docker container
  `docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test -e MYSQL_USER=sa -e MYSQL_PASSWORD=password -d mysql:5.6`
 * Verfify the MySQL start up logs
  `docker container logs mysql-standalone`
