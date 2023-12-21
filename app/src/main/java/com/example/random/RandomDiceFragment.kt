package com.example.random

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.random.databinding.FragmentRandomDiceBinding

class RandomDiceFragment : BaseFragment(), View.OnClickListener {
    private var mBinding: FragmentRandomDiceBinding? = null
    private var mViewModel: BaseViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = FragmentRandomDiceBinding.inflate(layoutInflater)
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

    private fun initObserver() {
        mViewModel?.getDiceRandomLiveData()?.observe(viewLifecycleOwner) {
            mBinding?.imvResult?.drawDice(it)
        }
    }

    private fun initListener() {
        mBinding?.tvRun?.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvRun -> {
                val text = mBinding?.edtNumber?.text?.toString()
                var number = 0
                if (!text.isNullOrEmpty()) {
                    number = text.toInt()
                }

                if (number == 0) {
                    mBinding?.tvError?.isVisible = true
                    mBinding?.tvError?.text = context?.getString(R.string.please_input_number_dice)
                    mBinding?.imvResult?.isVisible = false
                }else if (number > 4) {
                    mBinding?.tvError?.isVisible = true
                    mBinding?.tvError?.text = context?.getString(R.string.maximum_fore_dice)
                    mBinding?.imvResult?.isVisible = false
                } else {
                    mBinding?.tvError?.isVisible = false
                    mBinding?.imvResult?.isVisible = true
                    mViewModel?.getRandomDice(number)
                }
            }
        }
    }
}