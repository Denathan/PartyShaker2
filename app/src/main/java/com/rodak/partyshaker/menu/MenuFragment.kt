package com.rodak.partyshaker.menu

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rodak.partyshaker.R
import kotlinx.android.synthetic.main.menu_fragment.allBtn
import kotlinx.android.synthetic.main.menu_fragment.favoritesBtn
import kotlinx.android.synthetic.main.menu_fragment.historyBtn
import kotlinx.android.synthetic.main.menu_fragment.randomBtn
import kotlinx.android.synthetic.main.menu_fragment.searchBtn

class MenuFragment : Fragment() {

    companion object {
        fun newInstance() = MenuFragment()
    }

    private lateinit var viewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MenuViewModel::class.java)

        favoritesBtn.setOnClickListener { displayFragment(R.id.action_menuFragment_to_favoritesFragment) }
        randomBtn.setOnClickListener { displayFragment(R.id.action_menuFragment_to_randomFragment) }
        historyBtn.setOnClickListener { displayFragment(R.id.action_menuFragment_to_historyFragment) }
        searchBtn.setOnClickListener { displayFragment(R.id.action_menuFragment_to_searchFragment) }
        allBtn.setOnClickListener { displayFragment(R.id.action_menuFragment_to_allFragment) }
    }

    private fun displayFragment(id: Int) {
        findNavController().navigate(id)
    }
}
