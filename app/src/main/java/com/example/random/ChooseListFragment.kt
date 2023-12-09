package com.example.random

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.random.databinding.FragmentChooseListBinding

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