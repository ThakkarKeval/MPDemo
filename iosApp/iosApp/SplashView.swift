import SwiftUI

struct SplashView: View {
    @Binding var isActive: Bool

    var body: some View {
        ZStack {
            Color.black.ignoresSafeArea()
            Text("MPDemo")
                .foregroundColor(.white)
        }
        .onAppear {
            DispatchQueue.main.asyncAfter(deadline: .now() + 2) {
                isActive = false
            }
        }
    }
}
