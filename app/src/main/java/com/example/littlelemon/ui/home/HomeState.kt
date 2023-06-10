package com.example.littlelemon.ui.home

import com.example.littlelemon.common.Resource
import com.example.littlelemon.domain.model.MenuItem

data class HomeState(
    val menu: Resource<List<MenuItem>> = Resource.Loading(),
    val searchPhrase: String = "",
    val categories: Set<String> = emptySet(),
    val categorySelected: String = ""
)
