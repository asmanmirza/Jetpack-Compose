package com.asman.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asman.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    mainView()
                }
            }
        }
    }
}

@ExperimentalFoundationApi @Preview(showBackground = true) @Composable fun DefaultPreview() {
    JetpackComposeTheme {
        mainView()
    }
}

@ExperimentalFoundationApi @Composable fun mainView() {

    Column(Modifier.fillMaxWidth()) {
        ArticleStyle()
    }
}

@ExperimentalFoundationApi @Composable fun ArticleStyle() {
    MaterialTheme {
        val typography = MaterialTheme.typography
        Column(modifier = Modifier.fillMaxSize()) {

            Column(modifier = Modifier.padding(16.dp)) {
                Image(painter = painterResource(R.drawable.ic_launcher_background), contentDescription = null, modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)), contentScale = ContentScale.Crop)
                Spacer(Modifier.height(16.dp))

                Text("A day wandering through the Delhi " + "in Shark Fin Cove, and a few of the " + "sights I saw", style = typography.h6, maxLines = 2, overflow = TextOverflow.Ellipsis)
                Text("Kohat Enclave, Delhi", style = typography.body2)
                Text("August 2021", style = typography.body2)
            }
            Divider()
            Column {
                LazyColumn {
                    item {
                        Text(text = "First item")
                    }

                    // Add 5 items
                    items(5) { index ->
                        Text(text = "Item: $index")
                    }

                    // Add another single item
                    item {
                        Text(text = "Last item")
                    }
                }
            }
            Divider()
            val gradient = Brush.verticalGradient(0f to androidx.compose.ui.graphics.Color.Gray, 1000f to androidx.compose.ui.graphics.Color.White)
            Box(modifier = Modifier
                .background(androidx.compose.ui.graphics.Color.White)
                .verticalScroll(rememberScrollState())
                .padding(32.dp)) {
                Column {
                    repeat(6) {
                        Box(modifier = Modifier
                            .height(128.dp)
                            .verticalScroll(rememberScrollState())) {
                            Text("Scroll here", modifier = Modifier
                                .border(12.dp, androidx.compose.ui.graphics.Color.Gray)
                                .background(brush = gradient)
                                .padding(24.dp)
                                .height(150.dp))
                        }
                    }
                }
            }
        }
    }
}