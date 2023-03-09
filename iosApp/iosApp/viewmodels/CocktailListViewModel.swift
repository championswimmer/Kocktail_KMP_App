//
// Created by Arnav Gupta on 09/03/23.
// Copyright (c) 2023 orgName. All rights reserved.
//

import Foundation
import shared
class CocktailListViewModel : ObservableObject {
    private var _viewModel = shared.CocktailListViewModel()

    @Published var state: shared.CocktailListState

    init() {
        _viewModel.state.collect(
                collector: collect(
                        onCollect: { [weak self] state in
                            self?.state = state
                        }
                )
        ) { (error: Error?) in error }
    }

}
