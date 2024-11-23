# DefaultApi

All URIs are relative to *http://localhost:8011/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**loginPost**](DefaultApi.md#loginPost) | **POST** /login | Login a user
[**usersPasswordPut**](DefaultApi.md#usersPasswordPut) | **PUT** /users/password | Change user password
[**usersPost**](DefaultApi.md#usersPost) | **POST** /users | Register a new user
[**usersVerifyOtpPost**](DefaultApi.md#usersVerifyOtpPost) | **POST** /users/verify/{otp} | Verify a user


<a name="loginPost"></a>
# **loginPost**
> loginPost(authRequestDTO)

Login a user

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
val authRequestDTO : AuthRequestDTO =  // AuthRequestDTO | 
try {
    apiInstance.loginPost(authRequestDTO)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#loginPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#loginPost")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authRequestDTO** | [**AuthRequestDTO**](AuthRequestDTO.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="usersPasswordPut"></a>
# **usersPasswordPut**
> usersPasswordPut(passwordChangeDTO)

Change user password

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
val passwordChangeDTO : PasswordChangeDTO =  // PasswordChangeDTO | 
try {
    apiInstance.usersPasswordPut(passwordChangeDTO)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#usersPasswordPut")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#usersPasswordPut")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **passwordChangeDTO** | [**PasswordChangeDTO**](PasswordChangeDTO.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="usersPost"></a>
# **usersPost**
> usersPost(userDTO)

Register a new user

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
val userDTO : UserDTO =  // UserDTO | 
try {
    apiInstance.usersPost(userDTO)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#usersPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#usersPost")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userDTO** | [**UserDTO**](UserDTO.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="usersVerifyOtpPost"></a>
# **usersVerifyOtpPost**
> usersVerifyOtpPost(otp)

Verify a user

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
val otp : kotlin.String = otp_example // kotlin.String | OTP for user verification
try {
    apiInstance.usersVerifyOtpPost(otp)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#usersVerifyOtpPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#usersVerifyOtpPost")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **otp** | **kotlin.String**| OTP for user verification |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

