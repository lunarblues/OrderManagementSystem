./gradlew build

docker-compose up --build

run the data.sql file in userservice/resources to store user with admin role.


visit http://localhost:8011/webjars/swagger-ui/index.html after all these steps.

Registration process:
POST request on /api/users. It will send verification code on your mail.
When you enter that verification code on /api/users/verify/{code} you are registered.

I keep everything(including roles) in jwt so what I did is that I created request scope 
bean and stored some useful data in there(mail, user id).
To communicate between tables I used native queries.
Some of the endpoints require admin role and some require manager role.
For example: Order completion can be done only by manager.
User deletion can be done only by admin.
Seeing all users at once can be done only by admin.
In security while adding custom jwt filter I'm just parsing the token I'm not calling userdetailsservice or authmanager.