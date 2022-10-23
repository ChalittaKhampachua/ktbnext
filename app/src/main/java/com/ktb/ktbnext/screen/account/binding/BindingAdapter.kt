package com.ktb.ktbnext.screen.account.binding

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter("isVisible")
fun bindIsVisible(view: View, isVisible: Boolean) {
    view.isVisible = isVisible
}

@BindingAdapter("textAmount")
fun bindTextAmount(view: TextView, textAmount: String?) {
    view.text = textAmount
    if (textAmount?.startsWith("-") == true) {
        view.setTextColor(ContextCompat.getColor(view.context, android.R.color.holo_red_dark))
        view.tag = "red"
    } else if (textAmount?.startsWith("+") == true) {
        view.setTextColor(ContextCompat.getColor(view.context, android.R.color.holo_green_light))
        view.tag = "green"
    } else {
        view.setTextColor(ContextCompat.getColor(view.context, android.R.color.darker_gray))
        view.tag = "gray"
    }
}