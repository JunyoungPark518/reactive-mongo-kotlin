package kr.jypark.jpa.hibernate.repository

import kr.jypark.jpa.hibernate.model.Article
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ArticleRepository : ReactiveCrudRepository<Article?, Long?> {
    fun findByTitle(title: Mono<String>): Flux<Article?>?
    fun findByArticleId(articleId: Mono<Long>): Flux<Article?>?
}