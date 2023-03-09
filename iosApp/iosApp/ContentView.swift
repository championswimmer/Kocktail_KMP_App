import SwiftUI
import shared
import KMMViewModelSwiftUI

struct ContentView: View {
	@ObservedViewModel var viewModel = CocktailListViewModel()

	let greet = Greeting().greet()

	var body: some View {
		CocktailListView(state: viewModel.cocktailState, onRefresh: {
			viewModel.updateCocktailList()
		})
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
