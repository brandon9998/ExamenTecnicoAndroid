package com.example.examentecnico.network.response

import com.example.examentecnico.models.PeliculaModel
import com.google.gson.annotations.SerializedName

data class PeliculasResponse(
    @SerializedName("results")
    var resultados: List<PeliculaModel>
)
