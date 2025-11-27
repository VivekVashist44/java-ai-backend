# java-ai-backend
Combining the power of Spring Boot and Ai together to build some interesting things

## EndpointApp

Consisting of Product class having Product Id , Name and Category and various endpoint those are :

### GET /welcome :- 

This is a test endpoint to check API Working correctly without any issue.

**Response :-** 
HTTP 200 (JSON) 

example:
url :- http://localhost:8080/welcome
curl :- curl --location 'http://localhost:8080/welcome'

### GET /greet :- 

This is a endpoint which greets people . It take name as query parameter and then greet people accordingly

**Parameters :-** 
- `name` (query parameter , required)

**Response :-**
HTTP 200 (JSON)

example:
url :- http://localhost:8080/greet?name=Vivek
curl :- curl --location 'http://localhost:8080/greet?name=Aman'

### GET /recommendation :- 

This is a endpoint which is used to recommend products. It take product Id as input from query parameter and then return the list of recommended products which have 
same category as the product.

**Parameters :-** 
- `productId` (query parameter , required) :The ID of reference product

**Reponse :-**

example :
url :- http://localhost:8080/recommendation?productId=1
curl :- curl --location 'http://localhost:8080/recommendation?productId=1'

**sucessful response (HTTP 200):**

output :-
[
  {
    "id": 2,
    "name": "Kurkure",
    "category": "Food"
  },
  {
    "id": 5,
    "name": "milk",
    "category": "Food"
  }
]

**Error response(HTTP 404) :**

output :-
{
  "error": "Invalid product id or Product id not found"
}

**Empty result/Not Found(HTTP 200) :**

output :-
[]


### JUnit 
This demonstrates how to use JUnit 5 (Jupiter) for unit testing with Spring Boot endpoints.

#### Key Points:
- **@Test:** Marks a method as a test case to be executed by JUnit.
- **@BeforeEach:** Runs before each test, resetting state or initializing dependencies.
- **Assertions:** Used to verify expected behaviors (e.g., assertEquals for comparing expected and actual values).

#### Sample Test Cases
- `testRecommendInvalidInput`: Ensures the endpoint returns HttpStatus.NOT_FOUND and an error message when given an invalid product ID.
- `testRecommendValidInput`: Checks that a valid product ID returns HttpStatus.OK and recommended products in the same category (excluding the tested product).

#### Running Tests
To execute the tests:
mvn test
