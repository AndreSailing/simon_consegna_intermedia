package com.example.simon_consegna_intermedia.ui.main
import com.example.simon_consegna_intermedia.ui.components.ColumnMatrix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.platform.LocalConfiguration
import com.example.simon_consegna_intermedia.ui.components.GameButton
import com.example.simon_consegna_intermedia.ui.components.GameText
import com.example.simon_consegna_intermedia.ui.theme.Simon_Consegna_IntermediaTheme
import com.example.simon_consegna_intermedia.ui.theme.colorMap

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Simon_Consegna_IntermediaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    mainActivityScreen(Modifier.padding(innerPadding),{})
                }
            }
        }
    }
}

@Composable
fun mainActivityScreen(modifier: Modifier= Modifier, onClickNewActivity:()->Unit){
    val colorName=colorMap.keys.toList()

    val partite=mutableListOf<String>()
    var partita by remember { mutableStateOf<String>("") }
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
        val (columnMatrix, textPartita,buttons)=createRefs()

        ColumnMatrix(
            screenHeight = screenHeight*0.8f,
            modifier= Modifier.constrainAs(columnMatrix){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            },
            onClick = { color -> partita += ",$color" }
        )()
        GameText(partita.drop(1),  Modifier.constrainAs(textPartita){
            top.linkTo(columnMatrix.bottom)
        })

        GameButton({partita=""},{
            partite.add(partita.drop(1))
            partita=""
            onClickNewActivity()
        }, modifier= Modifier.constrainAs(buttons){
            top.linkTo(textPartita.bottom)
        })()

    }


}
