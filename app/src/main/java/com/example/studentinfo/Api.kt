package com.example.studentinfo

import retrofit2.http.GET

interface Api {

    @GET("/chanjalireddy/Api/main/22A")
    suspend fun getRepo22a():Adapter

    @GET("/chanjalireddy/Api/main/22B")
    suspend fun getRepo22b():Adapter

    @GET("/chanjalireddy/Api/main/22C")
    suspend fun getRepo22c():Adapter

    @GET("/chanjalireddy/Api/main/22D")
    suspend fun getRepo22d():Adapter

    @GET("/chanjalireddy/Api/main/info")
    suspend fun getRepo21a():Adapter

    @GET("/chanjalireddy/Api/main/info")
    suspend fun getRepo21b():Adapter

    @GET("/chanjalireddy/Api/main/info")
    suspend fun getRepo21c():Adapter

    @GET("/chanjalireddy/Api/main/info")
    suspend fun getRepo21d():Adapter

}