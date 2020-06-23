package kr.jypark.jpa.response

import kr.jypark.jpa.hibernate.model.Reply
import reactor.core.publisher.Mono

class ReplyDetail {
    var detail: Mono<Reply?> = Mono.empty()
    var resultYn: String? = null
    var message: String? = null
}