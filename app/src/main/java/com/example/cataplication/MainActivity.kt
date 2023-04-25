package com.example.cataplication

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import coil.compose.rememberAsyncImagePainter
import com.example.cataplication.bloc.viewModels.ViewModelCat
import com.example.cataplication.bloc.viewModels.ViewModelCatsFactory
import com.example.cataplication.models.Cat
import com.example.cataplication.repositories.CatRepository
import com.example.cataplication.services.CatApiService
import com.example.cataplication.services.CatApiUtilities
import com.example.cataplication.ui.theme.CatAplicationTheme
import com.example.cataplication.views.CardListScreen
import com.example.cataplication.views.CardScreen

class MainActivity : ComponentActivity() {

    private lateinit var viewModelCat : ViewModelCat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val catApiService = CatApiUtilities.getInstance().create(CatApiService::class.java)
        val catRepository = CatRepository(catApiService)
        viewModelCat = ViewModelProvider(this, ViewModelCatsFactory(catRepository)).get(ViewModelCat::class.java)
        viewModelCat.cats.observe(this) {
            Log.d("RESPONSE", "onCreate: ${it.toString()}")
            setContent {
                CatAplicationTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        CardListScreen(it)
                    }
                }
            }
        }
    }
}