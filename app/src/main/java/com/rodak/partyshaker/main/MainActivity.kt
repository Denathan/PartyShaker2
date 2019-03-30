package com.rodak.partyshaker.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rodak.partyshaker.R

class MainActivity : AppCompatActivity() {

    private val defaultFragmentTag = "FRAGMENT_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        favoritesBtn.setOnClickListener { displayFragment(FavoritesFragment()) }
//        randomBtn.setOnClickListener { displayFragment(RandomFragment()) }
//        historyBtn.setOnClickListener { displayFragment(HistoryFragment()) }
//        searchBtn.setOnClickListener { displayFragment(SearchFragment()) }
//        allBtn.setOnClickListener { displayFragment(AllFragment()) }
    }

//    private fun displayFragment(fragment: Fragment) {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragmentContainer, fragment, defaultFragmentTag)
//            .commit()
//    }
//
//    private fun removeFragment(tag: String = defaultFragmentTag) {
//        supportFragmentManager.findFragmentByTag(tag)?.let {
//            supportFragmentManager.beginTransaction()
//                .remove(it)
//                .commit()
//        }
//    }
}
