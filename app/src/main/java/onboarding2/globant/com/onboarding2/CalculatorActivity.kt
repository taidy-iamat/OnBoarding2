package onboarding2.globant.com.onboarding2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.globant.counter.mvp.view.CountView
import onboarding2.globant.com.onboarding2.mvp.model.CalculatorModel
import onboarding2.globant.com.onboarding2.mvp.model.CountModel
import onboarding2.globant.com.onboarding2.mvp.presenter.CountPresenter
import onboarding2.globant.com.onboarding2.utils.bus.RxBus

class CalculatorActivity : AppCompatActivity() {


    private var presenter: CountPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        presenter = CountPresenter(CalculatorModel(), CountView(this))
    }

    override fun onDestroy() {
        super.onDestroy()
        RxBus.clear(this)
    }
}