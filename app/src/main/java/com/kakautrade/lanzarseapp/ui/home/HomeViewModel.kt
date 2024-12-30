package com.kakautrade.lanzarseapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import connectors.produtos.ProdutosConnector
import connectors.produtos.execute
import connectors.produtos.instance
import kotlinx.coroutines.launch

class HomeViewModel(
    private val produtosConnector: ProdutosConnector = ProdutosConnector.instance
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text


    init {
        viewModelScope.launch {
            try {
                val produtosDisponiveis = ProdutosConnector.instance.listProdutosDisponiveis.execute().data.productss
                println(produtosDisponiveis)
            } catch (e: Exception) {
                println(e)
            }
        }
    }
}