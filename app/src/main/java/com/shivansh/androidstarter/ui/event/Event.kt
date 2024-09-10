package com.shivansh.androidstarter.ui.event

import com.shivansh.androidstarter.ui.screen.Route

sealed interface Event {
    data class NavigateTo(val destination: Route, val addToBackStack: Boolean = true) : Event
    data object NavigateUp : Event
    data class ShowToast(val message: String) : Event
}