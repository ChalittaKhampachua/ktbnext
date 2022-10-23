package com.ktb.ktbnext.extension

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

fun<T> MediatorLiveData<T>.addSources(vararg source: LiveData<*>, callback: () -> Unit)  {
    source.forEach { source -> addSource(source) { callback() } }
}