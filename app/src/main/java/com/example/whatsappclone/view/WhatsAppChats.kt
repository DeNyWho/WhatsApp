package com.example.whatsappclone.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappclone.model.SampleData
import java.text.SimpleDateFormat
import java.util.*
import com.example.whatsappclone.R
import com.example.whatsappclone.ui.theme.lightGrayColor

@Composable
fun WhatsAppChats() {
    val date = SimpleDateFormat("hh:mm a")
    val strDate: String = date.format(Date())

    val listOfData = listOf(
        SampleData("Name 1", "Sample 1", "Sample Url", strDate),
        SampleData("Name 2", "Sample 2", "Sample Url", strDate),
        SampleData("Name 3", "Sample 3", "Sample Url", strDate),
        SampleData("Name 4", "Sample 4", "Sample Url", strDate),
        SampleData("Name 5", "Sample 5", "Sample Url", strDate),
        SampleData("Name 6", "Sample 6", "Sample Url", strDate),
        SampleData("Name 7", "Sample 7", "Sample Url", strDate),
        SampleData("Name 8", "Sample 8", "Sample Url", strDate),
        SampleData("Name 9", "Sample 9", "Sample Url", strDate),
        SampleData("Name 10", "Sample 10", "Sample Url", strDate)
    )
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .wrapContentSize(Alignment.Center)
    ) {
        LazyColumn(
            modifier = Modifier.padding(10.dp)
        ){
            items(listOfData.size) { index ->
                SampleDataListItem(listOfData[index])
            }

        }
        
    }
}

@Composable
fun SampleDataListItem(sampleData: SampleData) {
    Column (
        modifier = Modifier
            .padding(5.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.user), // Need firebase here
                contentDescription = "Image",
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(5.dp))
            )
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = sampleData.name,
                        modifier = Modifier
                            .weight(1.0f),
                        fontSize = 15.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = sampleData.createdDate,
                        modifier = Modifier
                            .weight(0.5f),
                        fontSize = 12.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.End
                    )
                }

                Spacer(modifier = Modifier.padding(5.dp))

                Text(
                    text = sampleData.desc,
                    fontSize = 15.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.padding(5.dp))

                Divider(color = lightGrayColor, thickness = 1.dp)
            }
        }
    }
}






















