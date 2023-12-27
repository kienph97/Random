package com.example.random.ui.fragment

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.random.R
import com.example.random.databinding.FragmentHomeBinding
import com.example.random.entities.HomeModel
import com.example.random.presenter.adapters.HomeAdapter

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
        mBinding?.feedback?.setOnClickListener(this)
        mBinding?.rate?.setOnClickListener(this)
        mBinding?.share?.setOnClickListener(this)
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
                    val transition = Slide()
                    transition.duration = 300
                    transition.slideEdge = Gravity.LEFT
                    TransitionManager.beginDelayedTransition(llNavigationDrawer, transition)
                    llNavigationDrawer.visibility = View.VISIBLE
                    viewHide.isVisible = true
                }
            }
            R.id.viewHide -> {
                mBinding?.apply {
                    llNavigationDrawer.isVisible = false
                    viewHide.isVisible = false
                }
            }
            R.id.share -> {
                Toast.makeText(context, context?.getString(R.string.this_feature_will_be_update_in_next_version), Toast.LENGTH_SHORT).show()
            }
            R.id.rate -> {
                Toast.makeText(context, context?.getString(R.string.this_feature_will_be_update_in_next_version), Toast.LENGTH_SHORT).show()
            }
            R.id.feedback -> {
                Toast.makeText(context, context?.getString(R.string.this_feature_will_be_update_in_next_version), Toast.LENGTH_SHORT).show()
            }
        }

    }

}