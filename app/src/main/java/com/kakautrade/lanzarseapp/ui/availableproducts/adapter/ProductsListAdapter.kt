package com.kakautrade.lanzarseapp.ui.availableproducts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kakautrade.lanzarseapp.databinding.ProductListItemBinding
import com.kakautrade.lanzarseapp.ui.availableproducts.model.ProductList

class ProductsListAdapter(private val onProductClickListener: OnProductClickListener) :
    ListAdapter<ProductList, ProductsListAdapter.ProductViewHolder>(ProductsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product, onProductClickListener)
    }

    class ProductViewHolder(private val binding: ProductListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductList, onProductClickListener: OnProductClickListener) {
            binding.productName.text = product.nome
            binding.productDescription.text = product.descricaoproduto

            // Load image using Glide
            Glide.with(binding.root.context)
                .load(product.foto1)
                .into(binding.productImage)

            binding.root.setOnClickListener {
                onProductClickListener.onProductClick(product)
            }
        }
    }

    interface OnProductClickListener {
        fun onProductClick(product: ProductList)
    }
}