package com.kien.random.modules.coin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kien.random.R
import com.kien.random.common.ui.fragments.BaseFragment
import com.kien.random.databinding.FragmentRandomCoinBinding
import com.kien.random.common.viewmodels.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class RandomCoinFragment : BaseFragment(), View.OnClickListener {
    private var mBinding: FragmentRandomCoinBinding? = null
    @Inject lateinit var mViewModel: BaseViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = FragmentRandomCoinBinding.inflate(layoutInflater)
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
        mViewModel.getCoinLiveData().observe(viewLifecycleOwner) {
            CoroutineScope(Dispatchers.Main).launch {
                var job  = launch {
                    for (i in 0 until 7) {
                        delay(100)
                        when (i % 2) {
                            0 -> {
                                mBinding?.imvResult?.setImageResource(R.drawable.ic_coin_n)
                            }
                            1 -> {
                                mBinding?.imvResult?.setImageResource(R.drawable.ic_coin_s)
                            }
                        }
                    }
                }
                job.join()
                when (it) {
                    0 -> {
                        mBinding?.imvResult?.setImageResource(R.drawable.ic_coin_n)
                    }
                    1 -> {
                        mBinding?.imvResult?.setImageResource(R.drawable.ic_coin_s)
                    }
                }
            }

        }

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvRun -> {
                mViewModel.getRandomCoin()
            }

        }
    }
}