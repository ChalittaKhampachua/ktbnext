package com.ktb.ktbnext.screen.scan

import com.ktb.ktbnext.R
import com.ktb.ktbnext.base.BaseFragment
import com.ktb.ktbnext.databinding.FragmentScanBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScanFragment : BaseFragment<FragmentScanBinding, ScanViewModel>() {
    override val viewModel: ScanViewModel by viewModel()

    override fun getLayoutId() = R.layout.fragment_scan

    override fun setupView() {
    }

    override fun setObserve() {
    }
}