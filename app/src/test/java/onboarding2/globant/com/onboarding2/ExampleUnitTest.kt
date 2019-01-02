package com.globant.counter


import com.globant.counter.mvp.view.CountView
import com.globant.counter.utils.bus.observer.OnCountButtonPressedBusObserver
import com.globant.counter.utils.bus.observer.OnResetButtonPressedBusObserver
import onboarding2.globant.com.onboarding2.CalculatorActivity
import onboarding2.globant.com.onboarding2.mvp.model.CountModel
import onboarding2.globant.com.onboarding2.mvp.presenter.CountPresenter
import onboarding2.globant.com.onboarding2.utils.bus.RxBus
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as whenever

class PresenterTest {

    private var presenter: CountPresenter? = null
    private var model: CountModel? = null
    @Mock
    lateinit var view: CountView
    @Mock
    lateinit var activity: CalculatorActivity

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        model = CountModel()
        // When
        whenever(view.activity).thenReturn(activity)

        presenter = CountPresenter(model!!, view)
    }

    @Test
    fun isShouldIncCountByOne() {
        model!!.reset();
        RxBus.post(OnCountButtonPressedBusObserver.OnCountButtonPressed())

        val count = "1"
        assertEquals(model!!.count, 1)
        verify(view).setCount(count)
    }

    @Test
    fun isShouldResetCount() {
        RxBus.post(OnCountButtonPressedBusObserver.OnCountButtonPressed())
        RxBus.post(OnCountButtonPressedBusObserver.OnCountButtonPressed())
        RxBus.post(OnCountButtonPressedBusObserver.OnCountButtonPressed())
        var count = 3
        assertEquals(model!!.count, count)

        RxBus.post(OnResetButtonPressedBusObserver.OnResetButtonPressed())
        count = 0
        assertEquals(model!!.count, count)
        val invocations = 4
        verify(view, times(invocations)).setCount(anyString());
    }
}