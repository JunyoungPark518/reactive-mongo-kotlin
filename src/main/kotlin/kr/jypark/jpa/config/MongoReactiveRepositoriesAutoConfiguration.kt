package kr.jypark.jpa.config

import com.mongodb.client.MongoClient
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.autoconfigure.data.mongo.MongoReactiveDataAutoConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.mongodb.repository.config.ReactiveMongoRepositoryConfigurationExtension
import org.springframework.data.mongodb.repository.support.ReactiveMongoRepositoryFactoryBean

/**
 * @Configuration : 이 클래스가 빈 정의의 source임을 지시
 * @ConditionalOnClass : classpath에 있어야 하는 모든 클래스를 나열. 위 코드의 경우에는 MongoDB의 reactive MongoClient(Reactive Streams version)과 ReactiveMongoRepository. 이는  Reactive MongoDB와 Spring Data MongoDB 2.0이 classpath에 있는 경우에만 적용된다는 것을 의미
 * @ConditionalOnMissingBean : ReactiveMongoRepositoryFactoryBean과 ReactiveMongoConfigurationExtension 빈이 없는 경우에만 적용된다는 것을 의미
 * @ConditionalOnProperty : 이 속성을 적용하려면 spring.data.mongodb.reactive-repositories 속성을 true로 설정해야 함.(이런 속성이 제공되지 않은 경우 디폴트 세팅)
 * @Import : reactive repositories에 대한 모든 빈 생성을 MongoReactiveRepositoriesAutoConfigureRegistrar에 위임
 * @AutoConfigureAfter : autoconfiguration 정책이 MongoReactiveDataAutoConfiguration이 적용된 이후에만 적용됨. 이 경우 특정 인프라가 구성될 수 있음
 */

@Configuration
@ConditionalOnClass(MongoClient::class, ReactiveMongoRepository::class)
@ConditionalOnMissingBean(ReactiveMongoRepositoryFactoryBean::class, ReactiveMongoRepositoryConfigurationExtension::class)
@ConditionalOnProperty(prefix = "spring.data.mongodb.reactive-repositories", name = ["enabled"], havingValue = "true", matchIfMissing = true)
@Import(MongoReactiveRepositoriesAutoConfigureRegistrar::class)
@AutoConfigureAfter(MongoReactiveDataAutoConfiguration::class)
class MongoReactiveRepositoriesAutoConfiguration