package yc.zalbert.za.viewmodel

/**
 * @Author AlbertZ
 * @CreateDate 2021/05/15
 * @Description Nothing
 */
interface ViewBehavior {
    /**
     * 是否显示Loading视图
     */
    fun showLoadingUI(isShow: Boolean) {

    }

    /**
     * 是否显示空白视图
     */
    fun showEmptyUI(isShow: Boolean) {

    }

    /**
     * 弹出Toast提示
     */
    fun showToast(map: Map<String, *>) {

    }

    /**
     * 页面跳转
     */
    fun  goto(page: String) {
        
    }

}