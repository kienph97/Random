package com.example.random

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.random.databinding.FragmentLuckyNumberBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LuckyNumberFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LuckyNumberFragment : BaseFragment(), View.OnClickListener {
    private var mBinding: FragmentLuckyNumberBinding? = null
    private var mLuckyNumberViewModel: LuckyNumberViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = FragmentLuckyNumberBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mLuckyNumberViewModel = LuckyNumberViewModel()
        initListener()
        initObserver()
        return mBinding?.root
    }

    private fun initListener() {
        mBinding?.tvLuckyNumber?.setOnClickListener(this)
    }
    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.tvLuckyNumber -> {
                handleFindNumber()
            }
        }
    }

    private fun handleFindNumber() {
        val start = mBinding?.edtStart?.text.toString().replace(" ", "")
        val end = mBinding?.edtEnd?.text.toString().replace(" ", "")
        if (start.isNotEmpty() && end.isNotEmpty() && start.toInt() < end.toInt()) {
            mLuckyNumberViewModel?.getLuckyNumber(start.toInt(), end.toInt())
        } else {
            mBinding?.apply {
                tvResult.isVisible = false
                tvError.isVisible = true
            }
        }
    }

    private fun initObserver() {
        mLuckyNumberViewModel?.getLuckyNumberLiveData()?.observe(viewLifecycleOwner) {
            mBinding?.apply {
                tvResult.isVisible = true
                tvResult.text = it.toString()
                tvError.isVisible = false
            }
        }
    }

}