package com.music.patienttracker.presentation.PatientList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.music.patienttracker.R
import com.music.patienttracker.model.Patient
import com.music.patienttracker.presentation.components.DeleteDialog
import com.music.patienttracker.presentation.components.PatientItem


@Composable
fun PatientListScreen(){

    // state for accessing first item of lazy column
    val listState = rememberLazyListState()
    val isFABExpanded by remember{ derivedStateOf { listState.firstVisibleItemIndex == 0 } }


    var isDeleteDialogOpen by rememberSaveable { mutableStateOf(false) }


    val patientList = listOf(

        Patient(
            "Akon",
            "23",
            1,
            27727,
            "Dr Oberoy",
            "Eat Healty",
            0
        ),
        Patient(
            "kon",
            "23",
            1,
            27727,
            "Dr Oberoy",
            "Eat Healty",
            0
        ),

        Patient(
            "Akon",
            "23",
            1,
            27727,
            "Dr Oberoy",
            "Eat Healty",
            0
        ),
        Patient(
            "Akon",
            "23",
            1,
            27727,
            "Dr Oberoy",
            "Eat Healty",
            0
        ),
        Patient(
            "Akon",
            "23",
            1,
            27727,
            "Dr Oberoy",
            "Eat Healty",
            0
        ),
        Patient(
            "Akon",
            "23",
            1,
            27727,
            "Dr Oberoy",
            "Eat Healty",
            0
        ),
        Patient(
            "Akon",
            "23",
            1,
            27727,
            "Dr Oberoy",
            "Eat Healty",
            0
        ),
        Patient(
            "Akon",
            "23",
            1,
            27727,
            "Dr Oberoy",
            "Eat Healty",
            0
        ),
        Patient(
            "Akon",
            "23",
            1,
            27727,
            "Dr Oberoy",
            "Eat Healty",
            0
        ),
        Patient(
            "Akon",
            "23",
            1,
            27727,
            "Dr Oberoy",
            "Eat Healty",
            0
        ),
        Patient(
            "Akon",
            "23",
            1,
            27727,
            "Dr Oberoy",
            "Eat Healty",
            0
        ),
        Patient(
            "Akon",
            "23",
            1,
            27727,
            "Dr Oberoy",
            "Eat Healty",
            0
        ),
        Patient(
            "Akon",
            "23",
            1,
            27727,
            "Dr Oberoy",
            "Eat Healty",
            0
        ),
        Patient(
            "Akon",
            "23",
            1,
            27727,
            "Dr Oberoy",
            "Eat Healty",
            0
        ),
        Patient(
            "Akon",
            "23",
            1,
            27727,
            "Dr Oberoy",
            "Eat Healty",
            0
        ),
        Patient(
            "Akon",
            "23",
            1,
            27727,
            "Dr Oberoy",
            "Eat Healty",
            0
        )


        )


    DeleteDialog(
        isOpen = isDeleteDialogOpen,
        title = "Delete Patient Detail?",
        bodyText ="Are you sure, you want to delete this Patient Detail? "+
                "This action can not be undone",
        onDismissRequest = {isDeleteDialogOpen=false},
        onConfirmButtonClick = {isDeleteDialogOpen=false}
    )

    Scaffold(
        topBar = {
            TopAppBarWithIcon(
                onBackButtonClick = {}
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "Add Patient") },
                icon = { Icon(imageVector = Icons.Default.Add , contentDescription = "Add") },
                onClick = { /*TODO*/ },
                expanded = isFABExpanded
            )
        }
    ) { paddingValues->

        LazyColumn(
            state=listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        )
        {
            items(patientList){ patient ->
                PatientItem(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                    patient = patient,
                    onItemClicked = {},
                    isDeletePatient= {isDeleteDialogOpen = true}
                )
            }
        }

        if (patientList.isEmpty()){
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Add Patient Details\nby pressing add button",
                    style=MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Center
                )
            }
        }

    }

}


@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopAppBarWithIcon(
    onBackButtonClick:() -> Unit
) {
    CenterAlignedTopAppBar(

        navigationIcon = {
                   IconButton(onClick = onBackButtonClick) {
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
                text = "Patient List",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    })
}


