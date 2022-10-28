package com.example.quote.presentation.ui.fragmentsApp.add

import com.example.quote.presentation.ui.fragmentsApp.add.delegation.QuoteAuthorDelegation
import com.example.quote.presentation.ui.fragmentsApp.add.delegation.QuoteDelegation
import com.example.quote.presentation.ui.fragmentsApp.add.delegation.QuoteidDelegation

class AddQuoteData{
    var id: Int? by QuoteidDelegation()
    var quote: String? by QuoteDelegation()
    var author: String? by QuoteAuthorDelegation()

    constructor( id: Int? = null, quote: String? = null, author: String? = null){
        this.id = id
        this.quote = quote
        this.author = author
    }

    fun isValid() = id != null && quote != null && author != null
}