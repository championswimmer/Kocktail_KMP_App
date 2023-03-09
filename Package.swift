import PackageDescription

let package = Packge(
        name: "iosApp",
        products: [
            .library(name: "iosApp", targets: ["iosApp"])
        ],
        dependencies: [
            .package(url: "https://github.com/rickclephas/KMP-NativeCoroutines.git", from: "1.0.0-ALPHA-5-spm-combine"),
            .package(url: "https://github.com/rickclephas/KMM-ViewModel.git", from: "1.0.0-ALPHA-4")
        ]
)