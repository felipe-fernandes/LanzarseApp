package com.kakautrade.lanzarseapp.ui.availableproducts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kakautrade.lanzarseapp.ui.availableproducts.model.ProductList
import connectors.produtos.ProdutosConnector
import connectors.produtos.execute
import connectors.produtos.instance
import kotlinx.coroutines.launch

class ProductsListViewModel(
    private val produtosConnector: ProdutosConnector = ProdutosConnector.instance
) : ViewModel() {

    private val _products = MutableLiveData<List<ProductList>>()
    val products: LiveData<List<ProductList>> = _products

    init {
        viewModelScope.launch {
            try {
                val productsList = produtosConnector.listProdutosDisponiveis.execute().data.productss
                // Map the items to ProductList objects
                val mappedProductsList = productsList.map { productItem ->
                    ProductList(
                        idproduto = productItem.idproduto ?: 1,
                        nome = productItem.nome ?: "",
                        descricaoproduto = productItem.descricaoproduto ?: "",
                        foto1 = productItem.foto1 ?: ""
                    )
                }
                _products.value = mappedProductsList // Assign the mapped list
            } catch (e: Exception) {
                // Handle error, e.g., show an error message
                println(e)
            }
        }
    }
}