package com.ktb.ktbnext.screen.account.controller

import android.view.View
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.group
import com.ktb.ktbnext.*
import com.ktb.ktbnext.domain.model.account.BookBank
import com.ktb.ktbnext.domain.model.account.Transaction
import com.ktb.ktbnext.expoxy.carousel
import com.ktb.ktbnext.expoxy.withModelsFrom
import com.ktb.ktbnext.screen.account.controller.listener.OnClickAccountControllerListener
import com.ktb.ktbnext.screen.account.controller.listener.OnClickMenuWidgetListener
import com.ktb.ktbnext.screen.account.model.AccountUI

class AccountController : TypedEpoxyController<AccountUI>() {

    private var listener: OnClickAccountControllerListener? = null

    fun setOnClickListener(listener: OnClickAccountControllerListener) {
        this.listener = listener
    }

    override fun buildModels(data: AccountUI?) {
        bindAccountHeader()
        bindBookBank(data?.bookBankList)
        bindAccountMenu()
        bindTransactionHeader()
        bindTransaction(data?.transactionList)
    }

    private fun bindAccountHeader() {
        accountHeader {
            id("account_header")
            onClickMenuOption { _ ->
                this@AccountController.listener?.onClickMenuOption()
            }
        }
    }

    private fun bindBookBank(bookBankList: List<BookBank>?) {
        bookBankList?.let { list ->
            carousel {
                id("carousel_book_bank")
                numViewsToShowOnScreen(1.03f)
                padding(Carousel.Padding(40, 0, 40, 40, 24))
                withModelsFrom(list) {
                    AccountBookBankBindingModel_().apply {
                        id("account_book_bank_${it.id}")
                        bookBank(it)
                    }
                }
            }
        }
    }

    private fun bindAccountMenu() {
        accountMenu {
            id("account_menu")
            listenerOnClickMenu(object : OnClickMenuWidgetListener {
                override val listenerTransfer: View.OnClickListener
                    get() = View.OnClickListener {
                        this@AccountController.listener?.onClickMenuTransfer()
                    }
                override val listenerTopUp: View.OnClickListener
                    get() = View.OnClickListener {
                        this@AccountController.listener?.onClickMenuTopUp()
                    }
                override val listenerPayBills: View.OnClickListener
                    get() = View.OnClickListener {
                        this@AccountController.listener?.onClickMenuPayBills()
                    }
                override val listenerMore: View.OnClickListener
                    get() = View.OnClickListener {
                        this@AccountController.listener?.onClickMenuMore()
                    }
            })
        }
    }

    private fun bindTransactionHeader() {
        transactionHeader {
            id("transaction_header")
        }
    }

    private fun bindTransaction(transactionList: List<Transaction>?) {
        group {
            id("transaction_group")
            layout(R.layout.view_transaction_group)
            group {
                id("transaction_list")
                layout(R.layout.view_transaction_list_group)
                transactionList?.forEach {
                    transactionList {
                        id("transaction_list_${it.id}")
                        transaction(it)
                        isExpanded(it.isExpanded)
                        onClickExpanded { _ ->
                            this@AccountController.listener?.onClickTransactionExpanded(it.id)
                        }
                    }
                }
            }

            requestStatement {
                id("request_statement")
                onClickRequestStatement { _ ->
                    this@AccountController.listener?.onClickRequestStatement()
                }
            }
        }
    }
}