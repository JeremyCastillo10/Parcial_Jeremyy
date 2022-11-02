package com.ucne.parcial_jeremyy.data

import com.ucne.parcial_jeremyy.data.dto.remote.VerboDto
import retrofit2.http.GET

interface VerboApi {
    @GET("verbos")
    suspend fun getLista(): List<VerboDto>

}