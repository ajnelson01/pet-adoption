# pet-adoption

## Subprojects:

### Pet Gateway
- Spring cloud gateway app that sits in front of the rest of the microservices
- Matches URL patterns and delegates to other APIs

### Cat API 
- Project that maintains cat information via an H2 database

### Dog API 
- Project that maintains dog information via an H2 database

### Adoption API
- Project that stores adoption information via an H2 database
- Relies on the Dog & Cat APIs to validate adoption requests against valid animals

### Pet UI
- React app that displays available pets and has adoption forms to adopt a cat or dog

### Eureka
- Default Eureka application used for local development