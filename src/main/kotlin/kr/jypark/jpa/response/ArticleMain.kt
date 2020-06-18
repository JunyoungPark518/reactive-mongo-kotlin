package kr.jypark.jpa.response

import kr.jypark.jpa.hibernate.model.Article

class ArticleMain {
    var articleList: List<Article>? = null
    var resultYn: String? = null
    var message: String? = null
}