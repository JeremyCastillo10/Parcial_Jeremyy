package com.ucne.parcial_jeremyy.ui.VerbosList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucne.parcial_jeremyy.data.VerboRepository
import com.ucne.parcial_jeremyy.data.dto.remote.VerboDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


data class VerboListUiState(
    val verbo: List<VerboDto> = emptyList(),
    val texto: String = "Meeting"
)

@HiltViewModel
class VerbosListViewModel @Inject constructor(
    val repository: VerboRepository

) : ViewModel() {

    private val _uiState = MutableStateFlow(VerboListUiState())
    val uiState: StateFlow<VerboListUiState> = _uiState.asStateFlow()


    init {
        viewModelScope.launch {
            _uiState.getAndUpdate {
                it.copy(verbo = repository.GetLista().sortedBy { it.verbo })
            }
        }

    }
}