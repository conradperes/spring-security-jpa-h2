# Spring-oauth2-jpa-example
A simple and basic example  to secure REST APsI with authentication using Spring Boot , Security , OAuth2 and JPA.

You can find more about this topic on official spring documentation:

https://projects.spring.io/spring-security-oauth/docs/oauth2.html


Start with this simple post call:

http://localhost:8080/oauth/token?grant_type=password&username=user&password=user



get the access_token, in this json:

{
    "access_token": "d8f0a631-70c0-4ef4-b01c-feb587ab450e",
    "token_type": "bearer",
    "expires_in": 4999,
    "scope": "read write trust"
}


and then call this second get http verb, to get access to private area:

http://localhost:8080/private?access_token=d8f0a631-70c0-4ef4-b01c-feb587ab450e


The respone would be the resources available for this specific user.


