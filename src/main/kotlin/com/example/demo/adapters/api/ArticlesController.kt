package com.example.demo.adapters.api

import com.example.demo.domain.articles.ArticleService
import com.example.demo.domain.model.Article
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ArticlesController(
    private val articleService: ArticleService
) {

    @PostMapping("/api/articles")
    fun createArticle(@RequestBody createArticleRequest: CreateArticleRequest): ResponseEntity<ArticleResponse> {
        val savedArticle = articleService.saveArticle(createArticleRequest.toModel())

        return ResponseEntity(
            ArticleResponse.fromModel(savedArticle),
            HttpStatus.CREATED,
        )
    }
}

data class CreateArticleRequest(val title: String, val text: String) {
    fun toModel() = Article(
        title = title,
        text = text,
    )
}

data class ArticleResponse(
    val id: String?,
    val title: String,
    val text: String,
    val userAvater: String?
) {
    companion object {
        fun fromModel(article: Article) = ArticleResponse(
            id = article.id?.value,
            title = article.title,
            text = article.text,
            userAvater = article.userAvatar,
        )
    }
}