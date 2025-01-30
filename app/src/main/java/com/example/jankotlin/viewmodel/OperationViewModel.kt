package com.example.jankotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OperationViewModel : ViewModel() {

        private val _result = MutableLiveData<String>()
        val result: LiveData<String> = _result


        suspend fun performOperation(a: Int, b: Int)
        {
            _result.value = (a+b).toString()

        }
}