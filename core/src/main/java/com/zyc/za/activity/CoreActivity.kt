package com.zyc.za.activity

import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.zyc.za.CoreApplication
import com.zyc.za.viewmodel.CoreViewModel

/**
 * @Author AlbertZ
 * @CreateDate 2021/3/18
 * @Description 阿弥陀佛，正常人都知道这是干嘛
 */

abstract class CoreActivity<B : ViewDataBinding, VM : CoreViewModel> : AppCompatActivity() {
    protected lateinit var viewModel: VM
        private set
    protected lateinit var binding: B
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onInitContentView()
        onInitViewModel()
        addViewAction()
        CoreApplication.instance.putActivity(this)
    }

    /**
     * i simply want you to put the layout's id in.
     */
    @LayoutRes
    abstract fun layoutId(): Int

    protected open fun addViewAction() {}

    protected open fun onInitContentView() {
        setContentView(layoutId())
        onInitDataBind()
    }


    abstract fun initViewModel(): VM

    /**
     * you need modify this method , i do not think so .
     */
    protected fun onInitDataBind() {
        binding = DataBindingUtil.setContentView(this, layoutId())
        binding.lifecycleOwner = this
    }

    fun onInitViewModel() {
        val vm = initViewModel()
        viewModel = ViewModelProvider(this, CoreViewModel.createViewModelFactory(vm)).get(vm::class.java)
        lifecycle.addObserver(viewModel)
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

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        binding.unbind()
        lifecycle.removeObserver(viewModel)
        CoreApplication.instance.removeActivity(this)
        super.onDestroy()
    }

    fun getActivity(): CoreActivity<B, VM> = this


}