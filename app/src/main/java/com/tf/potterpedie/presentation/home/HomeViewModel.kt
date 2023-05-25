package com.tf.potterpedie.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tf.potterpedie.domain.characters.ICharactersRepository
import com.tf.potterpedie.domain.characters.model.HPCharacter
import com.tf.potterpedie.domain.core.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val charactersRepository: ICharactersRepository
) : ViewModel() {

    private val _allCharacters = MutableStateFlow<DataState<List<HPCharacter>>>(DataState.Loading())
    val allCharacters = _allCharacters.asStateFlow()

    private fun getAllCharacters() = viewModelScope.launch {
        charactersRepository.getAllCharacters().collect { result ->
            Timber.d(result.toString())
            _allCharacters.value = result
        }
    }

    init {
        getAllCharacters()
    }
}
