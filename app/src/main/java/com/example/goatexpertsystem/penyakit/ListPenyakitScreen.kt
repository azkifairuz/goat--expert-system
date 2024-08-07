package com.example.goatexpertsystem.penyakit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CardColors
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.goatexpertsystem.ui.theme.CatcareexpertsystemTheme
import com.example.goatexpertsystem.ui.theme.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListPenyakitScreen(listPenyakit: List<Penyakit>) {

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarColors(
                    containerColor = Primary,
                    scrolledContainerColor = Primary,
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .width(32.dp)
                            .height(32.dp),
                        imageVector = Icons.Filled.ArrowBack, contentDescription = "back button"
                    )
                },
                title = {
                    Text(
                        text = "List Penyakit",
                        style = MaterialTheme.typography.headlineMedium.copy(color = Color.White),
                    )
                })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Primary)
                .padding(vertical = it.calculateTopPadding(), horizontal = 16.dp)
        ) {
            if (listPenyakit.isEmpty()) {
                Text(
                    text = "...loading",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

            } else {
                LazyColumn {
                    items(listPenyakit) { penyakit ->
                        CardListPenyakit(
                            penyakitName = penyakit.penyakit,
                            deskripsi = penyakit.deskripsi
                        )

                    }
                }
            }
        }
    }

}

@Composable
fun CardListPenyakit(penyakitName: String, deskripsi: String) {
    ElevatedCard(
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContentColor = Color.Black,
            disabledContainerColor = Color.White,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)

    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = penyakitName, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = deskripsi, style = MaterialTheme.typography.bodyLarge)
        }
    }

}

@Preview
@Composable
fun ListPenyakitScreenPreview() {
    CatcareexpertsystemTheme {

        val sampleHistory = listOf(
            Penyakit(1, "p1", "Cacingan", "banyak cacing"),
            Penyakit(1, "p1", "Cacingan", "banyak cacing"),
            Penyakit(1, "p1", "Cacingan", "banyak cacing"),
        )
        ListPenyakitScreen(listPenyakit = sampleHistory)
    }
}