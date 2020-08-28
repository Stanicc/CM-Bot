package stanic.cmbot.guild

import stanic.cmbot.database.delete
import stanic.cmbot.database.load
import stanic.cmbot.database.save
import stanic.cmbot.factory.GuildFactory
import stanic.cmbot.guild.model.Guild

class GuildManager {

    fun getGuildByID(id: String): Guild? = GuildFactory.INSTANCE.guilds
        .values
        .stream()
        .filter { it.id == id }
        .findFirst().orElse(null)

    fun activeGuild(id: String): Boolean {
        if (getGuildByID(id) != null) return false

        val guild = Guild(null, id)
        GuildFactory.INSTANCE.guilds[id] = guild

        save(guild)
        return true
    }

    fun enableGuild(id: String): Boolean {
        if (getGuildByID(id) != null) return false

        val guild = load(id) ?: return false
        guild.enabled = true
        GuildFactory.INSTANCE.guilds[id] = guild

        return true
    }

    fun disableGuild(id: String): Boolean {
        if (getGuildByID(id) == null) return false

        getGuildByID(id)!!.enabled = false
        GuildFactory.INSTANCE.guilds.remove(id)
        return true
    }

    fun deleteGuild(id: String): Boolean {
        if (getGuildByID(id) == null) return false

        disableGuild(id)
        delete(id)
        return false
    }

}