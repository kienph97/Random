package com.kien.random.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.kien.random.BuildConfig
import com.kien.random.R
import com.kien.random.databinding.FragmentHomeBinding
import com.kien.random.presenter.adapters.HomeAdapter

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
        mBinding?.privacyPolicy?.setOnClickListener(this)
    }

    private fun initView() {
        context?.let { com.kien.random.entities.HomeModel().getListItem(it) }?.let { mHomeAdapter.setData(it) }
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
                try {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name")
                    shareIntent.putExtra(Intent.EXTRA_TEXT, URL_APP)
                    startActivity(Intent.createChooser(shareIntent, "choose one"))
                } catch (e: Exception) {
                    Log.e("LOG", "$e")
                }
            }
            R.id.rate -> {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(URL_APP)
                startActivity(intent)
            }
            R.id.feedback -> {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(URL_APP)
                startActivity(intent)
            }
            R.id.privacyPolicy -> {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(URL)
                startActivity(intent)
            }
        }

    }
    companion object {
        const val URL = "https://www.freeprivacypolicy.com/live/d5983e33-6ac4-407d-b72f-1b017aa4bf17"
        const val URL_APP = "https://play.google.com/store/apps/details?id=com.kien.random"
    }
}