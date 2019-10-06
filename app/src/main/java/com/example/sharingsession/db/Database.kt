package com.example.sharingsession.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Pekerjaan::class), version = 1)
abstract class PekerjaanDatabase: RoomDatabase(){
    abstract fun pekerjaanDao(): PekerjaanDao
    companion object{
        private var INSTANCE: PekerjaanDatabase? = null
        fun getDatabase(context: Context): PekerjaanDatabase? {
            if (INSTANCE == null){
                synchronized(PekerjaanDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        PekerjaanDatabase::class.java, "pekerjaan.db"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}