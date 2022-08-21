package com.example.cryptoapppaprikaapi.presentation.coin_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapppaprikaapi.CryptocurrencyApp
import com.example.cryptoapppaprikaapi.databinding.FragmentCoinListBinding
import com.example.cryptoapppaprikaapi.presentation.CoinViewModel
import com.example.cryptoapppaprikaapi.presentation.ViewModelFactory
import com.example.cryptoapppaprikaapi.presentation.coin_list.adapter.CoinListAdapter
import javax.inject.Inject

class CoinListFragment : Fragment() {

    private var _binding: FragmentCoinListBinding? = null
    private val binding get() = _binding!!

    private val component by lazy {
        (activity?.application as CryptocurrencyApp).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: CoinViewModel

    private val coinAdapter by lazy {
        CoinListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        component.inject(this)
        _binding = FragmentCoinListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
        loadCoins()
        setupRecyclerView()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.coins.observe(viewLifecycleOwner) {
            coinAdapter.differ.submitList(it)
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerViewCoins.adapter = coinAdapter
    }

    private fun loadCoins() {
        viewModel.loadCoins()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[CoinViewModel::class.java]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}