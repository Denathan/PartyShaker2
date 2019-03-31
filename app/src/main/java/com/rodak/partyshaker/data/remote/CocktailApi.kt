package com.rodak.partyshaker.data.remote

import com.rodak.partyshaker.data.local.Cocktails
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CocktailApi {

    @GET("search.php?s={name}")
    fun getCocktailByName(@Path("name") name: String): Deferred<Response<Cocktails>>
}