package com.example.examentecnico.views

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Usuario::class], version = 1)
abstract class DBPruebas: RoomDatabase(){
    abstract val dao :DaoUsuario
}

