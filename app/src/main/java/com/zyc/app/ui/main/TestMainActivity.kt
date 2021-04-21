package com.zyc.app.ui.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.zyc.app.ui.main.ui.main.TestMainFragment
import com.zyc.za.CoreActivity
import com.zyc.za.R
import com.zyc.za.databinding.TestMainActivityBinding

class TestMainActivity : CoreActivity() {
    val binding : TestMainActivityBinding = DataBindingUtil.setContentView(this,R.layout.test_main_activity)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction().replace(R.id.container, TestMainFragment.newInstance()).commitNow()
//        }
    }
}