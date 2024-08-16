package com.priyanshu.ultimatedrivers.ui.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.Saver
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.priyanshu.ultimatedrivers.domain.models.InstructorStudent
import com.priyanshu.ultimatedrivers.ui.theme.blue
import com.priyanshu.ultimatedrivers.ui.theme.gray500
import com.priyanshu.ultimatedrivers.ui.theme.grayShade2
import com.priyanshu.ultimatedrivers.ui.theme.lightGray
import com.priyanshu.ultimatedrivers.ui.theme.white

@Composable
fun ItemInstructorStudentItem(
    instructorStudent: InstructorStudent
) {

    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(gray500)
            .padding(all = 16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .size(50.dp)
                        .background(
                            lightGray
                        ), contentAlignment = Alignment.Center
                ) {
                    Text(text = "1", style = MaterialTheme.typography.bodyLarge)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = instructorStudent.StudentName,
                    style = MaterialTheme.typography.bodyLarge
                )

                Row {
                    Text(
                        text = instructorStudent.StudentPaymentType,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .size(50.dp)
                            .background(
                                blue.copy(alpha = 0.4f)
                            )
                            .border(width = 1.dp, color = blue),
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = "more info icon",
                            tint = blue
                        )
                    }

                }
            }


        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = instructorStudent.ProgramName)
            Text(
                modifier = Modifier
                    .border(width = 1.dp, color = grayShade2)
                    .padding(all = 8.dp), text = instructorStudent.StudentType
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ItemActionType(icon = Icons.Default.Call, title = "Call")
            ItemActionType(icon = Icons.Filled.Email, title = "Message")
            ItemActionType(icon = Icons.Default.LocationOn, title = "Location")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                ItemAddOns(key = "I-Share", value = instructorStudent.StudentDue)
                Spacer(modifier = Modifier.width(16.dp))
                ItemAddOns(key = "Total", value = instructorStudent.DueAmount)
            }

            ItemAddOns(key = "Manage Addons", value = "")

        }

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Row {
                Icon(imageVector = Icons.Default.Build, contentDescription = "Print")
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Print", style = MaterialTheme.typography.bodyLarge)
            }
            Row {
                ItemAddOns(key = "Score", value = "")
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "N.A")
            }
        }


    }


}

@Composable
fun ItemActionType(
    icon: ImageVector,
    title: String
) {

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .border(width = 1.dp, color = lightGray)
            .padding(all = 8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = title, tint = lightGray)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = title, style = MaterialTheme.typography.bodyMedium)
    }


}

@Composable
fun ItemAddOns(
    key: String,
    value: String
) {

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(color = lightGray)
            .padding(all = 8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = key + ": ", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = value, style = MaterialTheme.typography.bodyMedium)
    }


}