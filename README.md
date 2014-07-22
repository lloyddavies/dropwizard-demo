Dropwizard Demo
===============

Building app:

```
mvn clean package
```

Running app:

```
java -jar target/dropwizard-demo-1.0-SNAPSHOT.jar server
```

Example curl commands:

```
curl http://localhost:8080/books
curl http://localhost:8080/books/1234567890
curl -d '{"author":"Fred Bloggs","title":"Nothing","isbn":"1234512345"}' -H "Content-Type: application/json" http://localhost:8080/books
```
