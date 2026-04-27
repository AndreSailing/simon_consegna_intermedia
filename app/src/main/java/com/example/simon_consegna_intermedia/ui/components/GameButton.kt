package com.example.simon_consegna_intermedia.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.simon_consegna_intermedia.R

class GameButton (
    private val onClick1: () -> Unit,
    private val onClick2: () -> Unit,
    private val modifier: Modifier
){
    @Composable
    operator fun invoke() {


            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {onClick1()},
                    modifier = Modifier.weight(1f)
                ) {
                    Text(stringResource(R.string.b1Text))
                }

                Button(
                    onClick = {onClick2()
                       },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(stringResource(R.string.b2Text))
                }
            }
    }

}




