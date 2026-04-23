package com.example.simon_consegna_intermedia.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp




@Composable
fun GameList(modifier: Modifier,partite: ArrayList<String>){
    ConstraintLayout(modifier = modifier.fillMaxWidth()){
        val (col1)=createRefs()
        Column(modifier= Modifier.constrainAs(col1){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        }) {
            for (i in 0 until partite.size step 1){
                Row() {
                    val quadratiPremuti=(partite[i].length+1)/2
                    Text(text = quadratiPremuti.toString())
                    Spacer(Modifier.width(16.dp))
                    Text(text = partite[i])
                }

            }
        }

    }
}