package com.zyc.za.fragment

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.zyc.za.viewmodel.CoreViewModel

/**
@Author AlbertZ
@CreateDate 2021/4/21
@Description 描述
 */
abstract class CoreFragment<B : ViewDataBinding, VM : CoreViewModel> : Fragment() {

    protected lateinit var binding: B
        private set

    protected lateinit var viewModel: VM
        private set

    lateinit var mContext: Context

    private var isLoaded = false

    @LayoutRes
    abstract fun layoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        onInitDataBind(inflater, container)
        onInitViewModel()
        onInitObserver()
        return super.onCreateView(inflater, container, savedInstanceState)
    }



    protected abstract fun initViewModel(): VM

    protected fun onInitViewModel() {
        val vm = initViewModel()
        viewModel = ViewModelProvider(this, CoreViewModel.createViewModelFactory(vm))
            .get(vm::class.java)
        lifecycle.addObserver(viewModel)
    }


    protected fun onInitDataBind(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        binding.lifecycleOwner = this
    }
    protected open fun onInitObserver() {

    }
    override fun onDestroyView() {
        binding.unbind()
        isLoaded = false
        super.onDestroyView()
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        if (!isLoaded && !isHidden) {
            onLazyInit()
            isLoaded = true
        }
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        lifecycle.removeObserver(viewModel)
        super.onDestroy()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
    }

    abstract fun onLazyInit()

}