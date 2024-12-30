package com.kakautrade.lanzarseapp.ui.availableproducts.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kakautrade.lanzarseapp.ui.availableproducts.model.ProductList
import com.kakautrade.lanzarseapp.R

class ProductsListAdapter(private val products: List<ProductList>) :
    RecyclerView.Adapter<ProductsListAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.product_image)
        val nameTextView: TextView = itemView.findViewById(R.id.product_name)
        val descriptionTextView: TextView = itemView.findViewById(R.id.product_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_list_item, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        Glide.with(holder.itemView.context)
            .load(product.foto1)
            .into(holder.imageView)
        holder.nameTextView.text = product.nome
        holder.descriptionTextView.text = product.descricaoproduto
    }

    override fun getItemCount(): Int {
        return products.size
    }
}