//
//  CatFactVM.swift
//  iosApp
//
//  Created by Keval Thakkar on 22/06/26.
//

import SharedLogic
import SwiftUI

@Observable
class CatFactScreenVM {

    let repository = CatFactRepository()

    var catFact: CatFact? = nil
    var isLoading: Bool = false

    func getCatFact() {
        isLoading = true
        Task {
            do {
                let result = try await repository.getCatFact()
                catFact = result
            } catch {
                print("Error: \(error)")
            }
            isLoading = false
        }
    }
}
