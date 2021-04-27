package com.example.demo.domain.model

// introduce a value class for ids to enforce type safety and add validations if needed
data class ArticleID(val value: String) {
    init {
        require(value.isNotBlank()) // we could add also format validations here.
    }
}

data class Article(
    val id: ArticleID? = null,
    val title: String,
    val text: String,
    val userAvatar: String? = null,
) {
    init {
        // add some defensive validations here to protect our data integrity always.
        require(id?.value?.isNotBlank() ?: true) { "id must be filled when given" }
        require(title.isNotBlank()) { "title must be filled when given" }
        require(text.isNotBlank()) { "text must be present" }
        require(userAvatar?.isNotBlank() ?: true) { "userAvatar must be filled when given" }
    }
}
