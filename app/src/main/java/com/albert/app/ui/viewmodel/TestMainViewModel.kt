package com.albert.app.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import yc.zalbert.test.TestBean
import yc.zalbert.za.viewmodel.CoreViewModel

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