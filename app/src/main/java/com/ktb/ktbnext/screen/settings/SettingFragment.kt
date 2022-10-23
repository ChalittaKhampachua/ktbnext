package com.ktb.ktbnext.screen.settings


import com.ktb.ktbnext.R
import com.ktb.ktbnext.base.BaseFragment
import com.ktb.ktbnext.databinding.FragmentSettingBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingFragment : BaseFragment<FragmentSettingBinding, SettingsViewModel>() {
    override val viewModel: SettingsViewModel by viewModel()

    override fun getLayoutId() = R.layout.fragment_setting

    override fun setupView() {
    }

    override fun setObserve() {
    }
}