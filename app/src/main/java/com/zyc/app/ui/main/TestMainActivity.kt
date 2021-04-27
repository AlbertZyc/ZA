package com.zyc.app.ui.main

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.zyc.app.ui.main.ui.TestMainViewModel
import com.zyc.extensions.singleClick
import com.zyc.router.RouteConstants
import com.zyc.za.activity.CoreActivity
import com.zyc.za.R
import com.zyc.za.databinding.TestMainActivityBinding
@Route(path = RouteConstants.TEST_MAIN)
class TestMainActivity : CoreActivity<TestMainActivityBinding, TestMainViewModel>() {

    override fun layoutId(): Int = R.layout.test_main_activity
    override fun initViewModel(): TestMainViewModel = TestMainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun addViewAction() {
        super.addViewAction()
        binding.tvCenter.singleClick {

        }
    }
}