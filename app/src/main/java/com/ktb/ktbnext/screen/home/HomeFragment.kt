package com.ktb.ktbnext.screen.home

import com.ktb.ktbnext.R
import com.ktb.ktbnext.base.BaseFragment
import com.ktb.ktbnext.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val viewModel: HomeViewModel by viewModel()

    override fun getLayoutId() = R.layout.fragment_home

    override fun setupView() {
    }

    override fun setObserve() {
    }

}