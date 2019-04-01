package com.rodak.partyshaker.search.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rodak.partyshaker.R
import com.rodak.partyshaker.data.local.Drink

class FoundCocktailsAdapter(private val context: Context) :
    RecyclerView.Adapter<FoundCocktailsViewHolder>() {

    val foundCocktails = listOf<Drink>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoundCocktailsViewHolder {
        return FoundCocktailsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.cocktail_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = foundCocktails.size

    override fun onBindViewHolder(holder: FoundCocktailsViewHolder, position: Int) {
        val cocktail = foundCocktails[position]
        with(holder) {
            drinkName.text = cocktail.strDrink
            Glide.with(context).load(cocktail.strDrinkThumb).into(drinkImage)
        }
    }
}
