package kr.jypark.jpa.controller

import kr.jypark.jpa.response.ReplyDetail
import kr.jypark.jpa.response.ReplyMain
import kr.jypark.jpa.service.ReplyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Controller
@RequestMapping("reply")
class ReplyController {

    @Autowired lateinit var service: ReplyService

    @GetMapping("list")
    @ResponseBody
    fun list(): ReplyMain? {
        return service.findReplyList()
    }

    @GetMapping("detail")
    @ResponseBody
    fun detail(@RequestParam replyId: Long): ReplyDetail? {
        return service.findReplyById(replyId)
    }

    @PostMapping("save")
    @ResponseBody
    fun save(@RequestParam map: Map<String, Any>) {
        service.save(map)
    }
}