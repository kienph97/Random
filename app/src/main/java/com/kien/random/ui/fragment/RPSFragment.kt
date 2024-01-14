package com.kien.random.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import com.kien.random.R
import com.kien.random.databinding.FragmentRPSBinding
import com.kien.random.presenter.viewmodels.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RPSFragment : BaseFragment(), View.OnClickListener {
    private var mBinding: FragmentRPSBinding? = null
    private var mViewModel: BaseViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = FragmentRPSBinding.inflate(layoutInflater)
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
        mViewModel?.getRPSLiveData()?.observe(viewLifecycleOwner) {
            CoroutineScope(Dispatchers.Main).launch {
                var job = launch {
                    for (i in 0 until 6) {
                        delay(100L)

                        mBinding?.imvResult?.setImageResource(
                            when (i % 3) {
                                0 -> R.drawable.ic_bua
                                1 -> R.drawable.ic_leaf
                                else -> {
                                    R.drawable.ic_keo
                                }
                            }
                        )
                    }
                }
                job.join()
                mBinding?.imvResult?.setImageResource(
                    when (it) {
                        0 -> R.drawable.ic_bua
                        1 -> R.drawable.ic_leaf
                        else -> {
                            R.drawable.ic_keo
                        }
                    }
                )
            }
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvRun -> {
                mViewModel?.getRandomRPS()
            }
        }
    }
}