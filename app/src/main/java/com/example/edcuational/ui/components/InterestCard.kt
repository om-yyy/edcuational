package com.example.edcuational.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.edcuational.data.Interest

/**
 * A premium selection card representing a user interest category.
 * Employs State Hoisting pattern for selection management.
 *
 * @param interest The [Interest] data model to render.
 * @param isSelected Whether this specific interest is currently selected by the user.
 * @param onSelectedChange Callback triggered when the user clicks the card, returns new selection state.
 */
@Composable
fun InterestCard(
    interest: Interest,
    isSelected: Boolean,
    onSelectedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    // Design System Color Tokens (Matching the reference UI)
    val brandPurple = Color(0xFF6200EE)
    val surfaceColor = if (isSelected) brandPurple.copy(alpha = 0.06f) else Color.White
    val borderColor = if (isSelected) brandPurple else Color(0xFFE5E5E5)
    val titleColor = if (isSelected) brandPurple else Color(0xFF1C1C1E)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onSelectedChange(!isSelected) },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = surfaceColor),
        border = BorderStroke(1.5.dp, borderColor)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = interest.name,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = titleColor
                )
                if (isSelected) {
                    Text(
                        text = "✓",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = brandPurple
                    )
                }
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = interest.description,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                maxLines = 2
            )
        }
    }
}