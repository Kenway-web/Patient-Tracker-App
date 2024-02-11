package com.music.patienttracker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.music.patienttracker.domain.model.Patient


@Database(
    entities = [Patient::class],
    version = 1
)

abstract class AppDatabase :RoomDatabase(){
    abstract  fun patientDao():PatientDao
}