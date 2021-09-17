package com.example.roomexample

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roomexample.entity.SampleEntity
import com.example.roomexample.ui.theme.RoomexampleTheme
import com.example.roomexample.viewmodel.SampleViewModel
import com.example.roomexample.viewmodel.SampleViewModelFactory
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomexampleTheme {
                CallDatabase()
            }
        }
    }
}

val date = SimpleDateFormat("dd-MM-yyyy")
val strDate: String = date.format(Date())

val insertSampleData = listOf(
    SampleEntity(1, "Sample 1", "Make it easy sample 1", "Image Url 1", strDate ),
    SampleEntity(2, "Sample 2", "Make it easy sample 2", "Image Url 2", strDate ),
    SampleEntity(3, "Sample 3", "Make it easy sample 3", "Image Url 3", strDate ),
    SampleEntity(4, "Sample 4", "Make it easy sample 4", "Image Url 4", strDate ),
    SampleEntity(5, "Sample 5", "Make it easy sample 5", "Image Url 5", strDate ),
    SampleEntity(6, "Sample 6", "Make it easy sample 6", "Image Url 6", strDate ),
    SampleEntity(7, "Sample 7", "Make it easy sample 7", "Image Url 7", strDate ),
    SampleEntity(8, "Sample 8", "Make it easy sample 8", "Image Url 8", strDate ),
    SampleEntity(9, "Sample 9", "Make it easy sample 9", "Image Url 9", strDate ),
    SampleEntity(10, "Sample 10", "Make it easy sample 10", "Image Url 10", strDate ),
    )

@Composable
fun CallDatabase(){
    val context = LocalContext.current
    val sampleViewModel: SampleViewModel = viewModel(
        factory = SampleViewModelFactory(context.applicationContext as Application)
    )

    sampleViewModel.addSample(insertSampleData)


}
