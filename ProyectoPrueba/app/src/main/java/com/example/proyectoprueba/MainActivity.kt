package com.example.proyectoprueba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectoprueba.ui.theme.ProyectoPruebaTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoPruebaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MusicPlayerScreen()
                }
            }
        }
    }
}

@Composable
fun MusicPlayerScreen() {
    Column(//organiza hijos vertical
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TopBar()
        AlbumArt()
        SongDetails()
        ProgressBar()
        PlayerControls()
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /* Acción de volver */ }) {
            Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Bajar")
        }
        Text("REPRODUCIENDO DESDE EL ÁLBUM", fontSize = 12.sp, fontWeight = FontWeight.Bold)
        IconButton(onClick = { /* Acción de más opciones */ }) {
            Icon(Icons.Default.MoreVert, contentDescription = "Opciones")
        }
    }
}

@Composable
fun AlbumArt() {
    Card(
        modifier = Modifier
            .size(300.dp)
            .padding(vertical = 24.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Image(
            // Asegúrate de tener una imagen llamada 'album_cover.jpg' en tu carpeta res/drawable
            painter = painterResource(id = R.drawable.album_cover),
            contentDescription = "Carátula del Álbum",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
//telling the Compose compiler that this function is intended to describe a piece of your UI.
fun SongDetails() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Midnight Echoes", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text("Aurora Skies", fontSize = 18.sp, color = MaterialTheme.colorScheme.secondary)
    }
}

@Composable
fun ProgressBar() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("0:00", fontSize = 12.sp, color = MaterialTheme.colorScheme.secondary)
            Text("5:00", fontSize = 12.sp, color = MaterialTheme.colorScheme.secondary)
        }
        Spacer(modifier = Modifier.height(4.dp))
        // Slider es un componente más avanzado, lo simulamos con un Box
        Box(modifier = Modifier.fillMaxWidth().height(4.dp).background(MaterialTheme.colorScheme.onSurfaceVariant, shape = CircleShape)) {
            Box(modifier = Modifier.fillMaxWidth(0.5f).height(4.dp).background(MaterialTheme.colorScheme.primary, shape = CircleShape))
        }
    }
}

@Composable
fun PlayerControls() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = {},
            modifier = Modifier.size(70.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Icon(Icons.Filled.Pause, contentDescription = "Pausa", modifier = Modifier.size(40.dp), tint = MaterialTheme.colorScheme.onPrimary)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProyectoPruebaTheme {
        MusicPlayerScreen()
    }
}