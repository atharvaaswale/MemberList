package com.unreal.memberlist

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitClient {
    val BASE_URL = "https://picsum.photos/"

    /*var gson = GsonBuilder()
        .setLenient()
        .create()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(BASE_URL)
        .build()


    interface ApiService {
        @GET("/v2/list")
        fun getList(): List<UserListResItem>
    }


    object PicsumApi {
        val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
    }*/

    var gson = GsonBuilder()
        .setLenient()
        .create()

    val instance: ApiClient by lazy{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        retrofit.create(ApiClient::class.java)
    }
}