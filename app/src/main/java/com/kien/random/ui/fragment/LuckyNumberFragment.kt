package com.kien.random.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.kien.random.presenter.viewmodels.LuckyNumberViewModel
import com.kien.random.R
import com.kien.random.databinding.FragmentLuckyNumberBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 * Use the [LuckyNumberFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LuckyNumberFragment : BaseFragment(), View.OnClickListener {
    private var mBinding: FragmentLuckyNumberBinding? = null
    private var mLuckyNumberViewModel: LuckyNumberViewModel? = null
    private var start = ""
    private var end = ""

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
        start = mBinding?.edtStart?.text.toString().replace(" ", "")
        end = mBinding?.edtEnd?.text.toString().replace(" ", "")
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
                tvError.isVisible = false
                CoroutineScope(Dispatchers.Main).launch {
                    var job = launch {
                        if (end.toInt() - start.toInt() < 10) {
                            for (i in start.toInt() until end.toInt()) {
                                delay(100L)
                                tvResult.text = i.toString()
                            }
                        } else if (end.toInt() - start.toInt() < 100) {
                            for (i in start.toInt() until end.toInt()) {
                                delay(1L)
                                tvResult.text = i.toString()
                            }
                        } else {
                            for (i in start.toInt() until start.toInt()+100) {
                                delay(1L)
                                tvResult.text = i.toString()
                            }
                        }

                    }
                    job.join()
                    tvResult.text = it.toString()
                }


            }

        }
    }

}