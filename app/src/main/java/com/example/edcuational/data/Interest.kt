package com.example.edcuational.data

/**
 * Represents a user interest category in the application.
 * Designed to be clean and easily mapable to Firebase Firestore documents later.
 *
 * @property id Unique identifier for the interest.
 * @property name The display title of the interest (e.g., "Programming", "Biology").
 * @property description A brief tagline to display inside the UI card.
 */
data class Interest(
    val id: Int,
    val name: String,
    val description: String
)