package com.example.whatsappclone.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappclone.R
import com.example.whatsappclone.model.SampleData
import com.example.whatsappclone.ui.theme.lightGrayColor
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun WhatsAppStatus() {
//    Column(
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Text(
//            text = "WhatsApp Status",
//            fontSize = 15.sp,
//            color = Color.Black,
//            fontWeight = FontWeight.Normal
//        )
//    }

    val date = SimpleDateFormat("hh:mm a")
    val strDate: String = date.format(Date())

    val listOfData = listOf(
        SampleData("Status 1", "Status 1 desc", "Status Url", strDate),
        SampleData("Status 2", "Status 2 desc", "Status Url", strDate),
        SampleData("Status 3", "Status 3 desc", "Status Url", strDate),
        SampleData("Status 4", "Status 4 desc", "Status Url", strDate),
        SampleData("Status 5", "Status 5 desc", "Status Url", strDate),
    )

    val listOfViewedData = listOf(
        SampleData("Viewed 1", "Viewed 1 desc", "Viewed Url", strDate),
        SampleData("Viewed 2", "Viewed 2 desc", "Viewed Url", strDate),
        SampleData("Viewed 3", "Viewed 3 desc", "Viewed Url", strDate),
        SampleData("Viewed 4", "Viewed 4 desc", "Viewed Url", strDate),
        SampleData("Viewed 5", "Viewed 5 desc", "Viewed Url", strDate),
    )

    LazyColumn(
        modifier = Modifier
            .background(Color.White)
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = "My Status",
                        modifier = Modifier
                            .width(70.dp)
                            .height(70.dp)
                            .padding(5.dp)
                    )
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "My Status",
                            fontSize = 15.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.padding(2.dp))
                        Text(
                            text = "Tap to add status update",
                            fontSize = 14.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Normal
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(lightGrayColor)
                ) {
                    Text(
                        text = "Recent updates",
                        modifier = Modifier
                            .padding(15.dp, 5.dp, 10.dp, 5.dp),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                }
            }
        }

        items(listOfData.size) { index ->
            SampleStatusListItem(data = listOfData[index])
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(lightGrayColor)
            ) {
                Text(
                    text = "Viewed updates",
                    modifier = Modifier
                        .padding(15.dp, 5.dp, 10.dp, 5.dp),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            }
        }

        items(listOfViewedData.size) { index ->
            SampleStatusListItem(listOfViewedData[index])
        }


    }

}

@Composable
fun SampleStatusListItem(data: SampleData) {
    Column {
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            
            Image(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "Status Image",
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
                    .padding(5.dp)
            )

            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            ) {

                Text(
                    text = data.name,
                    fontSize = 15.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.padding(3.dp))

                Text(
                    text = "Today ${data.createdDate}",
                    fontSize = 15.sp,
                    color = Color.Gray
                )

            }
            
        }
        
    }
}


//@Composable
//fun SampleViewedListItem(sampleData: SampleData) {
//
//}
