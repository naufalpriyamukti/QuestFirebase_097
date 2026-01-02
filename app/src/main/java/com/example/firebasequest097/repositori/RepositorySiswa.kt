package com.example.firebasequest097.repositori

interface RepositorySiswa {
    suspend fun getDataSiswa(): List<Siswa>
    suspend fun postDataSiswa(siswa: Siswa)
    suspend fun getSiswaById(id: Long): Siswa
    suspend fun updateSiswa(siswa: Siswa)
    suspend fun deleteSiswa(siswa: Siswa)
}