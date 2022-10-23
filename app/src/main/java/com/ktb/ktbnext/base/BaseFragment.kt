package com.ktb.ktbnext.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<DB: ViewDataBinding, VM: ViewModel> : Fragment() {
    protected abstract val viewModel: VM
    protected lateinit var binding: DB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.lifecycleOwner = this

        setupView()
        setObserve()

        return binding.root
    }

    abstract fun getLayoutId(): Int
    abstract fun setupView()
    abstract fun setObserve()

}