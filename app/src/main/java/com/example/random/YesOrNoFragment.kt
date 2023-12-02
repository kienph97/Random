package com.example.random

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.random.databinding.FragmentYesOrNoBinding

class YesOrNoFragment : BaseFragment(), View.OnClickListener {
    private lateinit var mBinding: FragmentYesOrNoBinding
    private var mBaseViewModel: BaseViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentYesOrNoBinding.inflate(layoutInflater)
        mBaseViewModel = BaseViewModel()
        initListener()
        initObserver()
        return mBinding.root
    }

    private fun initListener() {
        mBinding.tvYesOrNo.setOnClickListener(this)
    }

    private fun initObserver() {
        mBaseViewModel?.getYesOrNoLiveData()?.observe(viewLifecycleOwner) {
            mBinding.tvResult.text = it
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvYesOrNo -> {
                context?.let { mBaseViewModel?.getYesOrNo(it) }
            }
        }
    }

}