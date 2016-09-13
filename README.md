
Curl Example
=============

Create a user 
--------------------
curl  -v -k -X POST -H 'Content-Type: application/json' -H'Accept: application/json' --data '{"firstName":"baba","lastName":"kishore","email":"abcd@gmail.com","mobile":"121-232-1234","dateOfBirth":1473749325212}' http://restapp-lkd.rhcloud.com/restapp/users/

Update a user
---------------------

curl  -v -k -X PUT -H 'Content-Type: application/json' -H'Accept: application/json' --data '{"firstName":"baba","lastName":"dash","email":"abcd1234@gmail.com","mobile":"121-232-1234","dateOfBirth":1473749325212}' http://restapp-lkd.rhcloud.com/restapp/users/{id}



To list users 
---------------------

curl  -v -k -X GET -H'Accept: application/json' http://restapp-lkd.rhcloud.com/restapp/users


To get a user
-----------------------

curl  -v -k -X GET -H'Accept: application/json' http://restapp-lkd.rhcloud.com/restapp/users/{id}



To delete a user
-----------------------

curl  -v -k -X DELETE -H'Accept: application/json' http://restapp-lkd.rhcloud.com/restapp/users/{id}


N.B. Above data and headers can be used with rest client like POSTMAN to test the rest endpoints.


