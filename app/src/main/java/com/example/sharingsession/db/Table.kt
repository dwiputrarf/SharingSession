package com.example.sharingsession.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "karyawan")
data class Pekerjaan(
    @PrimaryKey
    @ColumnInfo(name = "namaPekerjaan") val namaPekerjaan: String
)
