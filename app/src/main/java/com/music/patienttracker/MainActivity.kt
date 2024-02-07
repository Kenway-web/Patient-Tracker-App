package com.music.patienttracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.music.patienttracker.presentation.PatientDetails.PatientDetails
import com.music.patienttracker.presentation.PatientList.PatientListScreen
import com.music.patienttracker.presentation.theme.PatientTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PatientTrackerTheme {
               // PatientDetails()
                PatientListScreen()
            }
        }
    }
}
