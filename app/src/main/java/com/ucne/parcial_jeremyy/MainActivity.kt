package com.ucne.parcial_jeremyy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ucne.parcial_jeremyy.ui.VerbosList.VerbosListScreen
import com.ucne.parcial_jeremyy.ui.theme.Parcial_JeremyyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial_JeremyyTheme {
                VerbosListScreen()
            }
        }
    }
}

