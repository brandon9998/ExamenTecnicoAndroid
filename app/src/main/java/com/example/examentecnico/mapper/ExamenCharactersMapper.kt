package com.example.examentecnico.mapper

import com.example.examentecnico.network.dto.CharacterDataDto
import com.example.examentecnico.views.ExamenCharacter
import com.example.examentecnico.views.Usuario

fun CharacterDataDto.toDomain(): ExamenCharacter?{
    val peliculas =
        this.nombrePelicula.firstOrNull() ?: this.descripcion.firstOrNull() ?: return null
    return ExamenCharacter(
        nombrePelicula = this.nombrePelicula,
        descripcion = descripcion
    )

}

fun ExamenCharacter.toEntity(): Usuario{
    return Usuario(
        nombrePelicula = this.nombrePelicula,
        descripcion = this.descripcion
    )
}

fun ExamenCharacter.toDomain(): Usuario{
    return Usuario(
        nombrePelicula = this.nombrePelicula,
        descripcion = this.descripcion
    )
    }