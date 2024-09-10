package com.lee.bookdemo.model

import java.time.LocalDateTime

data class Booking(
    val massageName: String,
    val duration: Int,  // 使用 Int 表示持续时间（分钟）
    val dateTime: LocalDateTime,
    val weekday: String ,
    val locationName: String,
    val locationAddress: String
)
