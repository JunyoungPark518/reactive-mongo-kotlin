package kr.jypark.jpa.hibernate.repository

import kr.jypark.jpa.hibernate.model.Reply
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ReplyRepository : ReactiveCrudRepository<Reply?, Long?> {

}