import SwiftUI

@main
struct iOSApp: App {
    @State private var showSplash = true

    var body: some Scene {
        WindowGroup {
            if showSplash {
                SplashView(isActive: $showSplash)
            } else {
                MainView()
            }
        }
    }
}