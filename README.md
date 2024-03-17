# RideShare System

The rideshare project is a backend application developed in Spring Boot integrated with Apache Kafka for a rideshare platform.

# Application setup

# API endpoints

## API: Update Driver Location
This API endpoint is used to update the location of the driver.

### Workflow
- Firstly a simple validation is made to ensure driver Id exists.
- Afterwards the location is updated in the h2 database and an event is published to a Kafka topic named "driver-location-updates-topic".

### Request Parameters
- **id (Path Parameter)**: The driver id whose location is to be updated.

### Request Body
- **LocationRequestDto**: A DTO that contains latitude and longitude coordinates of the new location.
    - `latitude`: Latitude coordinate of the new location.
    - `longitude`: Longitude coordinate of the new location.

### Response
- **Success (200 OK)**: Returns a success message indicating that the driver's location has been updated.
- **Bad Request (400)**: Returns an error message if the driver with the specified ID does not exist or if there is an issue updating the location.


## API Endpoint: Request Ride
This API endpoint allows a rider to request a ride by providing their pickup and drop-off locations.

### Workflow
- Firstly a simple validation is performed to ensure that the rider exists.
- The ride request is then stored in the database and sent to an kafka topic "ride-request-topic".

### Request Parameters
- **id (Path Parameter)**: The driver id whose location is to be updated.

### Request Body
- **RideRequestDTO**: A DTO containing information about the ride request.
    - `riderId`: The unique identifier of the rider requesting the ride.
    - `latitudePickUp`: Latitude coordinate of the pickup location.
    - `longitudePickUp`: Longitude coordinate of the pickup location.
    - `latitudeDropOff`: Latitude coordinate of the drop-off location.
    - `longitudeDropOff`: Longitude coordinate of the drop-off location.

### Response
- **Success (200 OK)**: Returns a success message indicating that the rider's ride request has been created.
- **Bad Request (400)**: Returns an error message if the rider with the specified ID does not exist or if there is an issue creating the ride request.



## API: Find Nearest Driver
This API endpoint is used to find the nearest available driver for a given ride.

### Workflow
- A simple validation is performed to ensure that the ride exists.
- The system identifies the nearest available driver for the specified ride using appropriate algorithms.
- An event is published to a Kafka topic named "ride-request-acceptance-topic".

### Request Parameters
- **rideId (Path Parameter)**: The unique identifier of the ride for which the nearest driver is to be found.

### Response
- **Success (200 OK)**: Returns details of the nearest driver who is available to pick up the ride.
- **Not Found (404)**: Returns a status indicating that the ride with the specified ID does not exist.




## API: Register User

This API endpoint allows users to register as either riders or drivers.

### Workflow
- Simple validation is ensured that requestDTO is valid and userType.
- Users can register as either riders or drivers based on the provided userType.
- Upon successful registration, the user's information is stored in the respective user database.

### Request Body
- **UserRequestDto**: A DTO containing information about the user registration.
    - `name`: Name of the user.
    - `email`: Email address of the user.
    - `userType`: Type of user being registered (either "rider" or "driver").

### Response
- **Success (200 OK)**: Returns a success message indicating that the user has been registered successfully.
- **Bad Request (400)**: Returns an error message if the registration request is invalid or if the user type is not recognized.

# Notification System
- I created kafka consumers that read from the desired topics and "notify" using SystemOutPrintLn the received messages.
- Additionally when there's a match between a driver and rider, the consumer reads the message and saves it on database.

# Find Driver Near Me - Matching Algorithm
I used a very simple algorithm to measure the distance between driver and rider request, named Manhattan Distance Calculation algorithm.

## Formula
Math.abs(lon2 - lon1) + Math.abs(lat2 - lat1);

## Explanation
The Java function will essentially iterate through all driver locations, applying the formula to calculate distances. It then returns the shortest distance to determine the most suitable driver for the given scenario.

# Potential Improvements And Additional Comments
- I found the exercise very interesting challenge and fun. It provided me with the opportunity to learn a few new things along the way.
- Unfortunately, I didn't have the desired amount of time to complete the exercise as I had hoped, mainly due to being out of town over the weekend.
- There's a folder named postman with all the requests used for the application.


## Potential Improvements
- The first point I would improve would be database scheme and matching algorithm. I would research for a better matching alogirthm and implement a more efficient way to compare driver and rider location (using partitions maybe??).
- I would implement more design patterns. A few that would improve code quality would be Builder, Factory method.
- There are alot of more complex validation in order to control edge cases
- Improve error handling.
- There's more work to do in order to respect SOLID and GRASP principles and improve work quality overall.

