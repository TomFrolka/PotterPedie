package com.tf.potterpedie.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tf.potterpedie.R

@Composable
fun DetailEntry(
    isList: Boolean = false,
    list: List<String> = emptyList(),
    title: String,
    value: Any? = null
) {
    if (value.toString().isNotEmpty() || list.isNotEmpty()){
        Card(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_very_small ))) {
            Row(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelSmall
                )
                Spacer(modifier = Modifier.weight(1f))
                if (isList) {
                    Column {
                        list.forEach {
                            Text(
                                text = it,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                } else {
                    Text(
                        text = value.toString(),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Preview
@Composable
fun DetailEntryPreview() {
    DetailEntry(
        title = "Alternate actors",
        isList = true,
        list = listOf("Johny Depp", "Mads Mikkelsen")
    )
}