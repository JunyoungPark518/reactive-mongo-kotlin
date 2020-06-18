package kr.jypark.jpa.config

import java.sql.*
import java.util.*
import java.util.logging.Logger
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

class NewspicMongoDriver : Driver {
    @Throws(SQLException::class)
    override fun connect(url: String?, info: Properties?): Connection? {
        return if (info == null) connect(url)
            else DriverManager.getConnection(url, info)
    }

    @Throws(SQLException::class)
    fun connect(url: String?): Connection? {
        return DriverManager.getConnection(url)
    }

    @Throws(SQLException::class)
    override fun acceptsURL(url: String?): Boolean {
        return false
    }

    @Throws(SQLException::class)
    override fun getPropertyInfo(url: String?, info: Properties?): Array<DriverPropertyInfo?>? {
        return arrayOfNulls(0)
    }

    override fun getMajorVersion(): Int {
        return 0
    }

    override fun getMinorVersion(): Int {
        return 0
    }

    override fun jdbcCompliant(): Boolean {
        return false
    }

    @Throws(SQLFeatureNotSupportedException::class)
    override fun getParentLogger(): Logger? {
        return null
    }
}