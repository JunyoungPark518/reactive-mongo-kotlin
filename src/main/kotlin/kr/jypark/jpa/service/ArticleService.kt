package kr.jypark.jpa.service

import kr.jypark.jpa.hibernate.model.Article
import kr.jypark.jpa.hibernate.repository.ArticleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class ArticleService {

    @Autowired
    lateinit var repository: ArticleRepository

    fun selectArticleById(articleId: Long): Article? {
        var param: Mono<Long> = Mono.just(articleId)
        return repository.findByArticleId(param)!!.blockFirst()
    }

    fun selectArticleByTitle(title: String): Article? {
        var param: Mono<String> = Mono.just(title)
        return repository.findByTitle(param)!!.blockFirst()
    }
}