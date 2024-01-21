package com.example.examentecnico.network

import com.example.examentecnico.mapper.toEntity
import com.example.examentecnico.views.DaoUsuario
import com.example.examentecnico.views.ExamenCharacter

class ExamenRepository(
    private val api: RetrofitClient,
    private val dao:DaoUsuario
){
    suspend fun getCharacters(): List<Unit> {
        var localCharacters = dao.getCharacters()

        if(localCharacters.isEmpty()){
            val remoteCharacters = getCharactersRemote()
            remoteCharacters.forEach{
                dao.insertCharacter(it.toEntity)
            }
            localCharacters = dao.getCharacters()
        }
        return localCharacters.map {it.toDomain}
    }

    private suspend fun getCharactersRemote(): List<ExamenCharacter>{
        return try {
            val characters = api.getCharacters()
            characters.data.mapNull{it.toDomain}
        } catch (e: Exception){
            emptyList()
        }
    }

}