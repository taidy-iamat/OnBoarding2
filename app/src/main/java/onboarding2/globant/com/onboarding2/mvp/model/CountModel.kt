package onboarding2.globant.com.onboarding2.mvp.model

class CountModel {

    var count = 0
        private set

    fun reset() {
        count = 0
    }

    fun inc() {
        count += 1
    }

}
