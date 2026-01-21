package com.example.jankotlin.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    private val _count = MutableLiveData<Int>()

    val count : LiveData<Int> = _count

    init {
        _count.value = 0
    }

    fun add()
    {
        _count.value = _count.value?.plus(1)
    }
}