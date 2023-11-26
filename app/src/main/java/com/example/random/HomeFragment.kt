package com.example.random

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.random.databinding.FragmentHomeBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : BaseFragment(), View.OnClickListener {
    private var mBinding: FragmentHomeBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initListener()
        return mBinding?.root
    }

    private fun initListener() {
        mBinding?.imvMenu?.setOnClickListener(this)
        mBinding?.viewHide?.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.imvMenu -> {
                mBinding?.apply {
                    llNavigationDrawer.isVisible = true
                    viewHide.isVisible = true
                }
            }
            R.id.viewHide -> {
                mBinding?.apply {
                    llNavigationDrawer.isVisible = false
                    viewHide.isVisible = false
                }
            }
        }

    }

}