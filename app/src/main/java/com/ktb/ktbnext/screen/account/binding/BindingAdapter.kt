package com.ktb.ktbnext.screen.account.binding

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter("isVisible")
fun bindingIsVisible(view: View, isVisible: Boolean){
    view.isVisible = isVisible
}