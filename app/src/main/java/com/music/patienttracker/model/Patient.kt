package com.music.patienttracker.model

data class Patient(
    val name:String,
    val age:String,
    val gender:Int,
    val dueDate:Long,
    val doctorAssigned:String,
    val prescription:String,
    val patientId:Int?=null
)
