package com.example.basiccodelab

import android.os.Bundle
//ui
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//own
import com.example.basiccodelab.ui.theme.BasicCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //in set content goes the jetpack compose code
            //composable functions instead of xml files
            BasicCodelabTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Surface(color = MaterialTheme.colorScheme.primary){
//        Text(
//            text = "Hello $name!",
//            modifier = modifier.padding(24.dp)
//        )
//    }
    val expanded = remember { mutableStateOf(false) }
    //state to not be forgotten after each run & checked for recomposition
    //remember to not be reset after each run
    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface(color = MaterialTheme.colorScheme.primary, modifier = modifier.padding(2.dp)) {

    Row {
            Column(
                modifier = modifier
                    .padding(bottom = extraPadding)
                    .weight(1f)
            ) {
                Text("Hello")
                Text("$name!")
            }
            ElevatedButton(onClick = {expanded.value = !expanded.value}) {
                Text(if (expanded.value) "Show less" else "Show more")
            }
        }
    }
}


//@Composable
//fun MyApp(modifier: Modifier = Modifier) {
//    Surface (
//        modifier = modifier,
//        color = MaterialTheme.colorScheme.background
//    ){ Greeting("Android") }
//}
@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose")
) {
    Column(modifier) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    BasicCodelabTheme {
//        Greeting("Android")
        MyApp()
    }
}