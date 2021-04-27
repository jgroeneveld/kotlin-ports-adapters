package com.example.demo.adapters.db

import com.example.demo.domain.articles.ArticleWriteRepository
import com.example.demo.domain.model.Article
import com.example.demo.domain.model.ArticleID
import org.springframework.stereotype.Repository

@Repository
class ArticleRepository: ArticleWriteRepository {
    override fun writeArticle(article: Article): Article {
        return article.copy(id = ArticleID("random id")) // emulating a saved article

        // usually this would be a place where we map the domain article to the entity article and delegate to
        // the hibernate repo - or of course use another means of persistance.
    }
}