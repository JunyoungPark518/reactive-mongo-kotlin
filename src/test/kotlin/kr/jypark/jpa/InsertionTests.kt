package kr.jypark.jpa

import kr.jypark.jpa.hibernate.model.Reply
import kr.jypark.jpa.hibernate.repository.ReplyRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class InsertionTests {

    @Autowired
    lateinit var repository : ReplyRepository

    @Test
    fun contextLoads() {
        var model : Reply = Reply()
        model.type = "POLL"

        repository.save(model)

    }

}
