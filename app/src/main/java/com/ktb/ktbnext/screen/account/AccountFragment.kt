package com.ktb.ktbnext.screen.account

import com.ktb.ktbnext.R
import com.ktb.ktbnext.base.BaseFragment
import com.ktb.ktbnext.databinding.FragmentAccountBinding
import com.ktb.ktbnext.screen.account.controller.AccountController
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class AccountFragment : BaseFragment<FragmentAccountBinding, AccountViewModel>(),
    AccountController.OnClickListener {
    private val accountController: AccountController by inject()

    override val viewModel: AccountViewModel by viewModel()

    override fun getLayoutId() = R.layout.fragment_account

    override fun setupView() {
        initEpoxy()
        initData()
    }

    override fun setObserve() {
        with(viewModel)  {
            accountUIDataSource.observe(viewLifecycleOwner) {
                it?.let(accountController::setData)
            }
        }
    }

    private fun initEpoxy() {
        accountController.setOnClickListener(this)
        binding.epoxyRecyclerView.apply {
            setController(accountController)
        }
    }

    private fun initData() {
        with(viewModel) {
            fetchAccountData()
        }
    }

    override fun onClickMenuOption() {
        // this click menu option on account header screen
    }
}