package com.kakautrade.lanzarseapp.ui.availableproducts.adapter

import androidx.recyclerview.widget.DiffUtil
import com.kakautrade.lanzarseapp.ui.availableproducts.model.ProductList

class ProductsDiffCallback : DiffUtil.ItemCallback<ProductList>() {
    override fun areItemsTheSame(oldItem: ProductList, newItem: ProductList): Boolean {
        return oldItem.idproduto == newItem.idproduto
    }

    override fun areContentsTheSame(oldItem: ProductList, newItem: ProductList): Boolean {
        return oldItem == newItem
    }

    fun getOldListSize(): Int {
        // Return the size of the old list
        // You might need to store the old list as a property in the callback
        // or access it from the adapter if possible
        return 0 // Replace with the actual size of the old list
    }

    fun getNewListSize(): Int {
        // Return the size of the new list
        // You might need to store the new list as a property in the callback
        // or access it from the adapter if possible
        return 0 // Replace with the actual size of the new list
    }
}