package com.rodak.partyshaker.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rodak.partyshaker.R
import kotlinx.android.synthetic.main.search_fragment.drinkNameInput
import kotlinx.android.synthetic.main.search_fragment.foundDrinks

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private lateinit var viewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)

        setupOnTextChangeListerener()
        initObservers()
    }

    private fun setupOnTextChangeListerener() {
        drinkNameInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.findDrink(drinkNameInput.text.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    private fun initObservers() {
        viewModel.queryLiveData.observe(this, Observer {
            viewModel.fetchDrinks(it)
        })
        viewModel.drinksLiveData.observe(this, Observer {
            foundDrinks.text = it.map { it.strDrink }.toString()
        })
    }
}
