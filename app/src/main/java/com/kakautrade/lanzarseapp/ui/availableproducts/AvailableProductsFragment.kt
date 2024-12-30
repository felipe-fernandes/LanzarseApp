package com.kakautrade.lanzarseapp.ui.availableproducts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.kakautrade.lanzarseapp.databinding.FragmentAvailableProductsListBinding
import com.kakautrade.lanzarseapp.ui.availableproducts.adapter.ProductsListAdapter
import com.kakautrade.lanzarseapp.ui.availableproducts.model.ProductList
import com.kakautrade.lanzarseapp.ui.availableproducts.viewmodel.ProductsListViewModel
import com.kakautrade.lanzarseapp.ui.availableproducts.viewmodel.ProductsState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class AvailableProductsFragment : Fragment() , ProductsListAdapter.OnProductClickListener{

    private val productsListViewModel: ProductsListViewModel by viewModels()
    private var _binding: FragmentAvailableProductsListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAvailableProductsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.list.layoutManager = LinearLayoutManager(context)

        val adapter = ProductsListAdapter(this) // Pass 'this' as the OnProductClickListener
        binding.list.adapter = adapter

        productsListViewModel.productsState.onEach { state ->
            when (state) {
                is ProductsState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE // Show ProgressBar
                }
                is ProductsState.Success -> {
                    binding.progressBar.visibility = View.GONE // Hide ProgressBar
                    (binding.list.adapter as ProductsListAdapter).submitList(state.products)
                }
                is ProductsState.Error -> {
                    binding.progressBar.visibility = View.GONE // Hide ProgressBar
                    // Handle error
                }
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onProductClick(product: ProductList) {
        // Handle product click event
        // e.g., navigate to product detail screen

    }
}