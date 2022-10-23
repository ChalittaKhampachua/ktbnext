package com.ktb.ktbnext.screen.account.controller.listener

import android.view.View

interface OnClickMenuWidgetListener {
    val listenerTransfer: View.OnClickListener
    val listenerTopUp : View.OnClickListener
    val listenerPayBills : View.OnClickListener
    val listenerMore : View.OnClickListener
}