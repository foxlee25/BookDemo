package com.lee.bookdemo.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.lee.bookdemo.model.Booking
import com.lee.bookdemo.ui.components.BookingDetails
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun BookingDetailsDemoScreen() {

    val context = LocalContext.current

    // DateTimeFormatter for formatting the date and time
    val formatter = DateTimeFormatter.ofPattern("MMMM dd 'at' hh:mm a")

    var booking by remember {
        mutableStateOf(
            Booking(
                massageName = "Total Back & Glutes Renewal",
                duration = 60,  // 60 min
                dateTime = LocalDateTime.now(),  // use local time
                weekday = "Wednesday",
                locationName = "Majestic Vista Hotel",
                locationAddress = "350 5th Ave, New York,NY 10118"
            )
        )

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Display BookingDetails
        BookingDetails(booking = booking)

        Spacer(modifier = Modifier.height(16.dp))

        //  BasicTextField for each property of Booking
        BasicTextField(
            value = booking.massageName,
            onValueChange = { booking = booking.copy(massageName = it) },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.padding(8.dp)
                ) {
                    innerTextField()
                }
            }
        )

        BasicTextField(
            value = booking.duration.toString(),
            onValueChange = { booking = booking.copy(duration = it.toIntOrNull() ?: 0) },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.padding(8.dp)
                ) {
                    innerTextField()
                }
            }
        )

        BasicTextField(
            value = booking.dateTime.format(formatter),  // make LocalDateTime to String type for display
            onValueChange = { newValue ->
                // input string to LocalDateTime
                val parsedDateTime = try {
                    LocalDateTime.parse(newValue, formatter)
                } catch (e: Exception) {
                    null  // if failed handle it
                }

                // if work update booking
                if (parsedDateTime != null) {
                    booking = booking.copy(dateTime = parsedDateTime)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.padding(8.dp)
                ) {
                    innerTextField()
                }
            }
        )

        BasicTextField(
            value = booking.locationName,
            onValueChange = { booking = booking.copy(locationName = it) },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.padding(8.dp)
                ) {
                    innerTextField()
                }
            }
        )

        BasicTextField(
            value = booking.locationAddress,
            onValueChange = { booking = booking.copy(locationAddress = it) },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.padding(8.dp)
                ) {
                    innerTextField()
                }
            }
        )

        Button(onClick = {
            // submit button if needed
            Toast.makeText(context, "Booked !", Toast.LENGTH_SHORT).show()
        }) {
            Text("Submit")
        }
    }
}
