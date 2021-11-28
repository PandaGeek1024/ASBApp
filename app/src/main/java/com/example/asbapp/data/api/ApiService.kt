package com.example.asbapp.data.api

import com.example.asbapp.data.entity.TransactionResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://60220907ae8f8700177dee68.mockapi.io/api/v1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ASBApiService {
    @GET("transactions")
    suspend fun getTransactions(): List<TransactionResponse>
}

object AsbApi {
    val asbApiService: ASBApiService by lazy {
        retrofit.create(ASBApiService::class.java)
    }
}