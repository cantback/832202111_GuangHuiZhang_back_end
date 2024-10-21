# GuangHui Zhang_832202111_22124853_back_end

## Project introduction
This project is a back-end service based on the **spring boot** framework, mainly used to provide data interface services, including crud operation and data query.

## Project structure
```
├── pom.xml
├── src
│   ├── controller
│   ├── entity
│   ├── repository
│   ├── service
│   └── main
├── application.properties
├── README.md
└── codestyle.md
```

## structure description
The src directory contains four subdirectories:
- controller：It processes requests, receives request parameters, invokes the interface of the service layer for business processing, and returns the response result.
- entity：entity: Defines an entity class for storing data.
- repository: Defines the data access interface for crud operations on the database.
- service: Defines the service logic interface, processes the service logic, and invokes the interface of the repository layer for data operations.
application.properties: Used to configure project-related parameters, such as database connection information and port number.
README.md: Project description document.
codestyle.md: Code style documentation.
