package com.example.simon_consegna_intermedia.ui.main
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.simon_consegna_intermedia.ui.SecondActivity.SecondActivity
import com.example.simon_consegna_intermedia.ui.components.Screen
import com.example.simon_consegna_intermedia.ui.theme.Simon_Consegna_IntermediaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Simon_Consegna_IntermediaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Screen(Modifier.padding(innerPadding), { partite ->
                        val intent = Intent(this, SecondActivity::class.java)
                        intent.putStringArrayListExtra("partite", ArrayList(partite))
                        startActivity(intent)

                    })()

                }
            }
        }
    }
}


