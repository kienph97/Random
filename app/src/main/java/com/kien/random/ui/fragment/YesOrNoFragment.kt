package com.kien.random.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kien.random.R
import com.kien.random.databinding.FragmentYesOrNoBinding
import com.kien.random.presenter.viewmodels.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
            CoroutineScope(Dispatchers.Main).launch {
                var job = launch {
                    for (i in 0 until 7) {
                        delay(100L)
                        mBinding.tvResult.text = "Yes"
                        delay(100L)
                        mBinding.tvResult.text = "No"
                    }
                }
                job.join()
                mBinding.tvResult.text = it
            }
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