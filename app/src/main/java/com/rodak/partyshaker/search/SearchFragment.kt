package com.rodak.partyshaker.search

import android.content.Context
import android.os.Build.VERSION_CODES.P
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.rodak.partyshaker.R
import com.rodak.partyshaker.data.local.Drink
import com.rodak.partyshaker.search.recyclerview.FoundCocktailsAdapter
import kotlinx.android.synthetic.main.search_fragment.drinkNameInput
import kotlinx.android.synthetic.main.search_fragment.errorText
import kotlinx.android.synthetic.main.search_fragment.foundCocktailsList
import kotlinx.android.synthetic.main.search_fragment.searchProgress
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private lateinit var viewModel: SearchViewModel
    private lateinit var resultsAdapter: FoundCocktailsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(view.context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)

        setupOnTextChangeListerener()
        initObservers()
    }

    override fun onResume() {
        super.onResume()
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }

    // TODO better state management
    private fun setupOnTextChangeListerener() {
        drinkNameInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                CoroutineScope(Dispatchers.Main).launch {
                    delay(300)
                    viewModel.findDrink(drinkNameInput.text.toString().trim())
                }
                searchProgress.visibility = View.VISIBLE
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
        viewModel.drinksLiveData.observe(this, Observer { drinks ->
            handleReceivedData(drinks ?: null)
        })
    }

    private fun initRecyclerView(context: Context) {
        resultsAdapter = FoundCocktailsAdapter(context)
        with(foundCocktailsList) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = resultsAdapter
        }
    }

    // TODO something is wrong with displaying list
    private fun handleReceivedData(drinks: MutableList<Drink>?) {
        if (drinks == null) {
            searchProgress.visibility = View.GONE
//            resultsAdapter.foundCocktails = listOf()
            errorText.visibility = View.VISIBLE
        } else {
            searchProgress.visibility = View.GONE
            errorText.visibility = View.GONE
            resultsAdapter.foundCocktails = drinks
        }
    }
}
