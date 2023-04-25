package com.example.cataplication.models

import com.google.gson.annotations.SerializedName

data class Cat(
    @SerializedName(value = "name") val breedName: String,
    @SerializedName(value = "origin") val origin: String,
    @SerializedName(value = "affection_level") val affectionLevel: Int,
    @SerializedName(value = "intelligence") val intelligence: Int,
    val imageUrl: String = "https://img.freepik.com/vector-gratis/ilustracion-icono-vector-dibujos-animados-lindo-gato-sentado-concepto-icono-naturaleza-animal-aislado-premium-vector-estilo-dibujos-animados-plana_138676-4148.jpg?w=2000"
)