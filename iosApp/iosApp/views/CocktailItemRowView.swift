//
//  CocktailItemRowView.swift
//  iosApp
//
//  Created by Arnav Gupta on 09/03/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CocktailItemRowView: View {
    var drink: Drink
    var body: some View {
        HStack {
            Text(drink.strDrink!)
                    .font(.title)
                    .bold()
                    .padding(10)
            Spacer()
            Text((drink.strIngredient1 ?? "") + "," + (drink.strIngredient2 ?? ""))
                    .font(.caption)
                    .padding(10)
            Spacer()
            Text(drink.strCategory!)
                    .font(.body)
                    .foregroundColor(.gray)
                    .padding(10)
        }
    }
}

struct CocktailItemRowView_Previews: PreviewProvider {
    static var previews: some View {
        let drink = Drink(idDrink: "123", strDrink: "Mojito", strDrinkAlternate: "", strTags: "", strVideo: "", strCategory: "Cocktail", strIBA: "", strAlcoholic: "", strGlass: "", strInstructions: "", strDrinkThumb: "", strIngredient1: "Vodka", strIngredient2: "Gin", strIngredient3: "Lime", strIngredient4: "", strIngredient5: "", strIngredient6: "", strIngredient7: "", strIngredient8: "", strMeasure1: "", strMeasure2: "", strMeasure3: "", strMeasure4: "", strMeasure5: "", strMeasure6: "", strMeasure7: "", strMeasure8: "", strImageSource: "", strImageAttribution: "", strCreativeCommonsConfirmed: "", dateModified: "")
        CocktailItemRowView(drink: drink)
    }
}
