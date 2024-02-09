package com.music.patienttracker.presentation.PatientDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.music.patienttracker.R
import com.music.patienttracker.presentation.components.PatientDatePicker
import com.music.patienttracker.util.changeMillisToDateString
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import java.time.Instant

data class PatientDetailsNavArgs(
    val patientId:Int?
)


@Composable
@Destination(navArgsDelegate = PatientDetailsNavArgs::class)
fun  PatientDetailsScreenRoute(
    navigator: DestinationsNavigator
){
    PatientDetails(
        onBackItemClicked = {
            navigator.navigateUp()
        }
    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PatientDetails(
    onBackItemClicked:() ->Unit
) {


    var isDatePickerDialogOpen by rememberSaveable { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = Instant.now().toEpochMilli()  // to select todays date as current date
    )

    PatientDatePicker(
        state = datePickerState,
        isOpen = isDatePickerDialogOpen,
        onDismissRequest = { isDatePickerDialogOpen=false },
        onConfirmationButtonClicked = {
            isDatePickerDialogOpen = false
        }
    )

    Scaffold(
        topBar = { TopAppBarWithIcon(
            onBackItemClicked = onBackItemClicked
        ) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 12.dp)
        )
        {
            OutlinedTextField(
                modifier=Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                label = { Text(text = "Patient Name",
                    style = MaterialTheme.typography.bodyLarge
                )},
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    modifier=Modifier.weight(1f),
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Age",
                        style = MaterialTheme.typography.bodyLarge
                    )},
                    singleLine = true,
                )
                Spacer(modifier = Modifier.width(10.dp))

                GenderRadioButtonExample()
            }

            Spacer(modifier = Modifier.height(10.dp))

          Text(
              text = "Date",
              style = MaterialTheme.typography.bodySmall
          )

           Row(
               modifier=Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceBetween,
               verticalAlignment = Alignment.CenterVertically
           ) {
                Text(
                    text = datePickerState.selectedDateMillis.changeMillisToDateString(),
                    style = MaterialTheme.typography.bodyLarge
                )
               IconButton(onClick = { isDatePickerDialogOpen = true}) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = null
                    )
               }
           }

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                modifier=Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                label = { Text(text = " Assigned Doctor's Name",
                    style = MaterialTheme.typography.bodyLarge
                )},
                singleLine = true,
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                value = "",
                onValueChange = {

                },
                label = { Text(text = "Prescription : ",
                    style = MaterialTheme.typography.bodyLarge
                )},
                singleLine = false,

            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { /*TODO*/ }
            ) {
                  Text(text = "Save")
            }

        }
    }
}


@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopAppBarWithIcon(
    onBackItemClicked: () -> Unit
) {

    CenterAlignedTopAppBar(
        navigationIcon = {
            IconButton(onClick = onBackItemClicked) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Navigation Back"
                )
            }
        },
        title = {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.plus_sign),
                contentDescription = null,
                tint = Color.Red, // Set the color to red
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(10.dp)) // Adjust the spacing as needed
            Text(
                text = "Patient Detail",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    })
}

@Preview
@Composable
fun PatientDetailsPreview() {
    // Call your composable function with sample data for preview
    PatientDetails(onBackItemClicked = {})
}

@Composable
fun GenderRadioButtonExample() {
    val selectedOption = remember { mutableStateOf("Option1") }

        RadioButton(
            selected = selectedOption.value == "Option1",
            onClick = { selectedOption.value = "Option1" }
        )
        Text("Male")

        RadioButton(
            selected = selectedOption.value == "Option2",
            onClick = { selectedOption.value = "Option2" }
        )
        Text("Female")

}