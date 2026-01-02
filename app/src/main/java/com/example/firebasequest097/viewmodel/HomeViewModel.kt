package com.example.firebasequest097.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.firebasequest097.modeldata.Siswa
import com.example.firebasequest097.repositori.RepositorySiswa


sealed interface StatusUiSiswa {
    data class Success(val siswa: List<Siswa>) : StatusUiSiswa
    object Error : StatusUiSiswa
    object Loading : StatusUiSiswa
}

class HomeViewModel(private val repositorySiswa: RepositorySiswa) : ViewModel()  {
    var statusUiSiswa: StatusUiSiswa by mutableStateOf(StatusUiSiswa.Loading)
        private set

    init {
        loadSiswa()
    }
}