package com.zyc.app

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.zyc.za.CoreActivity
import com.zyc.za.R

/**
@Author AlbertZ
@CreateDate 2021/2/8
@Description 描述
 */
public class TestActivity : CoreActivity() {
    override fun layoutId(): Int {
        return R.layout.activity_test
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}