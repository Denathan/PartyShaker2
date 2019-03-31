package com.rodak.partyshaker.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.rodak.partyshaker.R
import com.rodak.partyshaker.all.AllFragment
import com.rodak.partyshaker.favorites.FavoritesFragment
import com.rodak.partyshaker.history.HistoryFragment
import com.rodak.partyshaker.random.RandomFragment
import com.rodak.partyshaker.search.SearchFragment
import kotlinx.android.synthetic.main.activity_main.fragment_container
import kotlinx.android.synthetic.main.menu_fragment.allBtn
import kotlinx.android.synthetic.main.menu_fragment.favoritesBtn
import kotlinx.android.synthetic.main.menu_fragment.historyBtn
import kotlinx.android.synthetic.main.menu_fragment.randomBtn
import kotlinx.android.synthetic.main.menu_fragment.searchBtn

class MainActivity : AppCompatActivity() {

    private val defaultFragmentTag = "FRAGMENT_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSupportNavigateUp()
        = NavHostFragment.findNavController(fragment_container).navigateUp()

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
