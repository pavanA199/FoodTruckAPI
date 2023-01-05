# FoodTruck


All the Endpoints

POST /api/foodtrucks/upload:
This endpoint allows the user to upload a CSV file containing food truck data.
The file is then processed and the data is loaded into the database.

GET /api/foodtrucks/applicant:
 This endpoint returns a list of all food trucks in the database.

GET /api/foodtrucks/getApplicant:
This endpoint allows the user to search for food trucks by applicant name.
 The app request parameter specifies the name of the applicant to search for.

GET /api/foodtrucks/expired:
 This endpoint allows the user to search for food trucks whose permits have expired.
 The expirationDate request parameter specifies the expiration date to search for.

GET /api/foodtrucks/street:
This endpoint allows the user to search for food trucks by street name.
 The streetName request parameter specifies the street name to search for.

POST /api/foodtrucks/foodtrucks:
 This endpoint allows the user to add a new food truck to the database.
 The food truck data is provided in the request body as a FoodTruck object.

GET /api/foodtrucks/closest:
This endpoint allows the user to find the closest food truck to a given location.
The latitude and longitude request parameters specify the location to search from.
