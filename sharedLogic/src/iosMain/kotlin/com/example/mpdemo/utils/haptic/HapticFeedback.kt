package com.example.mpdemo.utils.haptic

import platform.UIKit.UIImpactFeedbackGenerator
import platform.UIKit.UIImpactFeedbackStyle

actual class HapticFeedback {
    actual fun vibrate() {
        UIImpactFeedbackGenerator(style = UIImpactFeedbackStyle.UIImpactFeedbackStyleMedium)
            .also { it.prepare() }
            .impactOccurred()
    }
}