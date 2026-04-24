package com.example.simon_consegna_intermedia.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


class Screen(
    private val modifier: Modifier= Modifier,
    private val onClickNewActivity:(ArrayList<String>)->Unit
) {
    @Composable
    operator fun invoke(){
        val partite = rememberSaveable { mutableListOf<String>()           }
        var partita by rememberSaveable { mutableStateOf<String>("") }
        val configuration= LocalConfiguration.current
        when(configuration.orientation){
            Configuration.ORIENTATION_PORTRAIT->{
                OrientationPortrait(partite,partita, partitaChange = { partita = it })
            }

            Configuration.ORIENTATION_LANDSCAPE->{
                OrientationLandscape(partite,partita, partitaChange = { partita = it })
            }
            else -> OrientationLandscape(partite,partita, partitaChange = { partita = it })
        }
    }
    @Composable
    private fun OrientationPortrait( partite: MutableList<String>, partita: String,partitaChange: (String)-> Unit){

        val screenHeight = LocalConfiguration.current.screenHeightDp.dp
        ConstraintLayout(modifier = modifier.fillMaxWidth()) {
            val (columnMatrix, textPartita,buttons)=createRefs()


            ColumnMatrix(
                screenHeight = screenHeight*0.8f,
                modifier= Modifier.constrainAs(columnMatrix){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
                onClick = { color -> partitaChange(partita +",$color") }
            )()
            GameText(partita.drop(1),  Modifier.constrainAs(textPartita){
                top.linkTo(columnMatrix.bottom)
            })

            GameButton({partitaChange("")},{
                partite.add(partita.drop(1))
                partitaChange("")
                onClickNewActivity(ArrayList(partite))
            }, modifier= Modifier.constrainAs(buttons){
                top.linkTo(textPartita.bottom)
            })()

        }

    }
    @Composable
    private fun OrientationLandscape(partite: MutableList<String>, partita: String,partitaChange: (String)-> Unit){
        val screenHeight = LocalConfiguration.current.screenHeightDp.dp
        ConstraintLayout(modifier = modifier.fillMaxWidth()) {
            val (columnMatrix, column2)=createRefs()

            Column(Modifier.constrainAs(columnMatrix){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }.fillMaxWidth(0.5f)) {
                ColumnMatrix(
                    screenHeight = screenHeight,
                    modifier= Modifier,
                    onClick = { color -> partitaChange("$partita,$color") }
                )()
            }
            Column(Modifier.constrainAs(column2){
                top.linkTo(parent.top)
                start.linkTo(columnMatrix.end)
            }.fillMaxWidth(0.5f)) {
            GameText(partita.drop(1),  Modifier)

            GameButton({partitaChange("")},{
                partite.add(partita.drop(1))
                partitaChange("")
                onClickNewActivity(ArrayList(partite))
            }, modifier= Modifier)()
            }

        }
    }
}