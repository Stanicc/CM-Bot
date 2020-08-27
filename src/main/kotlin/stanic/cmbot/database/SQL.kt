@file:Suppress("IMPLICIT_CAST_TO_ANY")

package stanic.cmbot.database

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import stanic.cmbot.database.tables.GuildTable
import stanic.cmbot.guild.model.Guild

fun saveGuild(guildModel: Guild) = transaction {
    SchemaUtils.create(GuildTable)

    val guildSelected = GuildTable.select { GuildTable.id eq guildModel.id }.singleOrNull()

    if (guildSelected == null) GuildTable.insert {
        it[id] = guildModel.id
        it[guild] = Json.encodeToString(guildModel)
    }
    else GuildTable.update({ GuildTable.id eq guildModel.id }) {
        it[id] = guildModel.id
        it[guild] = Json.encodeToString(guildModel)
    }
}

fun loadGuilds(): HashMap<String, Guild> {
    val guilds = HashMap<String, Guild>()

    transaction {
        SchemaUtils.create(GuildTable)

        GuildTable.selectAll().map {
            guilds[it[GuildTable.id]] = Json.decodeFromString(it[GuildTable.guild])
        }
    }

    return guilds
}