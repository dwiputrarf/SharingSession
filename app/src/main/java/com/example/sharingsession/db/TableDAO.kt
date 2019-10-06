package com.example.sharingsession.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PekerjaanDao {
    @Insert
    fun insert(pekerjaan: Pekerjaan)

    @Query("DELETE FROM KARYAWAN")
    fun deleteAll()

    @Query("SELECT * FROM KARYAWAN ORDER BY namaPekerjaan ASC")
    fun getAllPekerjaan(): List<Pekerjaan>
}