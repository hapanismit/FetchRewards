# Fetch Rewards Coding Exercise - Backend Software Engineering

## The Project is built using Java Spring Framework.

### Prerequisites

- Install Java 11 - for installation instructions see https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
- Install any IDE which supports Spring application
- Install Postman - https://www.postman.com/downloads/


### Run the Project in IDE

- Open the project in any IDE and run the FetchrewardsApplication.java file.
- Test the api in Postman by sending request and checking the responses.

### REST API routes

1. Add Transaction

URL : 
```
http://localhost:8080/api/transaction/add/
```
Request : 
```
curl -d  '{ "payer": "DANNON", "points": 1000, "timestamp": "2020-11-02T14:00:00Z" }' -H 'Content-Type: application/json' localhost:8080/api/transaction/add/

```


2. Spend Points

URL : 
```
http://localhost:8080/api/spend/
```
Request : 
```
curl -d  '{ "points": 5000 }' -H 'Content-Type: application/json' localhost:8080/api/spend/
```

3. Get Balance

URL : 
```
http://localhost:8080/api/balance/
```
Request : 

```
curl -d  localhost:8080/api/balance/
```
