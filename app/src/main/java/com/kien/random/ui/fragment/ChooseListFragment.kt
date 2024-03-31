package com.kien.random.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kien.random.ui.dialogs.InputItemDialog
import com.kien.random.R
import com.kien.random.presenter.adapters.SelectItemAdapter
import com.kien.random.databinding.FragmentChooseListBinding
import com.kien.random.presenter.viewmodels.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ChooseListFragment : BaseFragment(), View.OnClickListener {
    private var mBinding: FragmentChooseListBinding? = null
    @Inject lateinit var mAdapter: SelectItemAdapter
    private val mListItem = arrayListOf<String>()
    @Inject lateinit var mViewModel : BaseViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = FragmentChooseListBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initView()
        initListener()
        initObserver()
        return mBinding?.root
    }

    private fun initView() {
        mBinding?.rcvItem?.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mBinding?.rcvItem?.adapter = mAdapter
    }

    private fun initListener() {
        mBinding?.apply {
            tvAddItem.setOnClickListener(this@ChooseListFragment)
            tvSelect.setOnClickListener(this@ChooseListFragment)
        }
    }

    private fun initObserver() {
        mViewModel.getChooseItemLiveData().observe(viewLifecycleOwner) {
            val dialog = InputItemDialog.newInstance(mListItem.getOrNull(it)){

            }
            dialog.show(parentFragmentManager, "Tag")
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvAddItem -> {
                val dialog = InputItemDialog.newInstance {
                    mListItem.add(it)
                    mAdapter.setList(mListItem)
                    mAdapter.notifyItemInserted(mListItem.size - 1)
                    mBinding?.tvSelect?.apply {
                        isEnabled = true
                        alpha = 1F
                    }
                }
                dialog.show(parentFragmentManager, "Tag")
            }

            R.id.tvSelect -> {
                mViewModel.getRandomItem(0, mListItem.size - 1)
            }

        }
    }
}