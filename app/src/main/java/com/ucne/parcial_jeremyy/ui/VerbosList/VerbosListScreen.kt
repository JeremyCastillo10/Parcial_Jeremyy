package com.ucne.parcial_jeremyy.ui.VerbosList

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ucne.parcial_jeremyy.data.dto.remote.VerboDto


@Composable
fun VerbosListScreen(
    viewModel: VerbosListViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row{
                        Text(text = "Lista")
                        Spacer(Modifier.width(16.dp))

                    }

                }

            )


        },

        ) {

        val uiState by viewModel.uiState.collectAsState()

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(it)) {

            VerbosLista(
                verbo = uiState.verbo,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
        }

    }

}



@Composable
fun VerbosLista(
    verbo: List<VerboDto>,
    modifier: Modifier = Modifier
) {

    LazyColumn(modifier = modifier) {
        items(verbo) { verbo ->
            VerboRow(verbo)
        }
    }
}

@Composable
fun VerboRow(verbo: VerboDto) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(text = "Verbo: ${verbo.verbo}",
            style = TextStyle(fontFamily = FontFamily.Default),
            color = Color.White
        )

        AsyncImage(
            model = verbo.Imagen,
            contentDescription = null
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            color = Color.LightGray
        )
    }
}
