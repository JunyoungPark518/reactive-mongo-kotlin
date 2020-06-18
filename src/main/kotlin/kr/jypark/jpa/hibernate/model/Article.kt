package kr.jypark.jpa.hibernate.model

import org.springframework.data.mongodb.core.mapping.Document
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * @Document : 선택적인 어노테이션으로, 이 도메인 객체가 MongoDB 컬렉션으로 저장될 것임을 명시. 인자를 넣어 컬렉션명을 지정할 수도 있음. 지정하지 않는 경우 클래스명의 소문자로 지정.
 * @Id : Spring Data Commons의 어노테이션으로 이 속성이 key임을 명시.
 */

@Document
@Entity
class Article {
    @Id
    @GeneratedValue(generator = "articleId")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private var articleId: Long? = null
    private var type: String? = null
    private var categoryId: String? = null
    private var title: String? = null
    private var thumbnail: String? = null
    private var thumbnailWidth: Int? = null
    private var thumbnailHeight: Int? = null
    private var description: String? = null
    private var link: String? = null
    private var providerId: String? = null
    private var createdDatetime: Date? = null

    constructor()

    constructor(articleId: Long, title: String) {
        this.articleId = articleId
        this.title = title
    }

    constructor(thumbnail: String) {
        this.thumbnail = thumbnail
    }
    constructor(articleId: Long, type: String, categoryId: String, title: String, thumbnail: String){
        this.articleId = articleId
        this.type = type
        this.categoryId = categoryId
        this.title = title
        this.thumbnail = thumbnail
    }
}