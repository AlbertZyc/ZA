package com.zyc.app.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.zyc.test.TestBean
import com.zyc.za.utils.ZLog
import com.zyc.za.viewmodel.CoreViewModel
import java.util.*
import kotlin.concurrent.schedule
import kotlin.random.Random


class TestMainViewModel : CoreViewModel() {
    val testBLiveData = MutableLiveData<TestBean>()


    override fun onCreate() {
        super.onCreate()

    }

    fun postData() {
//        Timer().schedule(3000) {
            testBLiveData.value = TestBean(name = "ZYC", age = Random.nextInt(0, 100))
//        }

    }

}