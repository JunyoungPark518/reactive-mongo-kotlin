package kr.jypark.jpa.controller

import kr.jypark.jpa.response.ArticleMain
import kr.jypark.jpa.hibernate.component.ArticleComponent
import kr.jypark.jpa.hibernate.model.Article
import kr.jypark.jpa.service.ArticleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("article")
class ArticleController {

    @Autowired lateinit var service: ArticleService
    @Autowired lateinit var component: ArticleComponent

    @GetMapping("list")
    fun list(): ArticleMain? {
        return component!!.selectArticleAllList();
    }

    @PostMapping("insert")
    fun insert() {
        component!!.insertArticle("ARTICLE", "CA0101", "TITLE", "THUMBNAIL")
    }

    @GetMapping("update")
    fun update() {
        component!!.updateArticle(1, "2")
    }

    @GetMapping("id")
    fun findById(articleId: Long): Article? {
        return service!!.selectArticleById(articleId)
    }

    @GetMapping("title")
    fun findByTitle(title: String): Article? {
        return service!!.selectArticleByTitle(title)
    }

}