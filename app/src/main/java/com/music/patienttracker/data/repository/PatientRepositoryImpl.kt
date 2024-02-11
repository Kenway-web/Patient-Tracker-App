package com.music.patienttracker.data.repository

import com.music.patienttracker.data.local.PatientDao
import com.music.patienttracker.domain.model.Patient
import com.music.patienttracker.domain.repository.PatientRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PatientRepositoryImpl @Inject constructor (
    private val patientDao: PatientDao
):PatientRepository {
    override suspend fun insertPatient(patient: Patient) {
       patientDao.addOrUpdatePatient(patient)
    }

    override suspend fun deletePatient(patient: Patient) {
        TODO("Not yet implemented")
    }

    override suspend fun getPatientById(patientId: Int) {
        TODO("Not yet implemented")
    }

    override fun getAllPatient(): Flow<List<Patient>> {
        TODO("Not yet implemented")
    }
}