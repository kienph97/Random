package com.kien.random.modules.rotatebottle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import com.kien.random.R
import com.kien.random.common.ui.fragments.BaseFragment
import com.kien.random.databinding.FragmentRotateBottleBinding
import com.kien.random.common.viewmodels.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class RotateBottleFragment : BaseFragment(), View.OnClickListener {
    private var mBinding: FragmentRotateBottleBinding? = null
    @Inject lateinit var mViewModel: BaseViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = FragmentRotateBottleBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initListener()
        initObserver()
        return mBinding?.root
    }

    private fun initListener() {
        mBinding?.tvRotate?.setOnClickListener(this)
    }

    private fun initObserver() {
        mViewModel.getRotateBottleLiveData().observe(viewLifecycleOwner) {
            val rotate = RotateAnimation(FROM_DEGREES, it.toFloat(), Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
            rotate.duration = DURATION.toLong()
            rotate.fillAfter = true
            mBinding?.imvResult?.startAnimation(rotate)
        }

    }



    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvRotate -> {
                mViewModel.getRandomRotate()
            }

        }
    }

    companion object {
        const val DURATION = 1000
        const val FROM_DEGREES = 0F
    }
}