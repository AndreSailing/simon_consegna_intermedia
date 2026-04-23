package com.example.simon_consegna_intermedia.ui.SecondActivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.simon_consegna_intermedia.ui.components.GameList
import com.example.simon_consegna_intermedia.ui.theme.Simon_Consegna_IntermediaTheme

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
    ConstraintLayout(modifier=modifier.fillMaxWidth()) {
        val (gameText)=createRefs()
        GameList( Modifier.constrainAs(gameText){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        },partite)
    }


}