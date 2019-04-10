package com.rodak.partyshaker.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
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

        initButtons()
        initObservers()
    }

    private fun initButtons() {
        favoritesBtn.setOnClickListener { viewModel.showFragment(R.id.action_menuFragment_to_favoritesFragment) }
        randomBtn.setOnClickListener { viewModel.showFragment(R.id.action_menuFragment_to_randomFragment) }
        historyBtn.setOnClickListener { viewModel.showFragment(R.id.action_menuFragment_to_historyFragment) }
        searchBtn.setOnClickListener { viewModel.showFragment(R.id.action_menuFragment_to_searchFragment) }
        allBtn.setOnClickListener { viewModel.showFragment(R.id.action_menuFragment_to_allFragment) }
    }

    private fun initObservers() {
        viewModel.searchFragment.observe(this, Observer { fragmentIdEvent ->
            fragmentIdEvent.getContentIfNotHandled()?.let { displayFragment(it) }
        })
    }

    private fun displayFragment(id: Int) {
        findNavController().navigate(id)
    }
}
