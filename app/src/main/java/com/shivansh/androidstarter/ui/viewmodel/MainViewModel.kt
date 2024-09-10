package com.shivansh.androidstarter.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shivansh.androidstarter.ui.event.Event
import com.shivansh.androidstarter.ui.event.UiEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val eventChannel = Channel<Event>()
    val events = eventChannel.receiveAsFlow()

    fun onUiEvent(event: UiEvent) {
        when(event) {
            else -> {}
        }
    }

    private fun sendEvent(event: Event) {
        eventChannel.trySend(event)
    }
}