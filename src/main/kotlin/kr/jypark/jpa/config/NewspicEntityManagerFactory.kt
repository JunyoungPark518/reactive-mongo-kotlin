package kr.jypark.jpa.config

import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

class NewspicEntityManagerFactory {
    private var entityManagerFactory: EntityManagerFactory? = null

    fun setUpEntityManagerFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("park")
    }

    fun closeEntityManagerFactory() {
        entityManagerFactory!!.close()
    }
}