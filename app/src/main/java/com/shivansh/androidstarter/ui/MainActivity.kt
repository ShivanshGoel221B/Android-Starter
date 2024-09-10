package com.shivansh.androidstarter.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.shivansh.androidstarter.ui.event.Event
import com.shivansh.androidstarter.ui.theme.AndroidStarterTheme
import com.shivansh.androidstarter.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                false
            }
        }

        enableEdgeToEdge()
        setContent {
            LaunchedEffect(Unit) {
                viewModel.events.collect { event ->
                    when (event) {
                        is Event.NavigateTo -> TODO()
                        Event.NavigateUp -> TODO()
                        is Event.ShowToast -> TODO()
                    }
                }
            }
            AndroidStarterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(24.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            item {
                                Text(text = "To Change")
                            }
                            temp("Change com.shivansh.androidstarter to Your package name globally")
                            temp("Change MyApplication class to your application")
                            temp("Update Colors")
                            temp("Update splash screen theme")
                            temp("Update App name in strings.xml")
                            temp("Change VCS remote or re-initialize git repository")
                        }
                    }
                }
            }
        }
    }
}

fun LazyListScope.temp(text: String) {
    item {
        Card {
            Text(
                text = text,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}