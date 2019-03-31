package com.rodak.partyshaker.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.rodak.partyshaker.data.local.Drink
import com.rodak.partyshaker.data.remote.Apifactory
import com.rodak.partyshaker.data.repository.CocktailsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SearchViewModel : ViewModel() {

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val repository: CocktailsRepository = CocktailsRepository(Apifactory.cocktailApi)

    val drinksLiveData = MutableLiveData<MutableList<Drink>>()
    
    fun fetchDrinks() {
        scope.launch {
            val drinks = repository.getDrinks("vodka")
            drinksLiveData.postValue(drinks)
        }
    }

    fun cancelRequests() = coroutineContext.cancel()
}
