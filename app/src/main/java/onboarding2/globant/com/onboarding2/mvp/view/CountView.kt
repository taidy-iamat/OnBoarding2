package com.globant.counter.mvp.view


import android.app.Activity
import android.text.TextUtils

import kotlinx.android.synthetic.main.activity_calculator.*
import onboarding2.globant.com.onboarding2.mvp.model.CalculatorITEM
import onboarding2.globant.com.onboarding2.utils.bus.RxBus
import onboarding2.globant.com.onboarding2.utils.bus.observer.*


class CountView(activity: Activity) : ActivityView(activity) {
    fun setExpression(expression: String) {
        activity?.text_expression?.text = expression
    }

    init {
        activity.btn_sum.setOnClickListener {
            getInput()
            RxBus.post(OnCalculatorActionItemPressedBusObserver.OnCalculatorActionButtonPressed(CalculatorITEM.SUMA))

        }

        activity.btn_div.setOnClickListener {
            getInput()
            RxBus.post(OnCalculatorActionItemPressedBusObserver.OnCalculatorActionButtonPressed(CalculatorITEM.DIVS))

        }

        activity.btn_multi.setOnClickListener {
            getInput()
            RxBus.post(OnCalculatorActionItemPressedBusObserver.OnCalculatorActionButtonPressed(CalculatorITEM.MULTIP))

        }

        activity.btn_rest.setOnClickListener {
            getInput()
            RxBus.post(OnCalculatorActionItemPressedBusObserver.OnCalculatorActionButtonPressed(CalculatorITEM.RESTA))

        }

        activity.btn_equal.setOnClickListener {
            getInput()
            RxBus.post(OnCalculatorEqualButtonPressedBusObserver.OnCalculatorEqualButtonPressed())
        }

        activity.btn_clear.setOnClickListener {
            RxBus.post(OnCalculatorClearButtonPressedBusObserver.OnCalculatorClearButton())
        }

    }

    private fun getInput() {
        var input = activity?.input_number?.text.toString()
        if (!TextUtils.isEmpty(input)) {
            RxBus.post(OnCalculatorNumberButtonPressedBusObserver.OnCalculatorNumberButtonPressed(input.toFloat()))
        }
        activity?.input_number?.setText("")
    }

    fun clear() {
        activity?.input_number?.setText("")
        activity?.text_expression?.text = ""
    }

}