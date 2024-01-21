package com.example.examentecnico.views

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity
class Usuario{
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id: String
    @SerializedName("original_title")
    var nombrePelicula: String
    @SerializedName("overview")
    var descripcion: String
    @SerializedName("poster_path")
    var poster: String
    @SerializedName("release_date")
    var fechaLanzamiento: String
    @SerializedName("vote_average")
    var votoPromedio: String
    @SerializedName("vote_count")
    var totalVotos: String

    constructor(id: String, nombrePelicula: List<Any>, descripcion: String, poster: String, fechaLanzamiento: String, votoPromedio: String, totalVotos: String){
        this.id = id
        this.nombrePelicula= nombrePelicula
        this.descripcion = descripcion
        this.poster = poster
        this.fechaLanzamiento = fechaLanzamiento
        this.votoPromedio = votoPromedio
        this.totalVotos = totalVotos
        }
}
