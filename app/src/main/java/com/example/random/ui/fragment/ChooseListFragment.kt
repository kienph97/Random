package com.example.random.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.random.ui.dialogs.InputItemDialog
import com.example.random.R
import com.example.random.presenter.adapters.SelectItemAdapter
import com.example.random.databinding.FragmentChooseListBinding
import com.example.random.presenter.viewmodels.BaseViewModel

class ChooseListFragment : BaseFragment(), View.OnClickListener {
    private var mBinding: FragmentChooseListBinding? = null
    private var mAdapter: SelectItemAdapter? = null
    private val mListItem = arrayListOf<String>()
    private var mViewModel = BaseViewModel()
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
        mAdapter = SelectItemAdapter()
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
            val dialog = InputItemDialog.newInstance(mListItem.getOrNull(it)) {

            }
            dialog.show(parentFragmentManager, "Tag")
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvAddItem -> {
                val dialog = InputItemDialog.newInstance {
                    mListItem.add(it)
                    mAdapter?.setList(mListItem)
                    mAdapter?.notifyItemInserted(mListItem.size - 1)
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