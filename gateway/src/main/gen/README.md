# org.openapitools.client - Kotlin client library for Gateway API

## Requires

* Kotlin 1.4.30
* Gradle 6.8.3

## Build

First, create the gradle wrapper script:

```
gradle wrapper
```

Then, run:

```
./gradlew check assemble
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs, File inputs, and Form inputs.
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in OpenAPI definitions.
* Implementation of ApiClient is intended to reduce method counts, specifically to benefit Android targets.

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *http://localhost:8011/api*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**loginPost**](docs/DefaultApi.md#loginpost) | **POST** /login | Login a user
*DefaultApi* | [**usersPasswordPut**](docs/DefaultApi.md#userspasswordput) | **PUT** /users/password | Change user password
*DefaultApi* | [**usersPost**](docs/DefaultApi.md#userspost) | **POST** /users | Register a new user
*DefaultApi* | [**usersVerifyOtpPost**](docs/DefaultApi.md#usersverifyotppost) | **POST** /users/verify/{otp} | Verify a user


<a name="documentation-for-models"></a>
## Documentation for Models

 - [org.openapitools.client.models.AuthRequestDTO](docs/AuthRequestDTO.md)
 - [org.openapitools.client.models.PasswordChangeDTO](docs/PasswordChangeDTO.md)
 - [org.openapitools.client.models.UserDTO](docs/UserDTO.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

All endpoints do not require authorization.
