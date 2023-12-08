package com.example.random

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.random.databinding.FragmentRandomCoinBinding
import com.example.random.databinding.FragmentRandomColorBinding

class RandomCoinFragment : BaseFragment(), View.OnClickListener {
    private var mBinding: FragmentRandomCoinBinding? = null
    private var mViewModel: BaseViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = FragmentRandomCoinBinding.inflate(layoutInflater)
        mViewModel = BaseViewModel()
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
        mViewModel?.getCoinLiveData()?.observe(viewLifecycleOwner) {
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

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvRun -> {
                mViewModel?.getRandomCoin()
            }

        }
    }
}