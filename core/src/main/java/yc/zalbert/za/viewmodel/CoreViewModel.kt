package yc.zalbert.za.viewmodel

import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT
import androidx.annotation.IntDef
import androidx.annotation.StringRes
import androidx.lifecycle.*
import yc.zalbert.za.CoreConstants

/**
 * @Author AlbertZ
 * @CreateDate 2021/4/22
 * @Description 阿弥陀佛 顾名思义？
 */
abstract class CoreViewModel : ViewModel(), ViewModelLifecycle, ViewBehavior {
    private lateinit var lifecycleOwner: LifecycleOwner

    // toast提示Event
    var eventToast = MutableLiveData<Map<String, *>>()
        private set

    /**
     * 也许你需要一个方法来创建一个ViewModel
     */
    companion object {
        @JvmStatic
        fun <T : CoreViewModel> createViewModelFactory(viewModel: T): ViewModelProvider.Factory {
            return ViewModelFactory(viewModel)
        }
    }

    override fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {
        this.lifecycleOwner = owner
    }

    override fun onStart() {
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onStop() {
    }

    override fun onCreate() {
    }

    override fun onDestroy() {
    }

    override fun showLoadingUI(isShow: Boolean) {
    }

    override fun showEmptyUI(isShow: Boolean) {
    }

    override fun showToast(map: Map<String, *>) {
        eventToast.postValue(map)
    }

    @IntDef(value = [LENGTH_SHORT, LENGTH_LONG])
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    annotation class Duration


    fun showToast(msg: String, @Duration duration: Int) {
        showToast(HashMap<String, Any>().apply {
            put(CoreConstants.TOAST_KEY_CONTENT_TYPE, CoreConstants.TOAST_CONTENT_TYPE_STR)
            put(CoreConstants.TOAST_KEY_CONTENT, msg)
            put(CoreConstants.TOAST_KEY_DURATION, duration)
        })
    }

    fun showToast(msg: String) {
        showToast(HashMap<String, Any>().apply {
            put(CoreConstants.TOAST_KEY_CONTENT_TYPE, CoreConstants.TOAST_CONTENT_TYPE_STR)
            put(CoreConstants.TOAST_KEY_CONTENT, msg)
            put(CoreConstants.TOAST_KEY_DURATION, LENGTH_SHORT)
        })
    }


    fun showToast(@StringRes resId: Int, @Duration duration: Int) {
        showToast(HashMap<String, Any>().apply {
            put(CoreConstants.TOAST_KEY_CONTENT_TYPE, CoreConstants.TOAST_CONTENT_TYPE_RESID)
            put(CoreConstants.TOAST_KEY_CONTENT, resId)
            put(CoreConstants.TOAST_KEY_DURATION, duration)
        })
    }
}