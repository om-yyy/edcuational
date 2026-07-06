package com.example.edcuational.navigation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.edcuational.ui.screens.CourseScreen
import com.example.edcuational.ui.screens.InterestScreen
import com.example.edcuational.ui.screens.VideoScreen

/**
 * Sealed class defining the centralized routes for the navigation graph.
 */
sealed class Screen(val route: String) {
    object Interest : Screen("interest_screen")
    object Course : Screen("course_screen/{selectedIds}") {
        fun createRoute(selectedIds: String) = "course_screen/$selectedIds"
    }
    object Video : Screen("video_screen/{courseId}") {
        fun createRoute(courseId: Int) = "video_screen/$courseId"
    }
}

/**
 * Main Navigation Graph that wires up all screens with optimal state retention.
 */
@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = Screen.Interest.route,
        modifier = modifier
    ) {
        // 1. Interest Selection Screen
        composable(route = Screen.Interest.route) {
            InterestScreen(
                onContinueClick = { joinedIds ->
                    navController.navigate(Screen.Course.createRoute(joinedIds))
                }
            )
        }

        // 2. Filtered Course Screen
        composable(
            route = Screen.Course.route,
            arguments = listOf(
                navArgument("selectedIds") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val selectedIds = backStackEntry.arguments?.getString("selectedIds") ?: ""
            CourseScreen(
                selectedInterestIds = selectedIds,
                onCourseClick = { courseId ->
                    navController.navigate(Screen.Video.createRoute(courseId))
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        // 3. Video Lessons Screen
        composable(
            route = Screen.Video.route,
            arguments = listOf(
                navArgument("courseId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val courseId = backStackEntry.arguments?.getInt("courseId") ?: 0
            VideoScreen(
                courseId = courseId,
                onVideoClick = { youtubeId ->
                    // High-Performance Intent logic: Open directly in YouTube App or Browser
                    openYouTubeVideo(context, youtubeId)
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

/**
 * Helper function to trigger YouTube Intent safely.
 */
private fun openYouTubeVideo(context: Context, youtubeId: String) {
    val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$youtubeId"))
    val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=$youtubeId"))

    try {
        // First try to open via YouTube native application
        context.startActivity(appIntent)
    } catch (ex: Exception) {
        // Fallback to web browser if YouTube app is missing
        try {
            context.startActivity(webIntent)
        } catch (e: Exception) {
            Toast.makeText(context, "Cannot open video. No browser found.", Toast.LENGTH_SHORT).show()
        }
    }
}