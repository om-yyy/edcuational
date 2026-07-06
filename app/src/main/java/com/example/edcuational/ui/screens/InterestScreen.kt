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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.edcuational.data.DummyData
import com.example.edcuational.ui.components.InterestCard

/**
 * Screen that allows users to select multiple educational interest areas.
 * Upgraded with premium deep gradient background and glassmorphic styling.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterestScreen(
    onContinueClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val selectedIds = remember { mutableStateListOf<Int>() }

    // 🎨 प्रीमियम कलर्स और ग्रेडिएंट्स सेटअप
    val deepNightBlue = Color(0xFF0F0C20)
    val deepPurpleShade = Color(0xFF15102A)

    val premiumBackgroundGradient = Brush.verticalGradient(
        colors = listOf(deepNightBlue, deepPurpleShade, deepNightBlue)
    )

    val neonButtonGradient = Brush.horizontalGradient(
        colors = listOf(Color(0xFF8A2387), Color(0xFFE94057), Color(0xFFF27121))
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Setup Profile",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                },
                // टॉप बार को भी डार्क बैकग्राउंड के साथ मिक्स किया
                colors = TopAppBarDefaults.topAppBarColors(containerColor = deepNightBlue)
            )
        },
        containerColor = Color.Transparent // कंटेनर कलर ट्रांसपेरेंट किया ताकि हमारा ग्रेडिएंट दिखे
    ) { innerPadding ->

        // 🌌 मुख्य प्रीमियम बैकग्राउंड बॉक्स
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

                // ✨ अट्रैक्टिव हेडिंग वाइट कलर और ग्लोइंग फील के साथ
                Text(
                    text = "What are your\ninterests?",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.ExtraBold,
                        lineHeight = MaterialTheme.typography.headlineLarge.lineHeight * 1.1f
                    ),
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Select your interests to get courses and videos tailored just for you.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray.copy(alpha = 0.8f)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Scrollable List of Interest Cards
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    items(DummyData.interests) { interest ->
                        val isSelected = selectedIds.contains(interest.id)

                        // कार्ड को चारों तरफ से एक ब्यूटीफुल सॉफ्ट बॉर्डर दिया
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .border(
                                    width = 1.dp,
                                    brush = Brush.horizontalGradient(
                                        colors = if (isSelected) {
                                            listOf(Color(0xFF8A2387), Color(0xFFE94057))
                                        } else {
                                            listOf(Color.White.copy(alpha = 0.08f), Color.White.copy(alpha = 0.03f))
                                        }
                                    ),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .background(Color(0xFF1D183A).copy(alpha = 0.6f))
                        ) {
                            InterestCard(
                                interest = interest,
                                isSelected = isSelected,
                                onSelectedChange = { selected ->
                                    if (selected) {
                                        selectedIds.add(interest.id)
                                    } else {
                                        selectedIds.remove(interest.id)
                                    }
                                }
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp)) // थोड़ा गैप बढ़ाया ताकि बॉर्डर्स साफ़ दिखें
                    }

                    item { Spacer(modifier = Modifier.height(90.dp)) }
                }
            }

            // 🎯 प्रीमियम ग्रेडिएंट कंटिन्यू बटन
            val isEnabled = selectedIds.isNotEmpty()

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(20.dp)
                    .height(54.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .then(
                        if (isEnabled) Modifier.background(neonButtonGradient)
                        else Modifier.background(Color(0xFF252142))
                    ),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        val joinedIds = selectedIds.joinToString(separator = ",")
                        onContinueClick(joinedIds)
                    },
                    enabled = isEnabled,
                    modifier = Modifier.fillMaxSize(),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent, // पैरेंट बॉक्स का ग्रेडिएंट दिखेगा
                        disabledContainerColor = Color.Transparent
                    )
                ) {
                    Text(
                        text = "Continue",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = if (isEnabled) Color.White else Color.White.copy(alpha = 0.3f)
                    )
                }
            }
        }
    }
}