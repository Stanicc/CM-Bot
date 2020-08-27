package stanic.cmbot.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database

open class MySQLConfig {
    open val hostname = "localhost"
    open val database = "cm-bot"
    open val username = "root"
    open val password = ""
}

class Database {

    fun start() {
        val config = MySQLConfig()

        val dataSource = HikariDataSource(HikariConfig().apply {
            jdbcUrl = "jdbc:mysql://${config.hostname}:3306/${config.database}"
            driverClassName = "com.mysql.jdbc.Driver"
            username = config.username
            password = config.password
        })

        Database.connect(dataSource)
    }

}