package com.kakautrade.lanzarseapp.ui.availableproducts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.kakautrade.lanzarseapp.databinding.FragmentAvailableProductsListBinding
import com.kakautrade.lanzarseapp.ui.availableproducts.adapter.ProductsListAdapter
import com.kakautrade.lanzarseapp.ui.availableproducts.viewmodel.ProductsListViewModel

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

        productsListViewModel.products.observe(viewLifecycleOwner) { productsList ->
            binding.list.adapter = ProductsListAdapter(productsList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}