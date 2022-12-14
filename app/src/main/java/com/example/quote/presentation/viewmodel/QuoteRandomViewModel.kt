package com.example.quote.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quote.domain.model.QuoteModel
import com.example.quote.domain.usecase.GetQuoteRandomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteRandomViewModel
@Inject constructor(
    private val getQuoteRandomUseCase: GetQuoteRandomUseCase
) : ViewModel() {
    private val _quoteModelRandomMutableStateFlow = MutableStateFlow(QuoteModel(0, "", ""))
    val quoteModel: StateFlow<QuoteModel> = _quoteModelRandomMutableStateFlow

    fun randomQuote() {
        viewModelScope.launch {
            _quoteModelRandomMutableStateFlow.value = getQuoteRandomUseCase.getQuoteRandom().first()
            //_quoteModel.value = GetQuoteUseCase(quoteDAO).getQuote(1).first()
        }
    }
}