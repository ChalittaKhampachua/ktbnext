package com.ktb.ktbnext.screen.account.controller

import com.airbnb.epoxy.TypedEpoxyController
import com.ktb.ktbnext.accountHeader
import com.ktb.ktbnext.screen.account.model.AccountUI

class AccountController : TypedEpoxyController<AccountUI>() {

    private var listener: OnClickListener? = null

    interface OnClickListener {
        fun onClickMenuOption()
    }

    fun setOnClickListener(listener: OnClickListener) {
        this.listener = listener
    }

    override fun buildModels(data: AccountUI?) {
        bindAccountHeader()
        bindBookBank()
    }

    private fun bindAccountHeader() {
        accountHeader {
            id("account_header")
            onClickMenuOption { _ ->
                this@AccountController.listener?.onClickMenuOption()
            }
        }
    }

    private fun bindBookBank() {

    }
}