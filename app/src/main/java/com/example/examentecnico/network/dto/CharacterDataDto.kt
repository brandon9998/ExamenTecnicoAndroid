package com.example.examentecnico.network.dto

import com.squareup.moshi.Json
data class CharacterDataDto(
    @Json(name = "id")
    val id: List<Any>,
    @Json(name = "original_title")
    val nombrePelicula: List<Any>,
    @Json(name = "overview")
    val descripcion: List<String>,
    @Json(name = "poster_path")
    val poster: Int,
    @Json(name = "release_date")
    val fechaLanzamiento: String,
    @Json(name = "vote_average")
    val votoPromedio: String,
    @Json(name = "vote_count")
    val totalVotos: List<String>,
)
