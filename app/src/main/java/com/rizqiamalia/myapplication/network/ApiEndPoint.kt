package com.rizqiamalia.myapplication.network

import com.rizqiamalia.myapplication.model.ResponseProduk
import com.rizqiamalia.myapplication.model.ResponseUser
import retrofit2.Call
import retrofit2.http.*

interface ApiEndPoint {

    @GET("getUser")
    fun getUser(): Call<ResponseUser>

    @GET("getBaju")
    fun getBaju(): Call<ResponseProduk>

    @GET("bajuWanita")
    fun bajuWanita(): Call<ResponseProduk>

    @GET("getCelana")
    fun getCelana(): Call<ResponseProduk>

    @GET("celanaWanita")
    fun celanaWanita(): Call<ResponseProduk>
}