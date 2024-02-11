package com.music.patienttracker.di

import android.app.Application
import androidx.room.Room
import com.music.patienttracker.data.local.AppDatabase
import com.music.patienttracker.data.local.PatientDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides  // DH will know that they are responsible for providing object
    @Singleton
    fun provideDatabase(
        application: Application
    ): AppDatabase{
        return Room
            .databaseBuilder(
                application,
                AppDatabase::class.java,
                "patient.db"
            )
            .build()
    }


    @Provides
    @Singleton
    fun patientDao(database: AppDatabase):PatientDao{
            return database.patientDao()
    }
}