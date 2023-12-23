package com.example.random.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.random.R
import com.example.random.databinding.FragmentRandomColorBinding
import com.example.random.presenter.viewmodels.BaseViewModel

class RandomColorFragment : BaseFragment(), View.OnClickListener {
    private var mBinding: FragmentRandomColorBinding? = null
    private var mViewModel: BaseViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = FragmentRandomColorBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewModel = BaseViewModel()
        initListener()
        initObserver()
        return mBinding?.root
    }

    private fun initListener() {
        mBinding?.tvRun?.setOnClickListener(this)
    }

    private fun initObserver() {
        mViewModel?.getColorLiveData()?.observe(viewLifecycleOwner) {
            mBinding?.llResult?.setBackgroundColor(it)
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvRun -> {
                context?.let { mViewModel?.getRandomColor(it) }
            }
        }
    }
}