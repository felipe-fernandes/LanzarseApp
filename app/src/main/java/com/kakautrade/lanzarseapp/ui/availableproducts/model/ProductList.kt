package com.kakautrade.lanzarseapp.ui.availableproducts.model
import kotlinx.serialization.Serializable

@Serializable
data class ProductList(
    val idproduto: Int,
    val nome: String,
    val descricaoproduto: String,
    val foto1: String
)