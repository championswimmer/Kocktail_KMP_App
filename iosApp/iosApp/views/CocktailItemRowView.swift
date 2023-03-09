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
        let previewProviders = PreviewProviders()
        let drink = previewProviders.drinksProvider.valuesAsArray.get(index: 0)!
        CocktailItemRowView(drink: drink)
    }
}
