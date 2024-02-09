package com.music.patienttracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.music.patienttracker.presentation.NavGraph
import com.music.patienttracker.presentation.NavGraphs
import com.music.patienttracker.presentation.theme.PatientTrackerTheme
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PatientTrackerTheme {
               // PatientDetails()
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}
