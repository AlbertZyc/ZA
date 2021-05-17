package com.zyc.za.viewmodel

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
     * 不带参数的页面跳转
     */
//    fun navigate(page: Any)

}