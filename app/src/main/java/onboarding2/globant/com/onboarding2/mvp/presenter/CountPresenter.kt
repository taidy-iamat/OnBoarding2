package onboarding2.globant.com.onboarding2.mvp.presenter



import onboarding2.globant.com.onboarding2.mvp.model.CalculatorModel
import onboarding2.globant.com.onboarding2.mvp.view.CountView
import onboarding2.globant.com.onboarding2.utils.bus.RxBus
import onboarding2.globant.com.onboarding2.utils.bus.observer.*

open class CountPresenter(model: CalculatorModel, view: CountView) {

    init {

        val activity = view.activity
        if (activity != null) {
            RxBus.subscribe(activity, object : OnCalculatorActionItemPressedBusObserver() {
                override fun onEvent(value: OnCalculatorActionButtonPressed) {
                    model.action = value.action
                    view.setExpression(model.getExpression())
                }
            })

            RxBus.subscribe(activity, object : OnCalculatorNumberButtonPressedBusObserver() {
                override fun onEvent(value: OnCalculatorNumberButtonPressed) {
                    model.setOperator(value.number)
                    view.setExpression(model.getExpression())
                }
            })

            RxBus.subscribe(activity, object  : OnCalculatorEqualButtonPressedBusObserver() {
                override fun onEvent(value: OnCalculatorEqualButtonPressed) {
                    view.setExpression(model.getResult())
                }
            })

            RxBus.subscribe(activity, object : OnCalculatorClearButtonPressedBusObserver() {
                override fun onEvent(value: OnCalculatorClearButton) {
                    model.clear()
                    view.clear()
                }

            })

        }
    }

}
