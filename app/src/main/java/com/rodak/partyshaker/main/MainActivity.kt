package com.rodak.partyshaker.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.rodak.partyshaker.R
import com.rodak.partyshaker.all.AllFragment
import com.rodak.partyshaker.favorites.FavoritesFragment
import com.rodak.partyshaker.history.HistoryFragment
import com.rodak.partyshaker.random.RandomFragment
import com.rodak.partyshaker.search.SearchFragment
import kotlinx.android.synthetic.main.activity_main.allBtn
import kotlinx.android.synthetic.main.activity_main.favoritesBtn
import kotlinx.android.synthetic.main.activity_main.historyBtn
import kotlinx.android.synthetic.main.activity_main.randomBtn
import kotlinx.android.synthetic.main.activity_main.searchBtn

class MainActivity : AppCompatActivity() {

    private val defaultFragmentTag = "FRAGMENT_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        favoritesBtn.setOnClickListener { displayFragment(FavoritesFragment()) }
        randomBtn.setOnClickListener { displayFragment(RandomFragment()) }
        historyBtn.setOnClickListener { displayFragment(HistoryFragment()) }
        searchBtn.setOnClickListener { displayFragment(SearchFragment()) }
        allBtn.setOnClickListener { displayFragment(AllFragment()) }
    }

    private fun displayFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment, defaultFragmentTag)
            .commit()
    }

    private fun removeFragment(tag: String = defaultFragmentTag) {
        supportFragmentManager.findFragmentByTag(tag)?.let {
            supportFragmentManager.beginTransaction()
                .remove(it)
                .commit()
        }
    }
}
