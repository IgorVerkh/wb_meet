package ru.wb.meetings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.ui_v2.navigation.RootNavGraph
import com.example.ui_v2.theme.MeetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeetTheme {
                val navController = rememberNavController()
                RootNavGraph(navController = navController)
            }
        }
    }
}
