package com.rodak.partyshaker.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rodak.partyshaker.tools.SingleDataEvent

class MenuViewModel : ViewModel() {

    private val searchFragmentData = MutableLiveData<SingleDataEvent<Int>>()

    val searchFragment: LiveData<SingleDataEvent<Int>>
        get() = searchFragmentData

    fun showFragment(fragmentId: Int) {
        searchFragmentData.postValue(SingleDataEvent(fragmentId))
    }
}
