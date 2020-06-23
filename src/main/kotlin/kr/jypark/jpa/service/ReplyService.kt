package kr.jypark.jpa.service

import kr.jypark.jpa.hibernate.model.Reply
import kr.jypark.jpa.hibernate.repository.ReplyRepository
import kr.jypark.jpa.response.ReplyDetail
import kr.jypark.jpa.response.ReplyMain
import kr.jypark.jpa.util.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.BodyInserter
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Service
class ReplyService {

    companion object : Log

    @Autowired
    lateinit var repository: ReplyRepository

    fun findReplyList(): ReplyMain? {
        var res = ReplyMain()
        res.resultYn = "Y"
        res.message = ""
        res.list = repository.findAll()
        return res
    }

    fun findReplyById(replyId: Long): ReplyDetail? {
        var res = ReplyDetail()
        res.resultYn = "Y"
        res.message = ""
        res.detail = repository.findById(replyId)
        return res
    }

    fun save(map: Map<String, Any>) {
        logger.info(map.toString())
        var reply: Reply = Reply()
        reply.type = map["type"].toString()
        reply.typeId = map["typeId"].toString().toLong()
        reply.depth = map["depth"].toString().toInt()
        reply.parentId = map["parentId"].toString().toLong()
        reply.userId = map["userId"].toString().toLong()
        reply.text = map["text"].toString()
        repository.save(reply)
//        return ServerResponse.status(HttpStatus.CREATED)
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .body(BodyInserters.fromObject(map))
    }
}