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
import com.example.edcuational.ui.components.VideoCard

/**
 * Screen displaying the list of available video lessons for a selected course.
 * Fully optimized and upgraded with rich neon-border look maxxing.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideoScreen(
    courseId: Int,
    onVideoClick: (String) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // 🎨 प्रीमियम डार्क नाइट और पर्पल ग्रेडिएंट थीम सेटअप
    val deepNightBlue = Color(0xFF0F0C20)
    val deepPurpleShade = Color(0xFF15102A)

    val premiumBackgroundGradient = Brush.verticalGradient(
        colors = listOf(deepNightBlue, deepPurpleShade, deepNightBlue)
    )

    // वीडियो कार्ड्स के लिए एक बहुत ही सॉफ्ट और अट्रैक्टिव रिफ्लेक्टिव बॉर्डर
    val subtleVideoBorder = Brush.horizontalGradient(
        colors = listOf(
            Color.White.copy(alpha = 0.09f),
            Color.White.copy(alpha = 0.02f),
            Color.White.copy(alpha = 0.05f)
        )
    )

    // Performance Guard को वैसे ही सुपर फ़ास्ट रखा गया है 👍
    val filteredVideos = remember(courseId) {
        DummyData.videos.filter { video ->
            video.courseId == courseId
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Course Content",
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
                            tint = Color.White // डार्क थीम के लिए एरो को वाइट किया
                        )
                    }
                },
                // टॉप बार को मुख्य बैकग्राउंड के साथ स्मूथली सिंक किया
                colors = TopAppBarDefaults.topAppBarColors(containerColor = deepNightBlue)
            )
        },
        containerColor = Color.Transparent // ट्रांसपेरेंट ताकि हमारा ग्रेडिएंट खिल कर आए
    ) { innerPadding ->

        // 🌌 मेन प्रीमियम ग्रेडिएंट बैकग्राउंड बॉक्स
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

                // ✨ हेडर टाइटल्स को बोल्ड वाइट और मॉडर्न लुक दिया
                Text(
                    text = "Available Lessons",
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.ExtraBold),
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Watch and learn at your own pace. Click to play on YouTube.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray.copy(alpha = 0.8f)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Scrollable List of Videos linked to the course
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    if (filteredVideos.isEmpty()) {
                        item {
                            Text(
                                text = "No videos available for this course yet.",
                                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
                                color = Color.Gray.copy(alpha = 0.7f),
                                modifier = Modifier.padding(top = 40.dp)
                            )
                        }
                    } else {
                        items(filteredVideos, key = { it.id }) { video ->

                            // 🌟 हर वीडियो कार्ड को 16.dp राउंडेड कोर्नर्स, ग्लासमोर्फिक टच और थिन बॉर्डर में रैप किया
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(16.dp))
                                    .border(
                                        width = 1.dp,
                                        brush = subtleVideoBorder,
                                        shape = RoundedCornerShape(16.dp)
                                    )
                                    .background(Color(0xFF1D183A).copy(alpha = 0.4f)) // डार्क कंपोनेंट बैकग्राउंड
                            ) {
                                VideoCard(
                                    video = video,
                                    onVideoClick = onVideoClick
                                )
                            }
                            Spacer(modifier = Modifier.height(12.dp)) // लेक्चर्स के बीच परफेक्ट गैप
                        }
                    }

                    item { Spacer(modifier = Modifier.height(20.dp)) }
                }
            }
        }
    }
}