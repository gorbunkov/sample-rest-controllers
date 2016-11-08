# sample-rest-controllers
Sample project that demonstrates working with custom REST controllers.

**MyOauth2ProtectedController** class is an example of OAuth2 protected REST controller. Its method can be accessed by the URL:
```
http://localhost:8080/app-portal/rest/protected/hello
```

**MyOauth2UnprotectedController** class is an example of a class that is not protected by the OAuth2, and its URL starts with the */rest*:

```
http://localhost:8080/app-portal/rest/unprotected/hi
```

**MyNonRestController** is an example of the controller with the URL that doesn't start with */rest*

```
http://localhost:8080/app-portal/my/buy
```