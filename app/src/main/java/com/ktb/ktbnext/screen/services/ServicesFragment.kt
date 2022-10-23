package com.ktb.ktbnext.screen.services

import com.ktb.ktbnext.R
import com.ktb.ktbnext.base.BaseFragment
import com.ktb.ktbnext.databinding.FragmentServicesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ServicesFragment : BaseFragment<FragmentServicesBinding, ServicesViewModel>() {
    override val viewModel: ServicesViewModel by viewModel()

    override fun getLayoutId() = R.layout.fragment_services

    override fun setupView() {
    }

    override fun setObserve() {
    }
}