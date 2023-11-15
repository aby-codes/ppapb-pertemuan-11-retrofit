package com.example.tugaspertemuan11.network

import com.example.tugaspertemuan11.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("products")
    fun getItemData(): Call<ApiResponse>
}
