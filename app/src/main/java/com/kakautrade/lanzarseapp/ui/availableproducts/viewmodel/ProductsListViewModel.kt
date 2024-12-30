package com.kakautrade.lanzarseapp.ui.availableproducts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kakautrade.lanzarseapp.ui.availableproducts.model.ProductList
import connectors.produtos.ProdutosConnector
import connectors.produtos.execute
import connectors.produtos.instance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductsListViewModel(
    private val produtosConnector: ProdutosConnector = ProdutosConnector.instance
) : ViewModel() {

    private val _productsState = MutableStateFlow<ProductsState>(ProductsState.Loading)
    val productsState: StateFlow<ProductsState> = _productsState.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val productsList = produtosConnector.listProdutosDisponiveis.execute().data.productss
                    .map { productItem ->
                        ProductList(
                            idproduto = productItem.idproduto ?: 1,
                            nome = productItem.nome ?: "",
                            descricaoproduto = productItem.descricaoproduto ?: "",
                            foto1 = productItem.foto1 ?: ""
                        )
                    }
                _productsState.value = ProductsState.Success(productsList)
            } catch (e: Exception) {
                _productsState.value = ProductsState.Error(e)
                // Handle error, e.g., log or show error message
            }
        }
    }
}

sealed class ProductsState {
    object Loading : ProductsState()
    data class Success(val products: List<ProductList>) : ProductsState()
    data class Error(val throwable: Throwable) : ProductsState()
}