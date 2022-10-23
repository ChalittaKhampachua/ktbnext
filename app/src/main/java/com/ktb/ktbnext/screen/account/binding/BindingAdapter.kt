package com.ktb.ktbnext.screen.account.binding

import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter("isVisible")
fun bindingIsVisible(view: View, isVisible: Boolean) {
    view.isVisible = isVisible
}

@BindingAdapter("textAmount")
fun bindingTextAmount(view: TextView, textAmount: String?) {
    view.text = textAmount
    if (textAmount?.startsWith("-") == true) {
        view.setTextColor(view.context.resources.getColor(android.R.color.holo_red_dark, null))
    } else if (textAmount?.startsWith("+") == true) {
        view.setTextColor(view.context.resources.getColor(android.R.color.holo_green_light, null))
    } else {
        view.setTextColor(view.context.resources.getColor(android.R.color.darker_gray, null))
    }
}