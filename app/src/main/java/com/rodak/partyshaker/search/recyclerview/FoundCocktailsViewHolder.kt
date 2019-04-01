package com.rodak.partyshaker.search.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cocktail_item.view.cocktailImage
import kotlinx.android.synthetic.main.cocktail_item.view.cocktailName

class FoundCocktailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val drinkName = itemView.cocktailName
    val drinkImage = itemView.cocktailImage
    val view = itemView
}