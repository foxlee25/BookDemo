package com.lee.bookdemo.model

import java.time.LocalDateTime

data class Booking(
    val massageName: String,
    val duration: Int, 
    val dateTime: LocalDateTime,
    val weekday: String ,
    val locationName: String,
    val locationAddress: String
)
