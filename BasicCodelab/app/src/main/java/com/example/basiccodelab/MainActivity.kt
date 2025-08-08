package com.example.basiccodelab

import android.os.Bundle
//ui
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//own
import com.example.basiccodelab.ui.theme.BasicCodelabTheme

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Surface(color = MaterialTheme.colorScheme.primary){
//        Text(
//            text = "Hello $name!",
//            modifier = modifier.padding(24.dp)
//        )
//    }
    var expanded by rememberSaveable { mutableStateOf(false) }
    //state to not be forgotten after each run & checked for recomposition
    //remember to not be reset after each run
    val extraPadding = if (expanded) 48.dp else 0.dp

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
            ElevatedButton(onClick = {expanded = !expanded}) {
                Text(if (expanded) "Show less" else "Show more")
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
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = List(1000) { "$it" }
) {
    LazyColumn (modifier = modifier.padding(vertical = 4.dp)){
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    onContinueClicked: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked

        ) {
            Text("Continue")
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
    //using a by keyword instead of the =. This is a property delegate that
    // saves you from typing .value every time.

    Surface(modifier) {
        if (shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        } else {
            Greetings()
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun MyAppPreview() {
    BasicCodelabTheme {
        MyApp()
    }
}

//@Preview(showBackground = true, widthDp = 320)
//@Composable
//fun GreetingPreview() {
//    BasicCodelabTheme {
//        Greeting("Android")
//        MyApp()
//        OnboardingScreen()
//        Greetings()
//    }
//}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //in set content goes the jetpack compose code
            //composable functions instead of xml files
            BasicCodelabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(modifier = Modifier.padding(innerPadding))
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                }
            }
        }
    }
}