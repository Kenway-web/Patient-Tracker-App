package com.music.patienttracker.presentation.components

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientDatePicker(
    state: DatePickerState,
    isOpen:Boolean,
    confirmationButtonText:String="Ok",
    dismissButtonText:String="Cancel",
    onDismissRequest:()->Unit,
    onConfirmationButtonClicked:() -> Unit

    ) {
   if (isOpen){
       DatePickerDialog(
           onDismissRequest = onDismissRequest,
           confirmButton = {
               TextButton(onClick = onConfirmationButtonClicked) {
                   Text(text = confirmationButtonText)
               }
           },
           dismissButton = {
               TextButton(onClick = onDismissRequest) {
                   Text(text = dismissButtonText)
               }
           },
           content = {
               DatePicker(
                   state = state,
                   dateValidator = { timestampt ->

                       val selectedDate = Instant.ofEpochMilli(timestampt)
                           .atZone(ZoneId.systemDefault())
                           .toLocalDate()

                       val currentDate = LocalDate.now(ZoneId.systemDefault())
                       selectedDate <= currentDate
                   }
               )
           }
       )
   }
}