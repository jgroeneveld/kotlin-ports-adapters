package com.example.demo.domain.articles

import com.example.demo.domain.model.Article

interface ArticleWriteRepository {
    fun writeArticle(article: Article): Article
}