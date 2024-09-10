package com.lee.bookdemo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lee.bookdemo.R
import com.lee.bookdemo.model.Booking
import java.time.format.DateTimeFormatter


@Composable
fun BookingDetails( booking: Booking) {


    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        // set the massage name
        BookingDetailRow(
            iconRes = R.drawable.ic_massage,
            iconBackgroundRes = R.drawable.ic_background,
            primaryText = booking.massageName,
            secondaryText = "${booking.duration} mins"
        )

        Spacer(modifier = Modifier.height(16.dp))

        // set the date
        BookingDetailRow(
            iconRes = R.drawable.ic_calendar,
            iconBackgroundRes = R.drawable.ic_background,
            primaryText = booking.dateTime.format(DateTimeFormatter.ofPattern("MMM dd hh:mm a")),
            secondaryText = booking.weekday
        )

        Spacer(modifier = Modifier.height(16.dp))

        // set the location name
        BookingDetailRow(
            iconRes = R.drawable.ic_location,
            iconBackgroundRes = R.drawable.ic_background,
            primaryText = booking.locationName,
            secondaryText = booking.locationAddress
        )
    }
}

@Composable
fun BookingDetailRow(
    iconRes: Int,
    iconBackgroundRes: Int? = null,
    primaryText: String,
    secondaryText: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // icon background
        Box(
            modifier = Modifier
                .size(40.dp),
            contentAlignment = Alignment.Center
        ) {
            if (iconBackgroundRes != null) {
                // set background
                Image(
                    painter = painterResource(id = iconBackgroundRes),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Color.Unspecified
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // text info
        Column {
            Text(
                text = primaryText,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = secondaryText,
                fontSize = 14.sp,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}