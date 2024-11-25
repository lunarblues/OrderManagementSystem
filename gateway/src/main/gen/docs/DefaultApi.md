# DefaultApi

All URIs are relative to *http://localhost:8011/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addOrder**](DefaultApi.md#addOrder) | **POST** /orders | Add a new order
[**changePassword**](DefaultApi.md#changePassword) | **PUT** /users/password | Change user password
[**deleteUser**](DefaultApi.md#deleteUser) | **DELETE** /users/delete/{id} | Delete a user by ID
[**getOrders**](DefaultApi.md#getOrders) | **GET** /orders | Get all orders
[**getUser**](DefaultApi.md#getUser) | **GET** /users/{id} | Get user details by ID
[**getUsers**](DefaultApi.md#getUsers) | **GET** /users | Get all users
[**loginUser**](DefaultApi.md#loginUser) | **POST** /login | Login a user
[**registerUser**](DefaultApi.md#registerUser) | **POST** /users | Register a new user
[**verifyUser**](DefaultApi.md#verifyUser) | **POST** /users/verify/{otp} | Verify a user


<a name="addOrder"></a>
# **addOrder**
> kotlin.String addOrder(orderDTO)

Add a new order

Add a new order to the system.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
val orderDTO : OrderDTO =  // OrderDTO | 
try {
    val result : kotlin.String = apiInstance.addOrder(orderDTO)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#addOrder")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#addOrder")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderDTO** | [**OrderDTO**](OrderDTO.md)|  |

### Return type

**kotlin.String**

### Authorization


Configure BearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="changePassword"></a>
# **changePassword**
> changePassword(passwordChangeDTO)

Change user password

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
val passwordChangeDTO : PasswordChangeDTO =  // PasswordChangeDTO | 
try {
    apiInstance.changePassword(passwordChangeDTO)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#changePassword")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#changePassword")
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


Configure BearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="deleteUser"></a>
# **deleteUser**
> kotlin.String deleteUser(id)

Delete a user by ID

Deletes a user based on their unique ID. Only accessible by authorized users.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
val id : kotlin.Long = 789 // kotlin.Long | Unique identifier of the user to be deleted
try {
    val result : kotlin.String = apiInstance.deleteUser(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#deleteUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#deleteUser")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.Long**| Unique identifier of the user to be deleted |

### Return type

**kotlin.String**

### Authorization


Configure BearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getOrders"></a>
# **getOrders**
> kotlin.collections.List&lt;OrderDTO&gt; getOrders()

Get all orders

Retrieve a list of all orders.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
try {
    val result : kotlin.collections.List<OrderDTO> = apiInstance.getOrders()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#getOrders")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#getOrders")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;OrderDTO&gt;**](OrderDTO.md)

### Authorization


Configure BearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUser"></a>
# **getUser**
> UserDTO getUser(id)

Get user details by ID

Retrieves detailed information about a user based on their unique ID.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
val id : kotlin.Long = 789 // kotlin.Long | Unique identifier of the user to retrieve
try {
    val result : UserDTO = apiInstance.getUser(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#getUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#getUser")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.Long**| Unique identifier of the user to retrieve |

### Return type

[**UserDTO**](UserDTO.md)

### Authorization


Configure BearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUsers"></a>
# **getUsers**
> kotlin.collections.List&lt;UserDTO&gt; getUsers()

Get all users

Retrieve a list of all users. Only accessible by users with the \&quot;ROLE_ADMIN\&quot; role.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
try {
    val result : kotlin.collections.List<UserDTO> = apiInstance.getUsers()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#getUsers")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#getUsers")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;UserDTO&gt;**](UserDTO.md)

### Authorization


Configure BearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="loginUser"></a>
# **loginUser**
> kotlin.String loginUser(authRequestDTO)

Login a user

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
val authRequestDTO : AuthRequestDTO =  // AuthRequestDTO | 
try {
    val result : kotlin.String = apiInstance.loginUser(authRequestDTO)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#loginUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#loginUser")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authRequestDTO** | [**AuthRequestDTO**](AuthRequestDTO.md)|  |

### Return type

**kotlin.String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="registerUser"></a>
# **registerUser**
> registerUser(userDTO)

Register a new user

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
val userDTO : UserDTO =  // UserDTO | 
try {
    apiInstance.registerUser(userDTO)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#registerUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#registerUser")
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

<a name="verifyUser"></a>
# **verifyUser**
> verifyUser(otp)

Verify a user

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = DefaultApi()
val otp : kotlin.String = otp_example // kotlin.String | OTP for user verification
try {
    apiInstance.verifyUser(otp)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#verifyUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#verifyUser")
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


Configure BearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

