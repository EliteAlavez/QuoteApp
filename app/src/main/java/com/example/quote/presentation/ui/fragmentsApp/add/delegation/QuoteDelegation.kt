package com.example.quote.presentation.ui.fragmentsApp.add.delegation

import com.example.quote.presentation.ui.fragmentsApp.add.AddQuoteData

data class QuoteDelegation(var quote: String? = null) {
    operator fun setValue(thisRef: AddQuoteData, property: Any?, value: String?) {
        if (value != null && value.isNotEmpty()) {
            quote = value
        }
    }

    operator fun getValue(thisRef: AddQuoteData, property: Any?): String? = quote
}