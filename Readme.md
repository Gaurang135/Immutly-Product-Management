# Product Management System - RESTful API

This project is a RESTful API for a digital product management system, providing basic CRUD operations for products. The system includes endpoints to retrieve a list of products, retrieve details of a specific product, add a new product, update details of a specific product, and remove a specific product.

## Technology Stack

- **Java**: Main server-side logic.
- **Gradle**: Build tool.
- **MongoDB**: Database.

## Getting Started

Follow the steps below to set up and run the project.

### Prerequisites

Make sure you have the following installed:

- [Java](https://www.oracle.com/java/technologies/javase-downloads.html)
- [MongoDB](https://www.mongodb.com/try/download/community)

### Installation

1. Clone the repository:

```bash
git clone https://github.com/Gaurang135/Immutly-Product-Management.git
```

2. Navigate to the project directory:

```bash
cd Immutly-Product-Management
```

3. Build the Java service:

```bash
gradle build
```
**Docker:**

The code has been dockerized as well for easy fetching and directly running on any linux instance, simply execute the below command to fetch the docker image.
```bash
docker pull yash1969/immutly-assignment
```
### Configuration

1. Set up MongoDB:
    - Ensure MongoDB is running on your local machine or update the database connection settings in `application.properties` of the Java service.

2. Start the Java service:

```bash
java -jar build/libs/Immutly-0.0.1-SNAPSHOT.jar
```
The API's should now be running on http://localhost:8081/products.

### Security:
The applications all endPoint has been secured with the basic authentication which can be accessed with the dummy username and password as:
```bash
Username : dummyUser
Password: test
```

# API Endpoints

1. **Retrieve a List of Products**

**Endpoint:**
```bash
GET /products
```
### Response:

```Json
[
{
"productId": 1,
"productName": "Product A",
"productDescription": "Description A",
"price": 49.99,
"availabilityStatus": true
},
{
"productId": 2,
"productName": "Product B",
"productDescription": "Description B",
"price": 29.99,
"availabilityStatus": false
}
]
```
2. **Retrieve Details of a Specific Product**

    **Endpoint:**

```bash
GET /products/{product_id} 
```
### Response:

```json lines
{
"productId": 1,
"productName": "Product A",
"productDescription": "Description A",
"price": 49.99,
"availabilityStatus": true
}
```

3.  **Add a New Product**

    **Endpoint:**
```bash
POST /products
```   
### Request:

```json
{
"productName": "New Product",
"productDescription": "Description for the new product",
"price": 99.99,
"availabilityStatus": true
}
```

### Response:

```bash
"3"  // Product ID of the newly created product
```

4.  **Remove a Specific Product**

    **Endpoint:**

```bash
DELETE /products/{product_id}
```

### Response:

```bash
{}  // Empty response with HTTP status 200 if successful
```

5.  **Update Details of a Specific Product**

    **Endpoint:**

```bash
PUT /products/{product_id}
```

### Request:

```json
{
"productName": "Updated Product",
"productDescription": "Updated description",
"price": 79.99,
"availabilityStatus": false
}
```

### Response:

```bash
{}  // Empty response with HTTP status 200 if successful
```

## Validation
Ensure all necessary fields are provided when creating or updating products. The product price must be a positive value.

## Conclusion
Thank you for using the Product Management System API! If you have any questions or feedback, feel free to reach out.