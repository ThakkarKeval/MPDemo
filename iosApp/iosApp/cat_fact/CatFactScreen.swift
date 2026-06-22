//
//  CatFactScreen.swift
//  iosApp
//
//  Created by Keval Thakkar on 22/06/26.
//

import SwiftUI
import SharedLogic

struct CatFactScreen: View {

    @State private var vm = CatFactScreenVM()

    let hapticFeedback = HapticFeedback()

    var body: some View {
        VStack {
            Spacer()

            VStack(spacing: 20) {
                Text("Cat Fact 😼")
                    .font(.title2)
                    .fontWeight(.semibold)

                if vm.isLoading {
                    ProgressView()
                } else {
                    Text(vm.catFact?.fact ?? "")
                        .multilineTextAlignment(.center)
                        .padding(.horizontal, 24)
                }
            }

            Spacer()

            Button("Get another one") {
                hapticFeedback.vibrate()
                vm.getCatFact()
            }
            .buttonStyle(.bordered)
            .frame(maxWidth: .infinity)
            .padding(.horizontal, 24)
            .padding(.bottom, 24)
            .disabled(vm.isLoading)
        }
        .onAppear {
            vm.getCatFact()
        }
    }
}

#Preview {
    CatFactScreen()
}
