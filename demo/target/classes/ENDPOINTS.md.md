# Https ****************************************************

* port 8443

# Users ****************************************************

* admin - password
* user - password

# Endpoints ****************************************************

* GET       base endpoint or home

* GET       admin

* GET       authenticated

* GET       info

* GET        /admin
* GET        /authenticated

* GET       /users
* POST      /users
* GET       /users/{username}
* PUT       /users/{username}
* DELETE    /users/{username}
* GET       /users/{username}/authorities
* POST      /users/{username}/authorities
* DELETE    /users/{username}/authorities/{authority}

* GET       /kappers
* POST      /kappers
* GET       /kappers/{id}
* PUT       /kappers/{id}
* PATCH     /kappers/{id}
* DELETE    /kappers/{id}

* GET        /kappers/{kapper_id}/klanten/{klant_id}}
* POST       /kappers/{kapper_id}/klanten/{klant_id}}
* DELETE     /kappers/{kapper_id}/klanten/{klant_id}}

* GET       /klanten
* POST      /klanten
* GET       /klanten/{id}
* PUT       /klanten/{id}
* PATCH     /klanten/{id}
* DELETE    /klanten/{id}

* GET        /klanten/{klant_id}/kappers/{kapper_id}}
* POST       /klanten/{klant_id}/kappers/{kapper_id}}
* DELETE     /klanten/{klant_id}/kappers/{kapper_id}}


