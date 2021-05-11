package com.zyc.za.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.zyc.extensions.isNotNull
import com.zyc.extensions.isNull
import com.zyc.za.viewmodel.CoreViewModel

/**
 * @Author AlbertZ
 * @CreateDate 2021/4/21
 * @Description fragment封装
 * TODO 先不考虑没有ViewModel或者ViewDataBinding的情况 默认都有
 */
abstract class CoreFragment<B : ViewDataBinding, VM : CoreViewModel> : Fragment() {

    protected lateinit var binding: B
        private set

    protected lateinit var viewModel: VM
        private set

    lateinit var mContext: Context

    lateinit var mActivity: Activity

    private var isLoaded = false

    private var rootView: View? = null

    @LayoutRes
    abstract fun layoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (rootView.isNotNull()) {
            return rootView
        }
        rootView = inflater.inflate(layoutId(), container, false)
        onInitDataBind(inflater, container)
        onInitViewModel()
        onInitObserver()
        return rootView
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
        this.mContext = context
        this.mActivity = context as Activity
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

    /**
     * 懒加载方案
     */
    protected fun onLazyInit() {

    }

}