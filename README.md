# MovieApplicationREST
It is a project made within the scope of "C and System Programmers Association" training. A simple movie database and service has been written. Hibernate and JPA technologies are used.

## api/director
### /directors
gives all directors in database in json format.

## api/movie
### /movies
gives all movies in database in json format.

### /moviesbyyear?year=***
Returns the movies of the year passed as a parameter.

### /moviesbymonthyear?year=***&month=***
sends movies by given year and month.

### /count
Returns the number of movies saved in the database
