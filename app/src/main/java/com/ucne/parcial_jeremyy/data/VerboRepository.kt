package com.ucne.parcial_jeremyy.data

import javax.inject.Inject

class VerboRepository @Inject constructor(
    val api: VerboApi
) {
    suspend fun GetLista() = api.getLista()
}