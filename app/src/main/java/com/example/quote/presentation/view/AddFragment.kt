package com.example.quote.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.quote.databinding.FragmentAddQuoteBinding
import com.example.quote.domain.model.QuoteModel
import com.example.quote.presentation.viewmodel.QuoteAddViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFragment : Fragment() {

    private var _binding: FragmentAddQuoteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var viewModelAdd:QuoteAddViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAddQuoteBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModelAdd= ViewModelProvider(this) [QuoteAddViewModel::class.java]
        binding.btnAdd.setOnClickListener{
            val quoteCelebritie = QuoteModel(
                id = binding.tvId.text.toString().toInt(),
                quote = binding.tvQuote.text.toString(),
                author = binding.tvAuthor.text.toString()
            )
            viewModelAdd.addQuote(quoteCelebritie)
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}