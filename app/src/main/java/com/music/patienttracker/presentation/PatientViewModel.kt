package com.music.patienttracker.presentation

import androidx.lifecycle.ViewModel
import com.music.patienttracker.domain.repository.PatientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PatientViewModel @Inject constructor(
    private val patientRepository:PatientRepository
):ViewModel() {

}