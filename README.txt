Task Weather service

Write a REST service with a single endpoint /weather.

When called, this service must query a database for today's weather (temperature) in the table "weather_history".
If no record is found in the database for the current date, then it must read the current temperature value from page "yandex.ru". After reading temperature, it must insert a new record in "weather_history". 
In the end, it must return the temperature value back to the user.

Used technology stack:
-Spring
-Hibernate
-PostgreSQL
-MVC pattern

Instruction:
In the class PersistencyConfig uncomment the necessary
//        properties.setProperty("hibernate.hbm2ddl","none");
//        properties.setProperty("hibernate.hbm2ddl.auto", "create");
//        properties.setProperty("hibernate.hbm2ddl.auto", "validate");
//        properties.setProperty("hibernate.hbm2ddl.auto", "update");

Table creation is located
src/main/resources/database/initDB.sql

For start run 
com/dbeaver/weather/WeatherApplication.java

Settings for Yandex API:
com/dbeaver/weather/service/HttpClient.java