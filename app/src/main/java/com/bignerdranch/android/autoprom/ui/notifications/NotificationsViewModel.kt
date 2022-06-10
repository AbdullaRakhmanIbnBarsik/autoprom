package com.bignerdranch.android.autoprom.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Тут будут ваши уведомления"
    }
    val text: LiveData<String> = _text
}