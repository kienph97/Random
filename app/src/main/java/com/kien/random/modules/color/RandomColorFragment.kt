package com.kien.random.modules.color

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kien.random.R
import com.kien.random.common.ui.fragments.BaseFragment
import com.kien.random.databinding.FragmentRandomColorBinding
import com.kien.random.common.viewmodels.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RandomColorFragment : BaseFragment(), View.OnClickListener {
    private var mBinding: FragmentRandomColorBinding? = null
    @Inject lateinit var mViewModel: BaseViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = FragmentRandomColorBinding.inflate(layoutInflater)
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
        mBinding?.tvRun?.setOnClickListener(this)
    }

    private fun initObserver() {
        mViewModel.getColorLiveData().observe(viewLifecycleOwner) {
            mBinding?.llResult?.background?.setColorFilter(Color.parseColor(it.code), PorterDuff.Mode.SRC_ATOP)
            mBinding?.tvNameColor?.text = it.code
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvRun -> {
                val colorModel = ColorModel()
                context?.let { mViewModel.getRandomColor(it, colorModel) }
            }
        }
    }
}