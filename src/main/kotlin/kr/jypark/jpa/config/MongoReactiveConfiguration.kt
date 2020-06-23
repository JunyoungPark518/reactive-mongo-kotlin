package kr.jypark.jpa.config

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@EnableReactiveMongoRepositories
class MongoReactiveConfiguration : AbstractReactiveMongoConfiguration() {

    @Autowired var mongoClient : MongoClient = MongoClients.create()

    override fun getDatabaseName(): String {
       return "local"
    }
}