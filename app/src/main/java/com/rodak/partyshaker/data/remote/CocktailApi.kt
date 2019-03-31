package com.rodak.partyshaker.data.remote

import com.rodak.partyshaker.data.local.Cocktails
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailApi {

    @GET("search.php?")
    fun getCocktailByName(@Query("s") name: String): Deferred<Response<Cocktails>>
}