package com.example.asbapp.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.example.asbapp.databinding.DetailFragmentBinding
import com.example.asbapp.domain.data.Transaction

private const val PARAM_TRANSACTION = "transaction"

class DetailFragment : Fragment() {

    private var transaction: Transaction? = null

    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            transaction = it.getSerializable(PARAM_TRANSACTION) as Transaction
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
        }
        setHasOptionsMenu(true)
        val binding = DetailFragmentBinding.inflate(inflater, container, false)
        binding.transaction = transaction
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> activity?.supportFragmentManager?.popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun newInstance(transaction: Transaction) = DetailFragment().apply {
            arguments = Bundle().apply {
                putSerializable(PARAM_TRANSACTION, transaction)
            }
        }
    }

}