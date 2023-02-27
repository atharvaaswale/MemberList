package com.unreal.memberlist

import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {
    @GET("v2/list")
    fun getList() : Call<List<UserListResItem>>
}