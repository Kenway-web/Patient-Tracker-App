package com.music.patienttracker.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Patient(
    val name:String,
    val age:String,
    val gender:Int,
    val dueDate:Long,
    val doctorAssigned:String,
    val prescription:String,
    @PrimaryKey(autoGenerate = true)
    val patientId:Int?=null
)
