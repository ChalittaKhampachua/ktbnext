package com.ktb.ktbnext.screen.account.controller.listener

interface OnClickAccountControllerListener {
    fun onClickMenuOption()
    fun onClickMenuTransfer()
    fun onClickMenuTopUp()
    fun onClickMenuPayBills()
    fun onClickMenuMore()
    fun onClickTransactionExpanded(id: Int)
    fun onClickRequestStatement()
}