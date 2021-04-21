package com.zyc.za

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


abstract  class CoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoreApplication.instance.putActivity(this)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        CoreApplication.instance.removeActivity(this)
        super.onDestroy()
    }

    fun getActivity(): CoreActivity = this


}