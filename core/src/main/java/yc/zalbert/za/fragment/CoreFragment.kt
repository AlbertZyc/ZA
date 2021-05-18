package yc.zalbert.za.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import yc.zalbert.extensions.isNotNull
import yc.zalbert.za.CoreConstants
import yc.zalbert.za.viewmodel.CoreViewModel
import yc.zalbert.za.viewmodel.ViewBehavior
import me.hgj.jetpackmvvm.ext.util.logi
import yc.zalbert.extensions.observeNonNull

/**
 * @Author AlbertZ
 * @CreateDate 2021/4/21
 * @Description fragment封装
 * TODO 先不考虑没有ViewModel或者ViewDataBinding的情况 默认都有
 */
abstract class CoreFragment<B : ViewDataBinding, VM : CoreViewModel> : Fragment(),
    ViewBehavior {

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
        onInitUIBehavior()
        onInitObserver()
        return rootView
    }

    /**
     * ViewModel传入
     */
    protected abstract fun initViewModel(): VM

    /**
     * 初始化 ViewModel
     */
    protected fun onInitViewModel() {
        val vm = initViewModel()
        viewModel = ViewModelProvider(this, CoreViewModel.createViewModelFactory(vm))
            .get(vm::class.java)
        lifecycle.addObserver(viewModel)
    }

    private fun onInitUIBehavior() {
        viewModel.eventToast.observeNonNull(this) {
            showToast(it)
        }
    }

    /**
     * DataBind初始化
     */
    protected fun onInitDataBind(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        binding.lifecycleOwner = this
    }

    /**
     * 更新事件订阅
     */
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

    fun onFragmentVisibilityChanged() {
//        isAdded && !isHidden && mView != null && mView.windowToken != null && mView.visibility == View.VISIBLE

//        if (isVisible){
//
//        }
    }

    override fun onResume() {
        super.onResume()
        if (!isLoaded && !isHidden) {
            onLazyInit()
            isLoaded = true
        }
        isVisible.logi("isVisible =")
        isAdded.logi("isAdded =")
        isHidden.logi("isHidden =")
        logi("abcd")
        rootView?.visibility?.logi("rootView.visibility = ")
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

    override fun showLoadingUI(isShow: Boolean) {
    }

    override fun showEmptyUI(isShow: Boolean) {
    }

    protected fun showToast(str: String) {
        showToast(str, Toast.LENGTH_SHORT)
    }

    protected fun showToast(str: String, duration: Int) {
        showToast(HashMap<String, Any>().apply {
            put(CoreConstants.TOAST_KEY_CONTENT_TYPE, CoreConstants.TOAST_CONTENT_TYPE_STR)
            put(CoreConstants.TOAST_KEY_CONTENT, str)
            put(CoreConstants.TOAST_KEY_DURATION, duration)
        })
    }

    override fun showToast(map: Map<String, *>) {
        if (map[CoreConstants.TOAST_KEY_CONTENT_TYPE] == CoreConstants.TOAST_CONTENT_TYPE_STR) {
            Toast.makeText(
                context,
                map[CoreConstants.TOAST_KEY_CONTENT] as String,
                map[CoreConstants.TOAST_KEY_DURATION] as Int
            ).show()
        } else if (map[CoreConstants.TOAST_KEY_CONTENT_TYPE] == CoreConstants.TOAST_CONTENT_TYPE_RESID) {
            Toast.makeText(
                context,
                map[CoreConstants.TOAST_KEY_CONTENT] as Int,
                map[CoreConstants.TOAST_KEY_DURATION] as Int
            ).show()
        }
    }

}