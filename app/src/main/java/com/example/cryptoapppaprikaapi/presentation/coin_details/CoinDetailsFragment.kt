package com.example.cryptoapppaprikaapi.presentation.coin_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.cryptoapppaprikaapi.CryptocurrencyApp
import com.example.cryptoapppaprikaapi.R
import com.example.cryptoapppaprikaapi.databinding.FragmentCoinDetailsBinding
import com.example.cryptoapppaprikaapi.presentation.CoinViewModel
import com.example.cryptoapppaprikaapi.presentation.ViewModelFactory
import com.example.cryptoapppaprikaapi.presentation.coin_details.adapter.TeamMembersAdapter
import javax.inject.Inject


class CoinDetailsFragment : Fragment() {

    private var _binding: FragmentCoinDetailsBinding? = null
    private val binding get() = _binding!!

    private val teamMembersAdapter by lazy {
        TeamMembersAdapter()
    }

    private val component by lazy {
        (activity?.application as CryptocurrencyApp).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: CoinViewModel

    private val args: CoinDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        component.inject(this)

        _binding = FragmentCoinDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
        loadDetails()
        setupRecyclerView()
        observeViewModel()
    }

    private fun loadDetails() {
        viewModel.loadCoinDetails(args.coinId)
    }

    private fun observeViewModel() {
        viewModel.coinDetails.observe(viewLifecycleOwner) {
            with(binding) {
                tvRank.text = "${it.rank}."
                tvName.text = "${it.name} (${it.symbol})"
                if (it.description.isNotEmpty()) {
                    tvDescription.text = it.description
                } else {
                    tvDescription.text = getString(R.string.no_description)
                }
                if (it.team.isEmpty()) {
                    tvMembers.text = getString(R.string.no_team_members)
                } else {
                    teamMembersAdapter.differ.submitList(it.team)
                }
            }
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerViewMembers.adapter = teamMembersAdapter
    }

    private fun setupViewModel() {
        viewModel =
            ViewModelProvider(this, viewModelFactory)[CoinViewModel::class.java]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}