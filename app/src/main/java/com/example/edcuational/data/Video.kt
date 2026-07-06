package com.example.edcuational.data

/**
 * Represents a video lesson within a specific course.
 * Contains direct mapping to YouTube content for streaming.
 *
 * @property id Unique identifier for the video.
 * @property courseId The ID of the parent [Course] this video belongs to (Relational Key).
 * @property title The title of the video lesson (e.g., "Introduction to Jetpack Compose").
 * @property channelName The name of the YouTube creator/channel providing the video.
 * @property duration The length of the video (e.g., "15:20").
 * @property youtubeId The unique 11-character YouTube video identifier used for playback.
 */
data class Video(
    val id: Int,
    val courseId: Int,
    val title: String,
    val channelName: String,
    val duration: String,
    val youtubeId: String
)