package com.zyc.app.ui.main

import com.zyc.app.ui.main.ui.main.TestMainViewModel
import com.zyc.za.CoreActivity
import com.zyc.za.R
import com.zyc.za.databinding.TestMainActivityBinding

class TestMainActivity : CoreActivity<TestMainActivityBinding, TestMainViewModel>() {
    override fun layoutId(): Int = R.layout.test_main_activity
    override fun initViewModel() = TestMainViewModel()


}