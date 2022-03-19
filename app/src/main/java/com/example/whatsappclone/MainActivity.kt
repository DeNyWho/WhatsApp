package com.example.whatsappclone

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappclone.ui.theme.WhatsAppCloneTheme
import com.example.whatsappclone.ui.theme.WhatsAppThemeColor
import com.example.whatsappclone.view.WhatsAppCalls
import com.example.whatsappclone.view.WhatsAppChats
import com.example.whatsappclone.view.WhatsAppStatus
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatsAppCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WhatsApp()
                }
            }
        }
    }
}

@Composable
fun WhatsApp() {
    val context = LocalContext.current
    val topBar: @Composable () -> Unit = {
        TopAppBar (
            title = {
                Text(
                    text = "WhatsApp",
                    color = Color.White,
                    fontSize = 20.sp,
                )
            },
            actions = {
                IconButton(
                    onClick = {
                        Toast.makeText(context, "Clicked Search", Toast.LENGTH_SHORT).show()
                    }
                ) {
                    Icon(
                        Icons.Filled.Search,
                        contentDescription = "Search",
                        tint = Color.White
                    )
                }
//                IconButton(
//                    onClick = {
//                        Toast.makeText(context, "Clicked Message", Toast.LENGTH_SHORT).show()
//                    }
//                ) {
//                    Icon(
//                        Icons.Filled.MailOutline,
//                        contentDescription = "Message",
//                        tint = Color.White
//                    )
//                }
                IconButton(
                    onClick = {
                        Toast.makeText(context, "Clicked Menu", Toast.LENGTH_SHORT).show()
                    }
                ) {
                    Icon(
                        Icons.Filled.MoreVert,
                        contentDescription = "Menu",
                        tint = Color.White
                    )
                }
            },
            backgroundColor = WhatsAppThemeColor,
            elevation = AppBarDefaults.TopAppBarElevation
        )
    }

    Scaffold(
        topBar = {
            topBar()
        },
        content = {
            WhatsAppTab()
        }
    )
}

@Preview
@Composable
fun WhatsAppPrev () {
    WhatsApp ()
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WhatsAppTab () {
    val pagerState = rememberPagerState(pageCount = 3)
    Column {
        Tabs (pagerState)
        TabsContent (pagerState)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs (pagerState: PagerState) {
    var list = listOf ("CHATS","STATUS","CALLS")
    val scope = rememberCoroutineScope ()
    
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = WhatsAppThemeColor,
        contentColor = Color.Gray,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.pagerTabIndicatorOffset (pagerState, tabPositions),
                height = 3.dp,
                color = Color.White
            )
        }
    ) {
        list.forEachIndexed { index, tabs ->
            Tab(
                text = {
                    Text(
                        list.get(index),
                        color = Color.White
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(pagerState: PagerState) {
    HorizontalPager(state = pagerState) { page ->
        when(page) {
            0 -> WhatsAppChats()
            1 -> WhatsAppStatus()
            2 -> WhatsAppCalls()
        }
    }
}