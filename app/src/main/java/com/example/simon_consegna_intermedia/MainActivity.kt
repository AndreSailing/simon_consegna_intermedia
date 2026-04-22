package com.example.simon_consegna_intermedia
import com.example.simon_consegna_intermedia.ui.components.ColumnMatrix

import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.background
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.constraintlayout.compose.Dimension
import androidx.compose.ui.platform.LocalConfiguration
import com.example.simon_consegna_intermedia.ui.components.GameButton
import com.example.simon_consegna_intermedia.ui.theme.Simon_Consegna_IntermediaTheme
import com.example.simon_consegna_intermedia.ui.theme.colorMap

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Simon_Consegna_IntermediaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    mainActivityScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun mainActivityScreen(modifier: Modifier= Modifier){
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
        val scroll = rememberScrollState()
        Text(
            text = partita.drop(1),
            modifier = Modifier
                .background(Color(0x22000000)) // grigio trasparente
                .fillMaxWidth()
                .padding(18.dp)
                .heightIn(min = 60.dp, max = 60.dp)   // spazio fisso ≈ 3 righe
                .verticalScroll(scroll)
                .constrainAs(textPartita){
                    top.linkTo(columnMatrix.bottom)
                },
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )

        GameButton({partita=""},{
            partite.add(partita.drop(1))
            partita=""
        }, modifier= Modifier.constrainAs(buttons){
            top.linkTo(textPartita.bottom)
        })()

    }


}
