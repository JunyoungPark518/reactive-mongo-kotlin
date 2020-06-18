package kr.jypark.jpa

import kr.jypark.jpa.util.StreamTemplate
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JpaApplication

fun main(args: Array<String>) {
    StreamTemplate().test123()
    runApplication<JpaApplication>(*args)
}
