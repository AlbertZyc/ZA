package com.zyc.app.ui.main.ui

import android.view.View
import androidx.lifecycle.viewModelScope
import com.zyc.test.TestBean
import com.zyc.za.utils.ZLog
import com.zyc.za.viewmodel.CoreViewModel
import kotlinx.coroutines.delay
import java.util.*
import java.util.logging.Handler
import kotlin.concurrent.schedule
import kotlin.random.Random

class TestMainViewModel : CoreViewModel() {
    lateinit var testB: TestBean
    init {
        testB = TestBean()
    }
    override fun onCreate() {
        super.onCreate()

    }

    fun postData() {
        Timer().schedule(3000) {
            testB = TestBean(age = Random.nextInt(0, 100))
        }
        ZLog.i(this, "${testB.age}")
    }

    fun onClick(view: View) {
        ZLog.i(this, "asdasdas")
        postData()
    }


}