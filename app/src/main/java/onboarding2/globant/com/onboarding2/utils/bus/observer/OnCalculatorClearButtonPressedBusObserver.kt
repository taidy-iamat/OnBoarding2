package onboarding2.globant.com.onboarding2.utils.bus.observer

import com.globant.counter.utils.bus.observer.BusObserver


abstract class OnCalculatorClearButtonPressedBusObserver : BusObserver<OnCalculatorClearButtonPressedBusObserver.OnCalculatorClearButton>
    (OnCalculatorClearButton::class.java) {

    class OnCalculatorClearButton
}