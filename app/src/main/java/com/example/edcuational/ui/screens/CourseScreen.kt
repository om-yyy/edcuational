package com.example.edcuational.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.edcuational.data.DummyData
import com.example.edcuational.ui.components.CourseCard

/**
 * Screen displaying filtered courses based on the user's selected interest IDs.
 * Fully upgraded with premium dark gradients and glowing thin borders.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseScreen(
    selectedInterestIds: String,
    onCourseClick: (Int) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // 🎨 प्रीमियम कलर्स और बैकग्राउंड ग्रेडिएंट थीम सेटअप
    val deepNightBlue = Color(0xFF0F0C20)
    val deepPurpleShade = Color(0xFF15102A)

    val premiumBackgroundGradient = Brush.verticalGradient(
        colors = listOf(deepNightBlue, deepPurpleShade, deepNightBlue)
    )

    // कोर्सेज कार्ड्स के लिए बेहद खूबसूरत सॉफ्ट नियॉन-ग्लो बॉर्डर
    val softNeonBorder = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFF8A2387).copy(alpha = 0.3f), // सॉफ्ट मैजेंटा
            Color(0xFFE94057).copy(alpha = 0.1f), // हल्का कोरल
            Color(0xFFF27121).copy(alpha = 0.3f)  // सॉफ्ट ऑरेंज
        )
    )

    // Performance Guard को वैसे ही सुरक्षित रखा गया है 👍
    val filteredCourses = remember(selectedInterestIds) {
        val idList = selectedInterestIds.split(",")
            .mapNotNull { it.trim().toIntOrNull() }

        DummyData.courses.filter { course ->
            idList.contains(course.interestId)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Explore Courses",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Navigate Back",
                            tint = Color.White // एरो का कलर वाइट किया डार्क थीम के लिए
                        )
                    }
                },
                // टॉप बार को डार्क बैकग्राउंड में मर्ज किया
                colors = TopAppBarDefaults.topAppBarColors(containerColor = deepNightBlue)
            )
        },
        containerColor = Color.Transparent // कंटेनर को ट्रांसपेरेंट किया ताकि हमारा ग्रेडिएंट काम करे
    ) { innerPadding ->

        // 🌌 मुख्य प्रीमियम ग्रेडिएंट बॉक्स कंटेनर
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(premiumBackgroundGradient)
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
            ) {
                Spacer(modifier = Modifier.height(15.dp))

                // ✨ हेडर टाइटल्स को वाइट और ग्रेसफुल बनाया
                Text(
                    text = "Courses For You",
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.ExtraBold),
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Based on the personal interests you've shared with us.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray.copy(alpha = 0.8f)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Scrollable List of Filtered Courses
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    items(filteredCourses, key = { it.id }) { course ->

                        // 🌟 कोर्स कार्ड को 18.dp राउंडेड ग्लास-इफेक्ट और थिन नियॉन बॉर्डर में रैप किया
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(18.dp))
                                .border(
                                    width = 1.dp,
                                    brush = softNeonBorder,
                                    shape = RoundedCornerShape(18.dp)
                                )
                                .background(Color(0xFF1D183A).copy(alpha = 0.5f))
                        ) {
                            CourseCard(
                                course = course,
                                onCourseClick = onCourseClick
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp)) // कार्ड्स के बीच शानदार गैप
                    }

                    item { Spacer(modifier = Modifier.height(20.dp)) }
                }
            }
        }
    }
}