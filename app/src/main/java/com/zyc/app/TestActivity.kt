package com.zyc.app

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.zyc.za.CoreActivity
import com.zyc.za.R
import com.zyc.za.queue.LogTask
import com.zyc.za.queue.TaskPriority

/**
@Author AlbertZ
@CreateDate 2021/2/8
@Description 描述
 */
public class TestActivity : CoreActivity() {
    var num = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<TextView>(R.id.text).setOnClickListener {
            num++
            val logTask = LogTask("abhc$num").enqueue()
        }
    }
}