package com.rodak.partyshaker.menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuViewModel : ViewModel() {

    val searchFragment = MutableLiveData<Int>()

    fun showFragment(fragmentId: Int) {
        searchFragment.postValue(fragmentId)
    }
}
