package onboarding2.globant.com.onboarding2.utils.bus.observer


import com.globant.counter.utils.bus.observer.BusObserver
import onboarding2.globant.com.onboarding2.mvp.model.CalculatorITEM

abstract class OnCalculatorActionItemPressedBusObserver : BusObserver<OnCalculatorActionItemPressedBusObserver.OnCalculatorActionButtonPressed>
(OnCalculatorActionButtonPressed::class.java) {

    class OnCalculatorActionButtonPressed (var action: CalculatorITEM)
}