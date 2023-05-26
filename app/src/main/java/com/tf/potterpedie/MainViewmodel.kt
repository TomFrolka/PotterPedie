package com.tf.potterpedie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {
    private val _splashVisible = MutableStateFlow(true)
    val splashVisible = _splashVisible.asStateFlow()

    init {
        viewModelScope.launch {
            delay(2000)
            _splashVisible.value = false
        }
    }
}