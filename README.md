# allinone-rest-services

__It contains following technology__
> * spring-jpa-data-base sample
> * rest implementation
> * exception handling 
> * loombook
> - swagger
> - data structure
> - discovery client
> - config-server-client
> - ribbon
> - hystrix


## To start the application 

 ```` 
 java -jar -Dspring.profiles.active=default,h2,admin,actuator -DsystemValue=systemValue allinone-rest-service-1.0.0.jar 
 ````
 

> Service exposed URLS

    - GET http://localhost:8082/album
    - DELETE http://localhost:8082/album/{albumName}
    - POST http://localhost:8082/album/{albumName}
    - GET http://localhost:8082/album/{albumName}/image
    - POST http://localhost:8082/album/{albumName}/image
    - DELETE http://localhost:8082/album/{albumName}/image/{imageId}
    - GET http://localhost:8082/album/{albumName}/image/{imageId}
    
> Swagger URL

    - http://localhost:8082/v2/api-docs
    - http://localhost:8082/swagger-ui.html

> H2 Data Base URL

    -   http://localhost:8082/h2-console

**  How To Start rabbitmq **

* To Start Rabbitmq run ``docker-compose up`` this command on cmd where docker is install and rabbit mq will start beacuse ``docker-compose.yml`` file is added

** How To Make Docker Container **

-   You need to Run the following command to make docker image
    - $ docker build -t <docker-hub-id>/<imagename> <directory>
    - $ docker build -t msdeo/image-store-service .
    
** Start The Container **
-   ``docker run -d -p 8082:8082 -name image --hostname local-image msdeo/allinone-rest-services``