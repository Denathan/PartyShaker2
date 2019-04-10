package com.rodak.partyshaker.data.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.rodak.partyshaker.tools.API_KEY
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Apifactory {

    private val authInterceptor = Interceptor { chain ->
        val newUrl = chain.request().url()
            .newBuilder()
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    private val cocktailClient = OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .build()

    private fun retrofit(): Retrofit = Retrofit.Builder()
        .client(cocktailClient)
        .baseUrl("https://www.thecocktaildb.com/api/json/v1/$API_KEY/")
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val cocktailApi: CocktailApi = retrofit().create(CocktailApi::class.java)
}