package com.example.simon_consegna_intermedia

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
import com.example.simon_consegna_intermedia.ui.theme.Simon_Consegna_IntermediaTheme
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
    val colorList= listOf(
        R.color.R,
        R.color.B,
        R.color.C,
        R.color.M,
        R.color.V,
        R.color.Y)
    val colorName=listOf("R","B","C","M","V","Y")
    val partite=mutableListOf<String>()
    var partita=""
    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
        val screenHeight = LocalConfiguration.current.screenHeightDp.dp

        val (col1, col2) = createRefs()

        Column(
            modifier = Modifier
                .constrainAs(col1) {
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(col2.start, margin = 16.dp)
                    top.linkTo(parent.top)
                    width = Dimension.fillToConstraints
                }
        ) {
            var i = 0
            while (i < colorList.size) {
                Spacer(modifier= Modifier.height(16.dp))
                Button(
                    colors = ButtonColors(
                        colorResource(colorList[i]),
                        colorResource(colorList[i]),
                        colorResource(colorList[i]),
                        colorResource(colorList[i])
                    ),
                    onClick = { partita += "," + colorName[i] },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(screenHeight/colorList.size)
                ) {}
                i += 2
            }
        }

        Column(
            modifier = Modifier
                .constrainAs(col2) {
                    start.linkTo(col1.end, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                    top.linkTo(parent.top)
                    width = Dimension.fillToConstraints
                }
        ) {
            var i = 1
            while (i < colorList.size) {
                Spacer(modifier= Modifier.height(16.dp))
                Button(
                    colors = ButtonColors(
                        colorResource(colorList[i]),
                        colorResource(colorList[i]),
                        colorResource(colorList[i]),
                        colorResource(colorList[i])
                    ),
                    onClick = { partita += "," + colorName[i] },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(screenHeight/colorList.size)
                ) {}
                i += 2
            }
        }
    }


}
