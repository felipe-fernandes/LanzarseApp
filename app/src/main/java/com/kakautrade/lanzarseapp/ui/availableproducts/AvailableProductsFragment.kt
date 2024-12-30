package com.kakautrade.lanzarseapp.ui.availableproducts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.onEach
import com.kakautrade.lanzarseapp.databinding.FragmentAvailableProductsListBinding
import com.kakautrade.lanzarseapp.ui.availableproducts.adapter.ProductsListAdapter
import com.kakautrade.lanzarseapp.ui.availableproducts.viewmodel.ProductsListViewModel
import com.kakautrade.lanzarseapp.ui.availableproducts.viewmodel.ProductsState
import kotlinx.coroutines.flow.launchIn

class AvailableProductsFragment : Fragment() {

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

        productsListViewModel.productsState.onEach { state ->
            when (state) {
                is ProductsState.Loading -> {
                    // Show loading indicator
                }
                is ProductsState.Success -> {
                    binding.list.adapter = ProductsListAdapter(state.products)
                }
                is ProductsState.Error -> {
                    // Handle error, e.g., show error message
                }
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}