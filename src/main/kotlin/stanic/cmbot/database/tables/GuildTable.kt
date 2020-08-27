package stanic.cmbot.database.tables

import org.jetbrains.exposed.sql.Table

object GuildTable : Table("guild") {
    val id = text("id")
    val guild = text("guild")
}