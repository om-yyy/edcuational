package com.example.edcuational.data

/**
 * Represents a specific educational course belonging to an interest category.
 * Holds relational data to filter courses based on selected interests.
 *
 * @property id Unique identifier for the course.
 * @property interestId The ID of the parent [Interest] this course belongs to (Relational Key).
 * @property title The name of the course (e.g., "Android Dev with Compose").
 * @property description A summary of what the course covers.
 * @property level The difficulty level (e.g., "Beginner", "Intermediate", "Advanced").
 * @property duration Total estimated time to complete the course (e.g., "12 Hours").
 */
data class Course(
    val id: Int,
    val interestId: Int,
    val title: String,
    val description: String,
    val level: String,
    val duration: String
)