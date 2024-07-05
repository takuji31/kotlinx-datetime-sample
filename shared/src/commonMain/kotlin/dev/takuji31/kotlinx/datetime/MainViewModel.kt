package dev.takuji31.kotlinx.datetime

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class MainViewModel : ViewModel() {
    private fun now() = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    val nowInSystem: StateFlow<LocalDateTime> = flow {
        while (true) {
            kotlinx.coroutines.delay(100L)
            emit(now())
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), now())

    private fun nowInUTC() = Clock.System.now().toLocalDateTime(TimeZone.UTC)
    val nowInUTC: StateFlow<LocalDateTime> = flow {
        while (true) {
            kotlinx.coroutines.delay(100L)
            emit(nowInUTC())
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), nowInUTC())

}