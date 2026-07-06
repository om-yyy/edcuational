package com.example.edcuational

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.edcuational.navigation.AppNavigation
import com.example.edcuational.ui.theme.EdcuationalTheme

/**
 * The single entry point activity of the application.
 * Adheres to modern single-activity architecture principles.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Make sure the theme name matches your project's generated theme name!
            EdcuationalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Launching the smooth central navigation graph
                    AppNavigation()
                }
            }
        }
    }
}