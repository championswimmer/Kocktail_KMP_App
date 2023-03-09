//
// Created by Arnav Gupta on 09/03/23.
// Copyright (c) 2023 orgName. All rights reserved.
//

import Foundation
import shared
class CocktailListViewModel : ObservableObject {
    private var _viewModel = shared.CocktailListViewModel()

    @Published var state: shared.CocktailListState

    init () {
        state = _viewModel.state.value as! shared.CocktailListState
    }

}
