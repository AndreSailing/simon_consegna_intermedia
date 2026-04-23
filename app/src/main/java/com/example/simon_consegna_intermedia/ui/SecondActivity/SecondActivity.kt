package com.example.simon_consegna_intermedia.ui.SecondActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.simon_consegna_intermedia.ui.components.GameList
import com.example.simon_consegna_intermedia.ui.theme.Simon_Consegna_IntermediaTheme
import com.example.simon_consegna_intermedia.R


class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val partite = intent.getStringArrayListExtra("partite") ?: arrayListOf()

        setContent {
            Simon_Consegna_IntermediaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SecondScreen(Modifier.padding(innerPadding), partite)
                }
            }
        }
    }
}
@Composable
fun SecondScreen(modifier: Modifier,partite:ArrayList<String>){
    ConstraintLayout(modifier=modifier.fillMaxWidth()
    ) {
        val (gameText,title,spacer1,spacer2)=createRefs()
        Spacer(modifier= Modifier.constrainAs(spacer1){
            top.linkTo(parent.top)

        }.height(16.dp))
        Text(
            modifier= Modifier.constrainAs(title){
                top.linkTo(spacer1.bottom)
            }.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            text= stringResource(R.string.title)

        )
        Spacer(modifier= Modifier.constrainAs(spacer2){
            top.linkTo(title.bottom)

        }.height(16.dp))
        GameList( Modifier.constrainAs(gameText){
            top.linkTo(spacer2.bottom)
            start.linkTo(parent.start)
        },partite)
    }


}