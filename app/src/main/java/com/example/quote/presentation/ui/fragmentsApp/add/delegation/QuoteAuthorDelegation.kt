package com.example.quote.presentation.ui.fragmentsApp.add.delegation

import com.example.quote.presentation.ui.fragmentsApp.add.AddQuoteData

data class QuoteAuthorDelegation(var author: String? = null) {
    operator fun setValue(thisRef: AddQuoteData, property: Any?, value: String?) {
        if (value != null && value.isNotEmpty()) {
            author = value
        }
    }
    operator fun getValue(thisRef: AddQuoteData, property: Any?): String? = author
}