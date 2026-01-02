package com.example.firebasequest097.viewmodel

import com.example.firebasequest097.modeldata.Siswa


sealed interface StatusUiSiswa {
    data class Success(val siswa: List<Siswa>) : StatusUiSiswa
    object Error : StatusUiSiswa
    object Loading : StatusUiSiswa
}

class HomeViewModel {
}