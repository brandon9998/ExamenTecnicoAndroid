package com.example.examentecnico.views

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DaoUsuario {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(characterEntity: Usuario)

    @Query("SELECT * FROM Usuario")
    suspend fun getCharacters(): List<Usuario>
    }