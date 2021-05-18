package yc.zalbert.za.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import yc.zalbert.extensions.observeNonNull
import yc.zalbert.za.CoreConstants
import yc.zalbert.za.lifecycle.ActivityController
import yc.zalbert.za.viewmodel.CoreViewModel
import yc.zalbert.za.viewmodel.ViewBehavior

/**
 * @Author AlbertZ
 * @CreateDate 2021/3/18
 * @Description 阿弥陀佛，正常人都知道这是干嘛
 * TODO 先不考虑没有ViewModel或者ViewDataBinding的情况 默认都有
 */

abstract class CoreActivity<B : ViewDataBinding, VM : CoreViewModel> : AppCompatActivity(),
    ViewBehavior {
    protected lateinit var viewModel: VM
        private set
    protected lateinit var binding: B
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onInitContentView()
        onInitDataBind()
        onInitViewModel()
        onInitObserver()
        onInitUIBehavior()
        addViewAction()
        ActivityController.pushActivity(this)
    }

    private fun onInitUIBehavior() {
        viewModel.eventToast.observeNonNull(this) {
            showToast(it)
        }
    }

    /**
     * i simply want you to put the layout's id in.
     */
    @LayoutRes
    abstract fun layoutId(): Int

    protected open fun addViewAction() {}

    protected open fun onInitContentView() {
        setContentView(layoutId())
    }


    abstract fun initViewModel(): VM

    /**
     * you need modify this method , i do not think so .
     */
    protected fun onInitDataBind() {
        binding = DataBindingUtil.setContentView(this, layoutId())
        binding.lifecycleOwner = this
    }

    protected fun onInitViewModel() {
        val vm = initViewModel()
        viewModel =
            ViewModelProvider(this, CoreViewModel.createViewModelFactory(vm)).get(vm::class.java)
        lifecycle.addObserver(viewModel)
    }

    protected open fun onInitObserver() {

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
        ActivityController.popActivity(this)
        super.onDestroy()
    }

    fun getActivity(): CoreActivity<B, VM> = this
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
                this,
                map[CoreConstants.TOAST_KEY_CONTENT] as String,
                map[CoreConstants.TOAST_KEY_DURATION] as Int
            ).show()
        } else if (map[CoreConstants.TOAST_KEY_CONTENT_TYPE] == CoreConstants.TOAST_CONTENT_TYPE_RESID) {
            Toast.makeText(
                this,
                map[CoreConstants.TOAST_KEY_CONTENT] as Int,
                map[CoreConstants.TOAST_KEY_DURATION] as Int
            ).show()
        }
    }

}