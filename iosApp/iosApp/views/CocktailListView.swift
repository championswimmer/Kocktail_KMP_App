//
//  CocktailListView.swift
//  iosApp
//
//  Created by Arnav Gupta on 10/03/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CocktailListView: View {
    var state: CocktailListState
    var onRefresh: () -> Void

    var body: some View {
        VStack {
            switch state {
            case is CocktailListState.Error:
                Text((state as! CocktailListState.Error).error.message ?? "Error")
                        .foregroundColor(.red);
            case is CocktailListState.Empty:
                VStack {
                    Text("No cocktails found")
                            .foregroundColor(.gray)
                    Button(action: onRefresh) {
                        Text("Refresh")
                    }
                }
            case is CocktailListState.Loading:
                ProgressView()
            case is CocktailListState.Success:
                List((state as! CocktailListState.Success).cocktails.drinks, id: \.idDrink) { drink in
                    CocktailItemRowView(drink: drink)
                }
            default:
                Text("Unknown state")
            }

        }
    }
}

//struct CocktailListView_Previews: PreviewProvider {
//    static var previews: some View {
//        CocktailListView()
//    }
//}
