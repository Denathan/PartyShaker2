package com.rodak.partyshaker.data.repository

import com.rodak.partyshaker.base.BaseRepository
import com.rodak.partyshaker.data.local.Drink
import com.rodak.partyshaker.data.remote.CocktailApi

class CocktailsRepository(private val api: CocktailApi) : BaseRepository() {

    suspend fun getDrinks(name: String): MutableList<Drink>? {

        val cocktailsResponse = safeApiCall(
            call = { api.getCocktailByName(name).await() },
            errorMessage = "Error fetching cocktails"
        )

        return cocktailsResponse?.drinks?.toMutableList()
    }
}