package com.example.demo.domain.articles

import com.example.demo.domain.model.Article
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val writeRepository: ArticleWriteRepository
) {
    fun saveArticle(article: Article): Article {
        // [...] do some other stuff that has to do with the save article use case. [...]
        return writeRepository.writeArticle(article)
    }

}