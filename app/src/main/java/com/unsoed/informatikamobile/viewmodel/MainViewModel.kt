package com.unsoed.informatikamobile.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unsoed.informatikamobile.data.network.RetrofitInstance
import kotlinx.coroutines.launch
import com.unsoed.informatikamobile.model.Book

class MainViewModel : ViewModel() {

    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> = _books

    fun fetchBooks(query: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.searchBooks(query, limit = 10)
                if (response.isSuccessful) {
                    val result = response.body()?.docs ?: emptyList()

                    // Map dari BookDoc -> Book
                    val mappedResult = result.map { doc ->
                        Book(
                            title = doc.title,
                            authorName = doc.authorName,
                            firstPublishYear = doc.firstPublishYear
                        )
                    }

                    _books.value = mappedResult
                    Log.d("SUCCESS_GET_DATA", "$mappedResult")
                } else {
                    Log.e("API_ERROR", "${response.code()} ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("API_EXCEPTION", e.localizedMessage ?: "Unknown error")
            }
        }
    }

}