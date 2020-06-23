package kr.jypark.jpa.response

import kr.jypark.jpa.hibernate.model.Reply
import reactor.core.publisher.Flux

class ReplyMain {
    var list: Flux<Reply?> = Flux.empty()
    var resultYn: String? = null
    var message: String? = null
}