package com.zyc.test

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.zyc.za.CoreActivity
import com.zyc.za.CoreApplication.Companion.instance
import com.zyc.za.R
import java.util.*

/**
@Author AlbertZ
@CreateDate 2021/2/4
@Description 描述
 */
class MainActivity : CoreActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun layoutId() = R.layout.activity_main;

}