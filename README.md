# Fetch Rewards Coding Exercise - Backend Software Engineering

## The Project is built using Java Spring Framework.

### Prerequisites

- Install Java 11 - for installation instructions see https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
- Install any IDE which supports Spring application
- Install Postman - https://www.postman.com/downloads/


### Run the Project in IDE

- Simply open the project in any IDE and run the FetchrewardsApplication.java file.
- Test the api in Postman by sending request and checking the responses.

### REST API routes

1. Add Transaction

URL
```
http://localhost:8080/api/transaction/add/
```
Transaction 1 
```
curl -d  '{ "payer": "DANNON", "points": 1000, "timestamp": "2020-11-02T14:00:00Z" }' -H 'Content-Type: application/json' localhost:8080/api/transaction/add/

```
Transaction 2 
```
curl -d  '{ "payer": "DANNON", "points": 1000, "timestamp": "2020-11-02T14:00:00Z" }' -H 'Content-Type: application/json' localhost:8080/api/transaction/add/

```
Transaction 3 
```
curl -d  '{ "payer": "DANNON", "points": 1000, "timestamp": "2020-11-02T14:00:00Z" }' -H 'Content-Type: application/json' localhost:8080/api/transaction/add/

```
Transaction 4 
```
curl -d  '{ "payer": "DANNON", "points": 1000, "timestamp": "2020-11-02T14:00:00Z" }' -H 'Content-Type: application/json' localhost:8080/api/transaction/add/

```
Transaction 5 
```
curl -d  '{ "payer": "DANNON", "points": 1000, "timestamp": "2020-11-02T14:00:00Z" }' -H 'Content-Type: application/json' localhost:8080/api/transaction/add/

```





2.

```
curl -d  '{ "points": 5000 }' -H 'Content-Type: application/json' localhost:8080/consumer/points
```


```
curl -d  localhost:8080/payer/balances
```
