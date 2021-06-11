package com.albert.app.ui.main

import com.albert.app.ui.viewmodel.IdealMainViewModel
import com.albert.za.R
import com.albert.za.databinding.FragmentIdealBinding
import yc.zalbert.extensions.singleClick
import yc.zalbert.za.fragment.CoreFragment

/**
@Author AlbertZ
@CreateDate 2021/5/14
@Description 描述
 */
class IdealFragment : CoreFragment<FragmentIdealBinding, IdealMainViewModel>() {
    override fun layoutId() = R.layout.fragment_ideal

    override fun initViewModel() = IdealMainViewModel()
    val NO_GRAVITY = 0x0000

    val AXIS_SPECIFIED = 0x0001
    val AXIS_PULL_BEFORE = 0x0002
    val AXIS_PULL_AFTER = 0x0004
    val AXIS_X_SHIFT = 0
    val AXIS_Y_SHIFT = 4

    val TOP = AXIS_PULL_BEFORE or AXIS_SPECIFIED shl AXIS_Y_SHIFT
    val BOTTOM = AXIS_PULL_AFTER or AXIS_SPECIFIED shl AXIS_Y_SHIFT
    val LEFT = AXIS_PULL_BEFORE or AXIS_SPECIFIED shl AXIS_X_SHIFT
    val RIGHT = AXIS_PULL_AFTER or AXIS_SPECIFIED shl AXIS_X_SHIFT
    val CENTER_VERTICAL = AXIS_SPECIFIED shl AXIS_Y_SHIFT
    val FILL_VERTICAL = TOP or BOTTOM
    val CENTER_HORIZONTAL = AXIS_SPECIFIED shl AXIS_X_SHIFT
    val FILL_HORIZONTAL = LEFT or RIGHT
    val CENTER = CENTER_VERTICAL or CENTER_HORIZONTAL

    override fun onInitObserver() {
        super.onInitObserver()
        binding.tvContent.singleClick {

        }
    }

}