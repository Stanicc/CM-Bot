package stanic.cmbot.database.tables

import org.jetbrains.exposed.sql.Table

object GuildTable : Table("guilds") {
    val id = text("id")
    val guild = text("guild")
    val tickets = text("tickets")
}