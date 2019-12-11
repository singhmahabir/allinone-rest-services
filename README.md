# allinone-rest-services

It contains following technology 
* data-base sample
* rest implementation
* exception handling 
* loombook
* swagger


## Start ##
As per deployment environment pick appropriate profile: launch your application with a -D argument (remember to put it before the main class or jar archive)[refer](https://docs.spring.io/spring-boot/docs/current/reference/html/howto-properties-and-configuration.html) 

## To start the application 
 java -jar -Dspring.profiles.active=default,h2,admin,actuator -DsystemValue=systemValue allinone-rest-service-1.0.0.jar ####