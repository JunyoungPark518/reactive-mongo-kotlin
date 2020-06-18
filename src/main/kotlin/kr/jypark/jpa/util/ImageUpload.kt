package kr.jypark.jpa.util

import kr.jypark.jpa.hibernate.model.Article
import org.springframework.core.io.ResourceLoader
import org.springframework.http.codec.multipart.FilePart
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.nio.file.Paths


class ImageUpload {

    val UPLOAD_ROOT: String = "uploadHost:port"
    val resourceLoader: ResourceLoader?= null

    fun upload(files: Flux<FilePart>): Mono<Void> {
        return files.flatMap { file ->
//                    val saveDatabaseImage: Mono<Article> = imageRepository.save(
//                        Article(file.filename())
//                    )
            val saveDatabaseImage: Mono<Article>? = null
                    val copyFile: Mono<Void> = Mono.just(
                            Paths.get(UPLOAD_ROOT, file.filename())
                                    .toFile())
                            .log("createImage-picktarget")
//                            .map(file -> {
//                                try {
//                                    file.createNewFile()
//                                    return @Map destFile
//                                } catch (e: IOException) {
//                                    throw RuntimeException(e)
//                                }
//                            })
                            .log("createImage-newfile")
                            .flatMap(file::transferTo)
                            .log("createImage-copy")
                    Mono.`when`(saveDatabaseImage, copyFile)
                }
                .then()
    }

}