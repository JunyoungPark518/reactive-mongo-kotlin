package kr.jypark.jpa.hibernate.model

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * @Document : 선택적인 어노테이션으로, 이 도메인 객체가 MongoDB 컬렉션으로 저장될 것임을 명시. 인자를 넣어 컬렉션명을 지정할 수도 있음. 지정하지 않는 경우 클래스명의 소문자로 지정.
 * @Id : Spring Data Commons의 어노테이션으로 이 속성이 key임을 명시.
 */

@Document
//@Entity
class Reply {
    @Id
    @GeneratedValue(generator = "replyId")
    var replyId: Long = 0
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
    var type: String = ""
    var typeId: Long = 0
    var depth: Int = 0
    var parentId: Long = 0
    var userId: Long = 0
    var text: String = ""
    var likeCount: Int = 0
    var reportCount: Int = 0
    var delYn = "N"
    var adminDelYn = "N"
    var noticeYn = "N"
    var createdDatetime: LocalDateTime = LocalDateTime.now()
}