package com.music.patienttracker.di

import com.music.patienttracker.data.repository.PatientRepositoryImpl
import com.music.patienttracker.domain.repository.PatientRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindPatientRepository(
        impl:PatientRepositoryImpl
    ):PatientRepository


}