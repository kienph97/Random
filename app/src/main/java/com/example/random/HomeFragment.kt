package com.example.random

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.random.databinding.FragmentHomeBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : BaseFragment(), View.OnClickListener {
    private var mBinding: FragmentHomeBinding? = null
    private val mHomeAdapter by lazy { HomeAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initView()
        initListener()
        return mBinding?.root
    }

    private fun initListener() {
        mBinding?.imvMenu?.setOnClickListener(this)
        mBinding?.viewHide?.setOnClickListener(this)
    }

    private fun initView() {
        context?.let { HomeModel().getListItem(it) }?.let { mHomeAdapter.setData(it) }
        mBinding?.rcvItemHome?.apply {
            adapter = mHomeAdapter
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
        }

        mHomeAdapter.setCallBackClickItem {
            when(it) {
                1 -> {
                    navigateToNewScreen(R.id.action_homeFragment_to_luckyNumberFragment)
                }
                2 -> {
                    navigateToNewScreen(R.id.action_homeFragment_to_yesOrNoFragment)
                }
                3 -> {
                    navigateToNewScreen(R.id.action_homeFragment_to_chooseListFragment)
                }
                4 -> {
                    navigateToNewScreen(R.id.action_homeFragment_to_RPSFragment)
                }
                5 -> {
                    navigateToNewScreen(R.id.action_homeFragment_to_randomCoinFragment)
                }
                6 -> {
                    navigateToNewScreen(R.id.action_homeFragment_to_randomColorFragment)
                }
                7 -> {
                    navigateToNewScreen(R.id.action_homeFragment_to_randomDiceFragment)
                }
            }
        }
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