package kr.jypark.jpa.hibernate.component

import kr.jypark.jpa.hibernate.model.Article
import kr.jypark.jpa.hibernate.repository.ArticleRepository
import kr.jypark.jpa.response.ArticleMain
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Component
import java.util.*

@Component
class ArticleComponent {

    @Autowired
    val repository: ArticleRepository?=null

    @Bean
    fun selectArticleAllList(operations: MongoOperations?=null): ArticleMain? {
        val articleMain: ArticleMain = ArticleMain()
        articleMain.message = ""
        articleMain.resultYn = "Y"
        articleMain.articleList = operations!!.findAll(Article::class.java)
        return articleMain
    }

    @Bean
    fun insertArticle(type: String, categoryId: String, title: String, thumbnail: String) {
        var query: MongoOperations?=null
        query!!.dropCollection(Article::class.java)
        query!!.insert(Article(UUID.randomUUID().toString().toLong(), type, categoryId, title, thumbnail), "")
    }

    @Bean
    fun updateArticle(articleId: Long, title: String) {
        var operations: MongoOperations?=null
        var updateFields: Update?=null
        updateFields!!.set("title", title);
//        operations!!.updateFirst(
//                Query.query(
//                    where("articleId").`is`(articleId)
//                ), updateFields, Article.class)
    }

}