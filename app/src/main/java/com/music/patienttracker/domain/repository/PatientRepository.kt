package com.music.patienttracker.domain.repository

import com.music.patienttracker.domain.model.Patient
import kotlinx.coroutines.flow.Flow

interface PatientRepository {

    suspend fun insertPatient(patient: Patient)

    suspend fun deletePatient(patient: Patient)

    suspend fun getPatientById(patientId:Int)

     fun getAllPatient():Flow<List<Patient>>

}