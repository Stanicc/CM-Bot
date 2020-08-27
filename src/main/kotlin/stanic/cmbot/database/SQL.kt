@file:Suppress("IMPLICIT_CAST_TO_ANY")

package stanic.cmbot.database

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import stanic.cmbot.database.tables.GuildTable
import stanic.cmbot.factory.GuildFactory
import stanic.cmbot.guild.model.Guild
import java.util.stream.Collectors

fun save(guildModel: Guild) = transaction {
    SchemaUtils.create(GuildTable)

    val guildSelected = GuildTable.select { GuildTable.id eq guildModel.id }.singleOrNull()

    if (guildSelected == null) GuildTable.insert {
        it[id] = guildModel.id
        it[guild] = Json.encodeToString(guildModel)
        it[tickets] = Json.encodeToString(guildModel.tickets)
    }
    else GuildTable.update({ GuildTable.id eq guildModel.id }) {
        it[id] = guildModel.id
        it[guild] = Json.encodeToString(guildModel)
        it[tickets] = Json.encodeToString(guildModel.tickets)
    }
}

fun loadGuilds(): HashMap<String, Guild> {
    val guilds = HashMap<String, Guild>()

    transaction {
        SchemaUtils.create(GuildTable)

        GuildTable.selectAll().map {
            val guild = Json.decodeFromString(Guild.serializer(), it[GuildTable.guild])
            guild.tickets = Json.decodeFromString(it[GuildTable.tickets])

            guilds[it[GuildTable.id]] = guild
        }
    }

    return guilds
}

fun saveAll() = transaction {
    SchemaUtils.create(GuildTable)

    for (guildModel in GuildFactory.INSTANCE.guilds.values.stream().collect(Collectors.toList())) {
        val guildSelected = GuildTable.select { GuildTable.id eq guildModel.id }.singleOrNull()

        if (guildSelected == null) GuildTable.insert {
            it[id] = guildModel.id
            it[guild] = Json.encodeToString(guildModel)
            it[tickets] = Json.encodeToString(guildModel.tickets)
        }
        else GuildTable.update({ GuildTable.id eq guildModel.id }) {
            it[id] = guildModel.id
            it[guild] = Json.encodeToString(guildModel)
            it[tickets] = Json.encodeToString(guildModel.tickets)
        }
    }
}