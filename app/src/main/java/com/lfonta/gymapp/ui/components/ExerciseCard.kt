package com.lfonta.gymapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.lfonta.gymapp.core.constants.BodyRegionLevel
import com.lfonta.gymapp.core.constants.ExerciseGeneralCategory
import com.lfonta.gymapp.core.constants.ExerciseId
import com.lfonta.gymapp.core.constants.ExerciseSpecificId
import com.lfonta.gymapp.core.constants.SubCategoryLevel
import com.lfonta.gymapp.core.constants.toStringRes
import com.lfonta.gymapp.ui.theme.GymAppTheme

@Composable
fun ExerciseCard(modifier: Modifier = Modifier,
                 title: String,
                 categories: Set<ExerciseGeneralCategory>,
                 inRoutine: Boolean = false,
                 exerciseId: ExerciseId,
                 onIconPressed: () -> Unit
) {
    Row(modifier) {
        Column(modifier) {
            Text(text = title)
            Row(modifier) {
                for (item in categories) {

                    Text(text = stringResource(item.toStringRes()))
                }
            }
        }
        if (!inRoutine) {
            IconButton(onClick = onIconPressed) {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview( showBackground = true )
@Composable
fun ExerciseCardPreview() {
    GymAppTheme {
        ExerciseCard(
            title = "Ejemplo",
            categories = setOf(ExerciseGeneralCategory.ABDOMINAL, ExerciseGeneralCategory.BACK, ExerciseGeneralCategory.CHEST, ExerciseGeneralCategory.LEGS, ExerciseGeneralCategory.SHOULDER),
            exerciseId = ExerciseId(BodyRegionLevel.UPPER, SubCategoryLevel.CHEST,
                ExerciseSpecificId("Press Banca")
            )
        ) {
        }
    }
}