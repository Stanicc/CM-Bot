package stanic.cmbot.guild

import stanic.cmbot.factory.GuildFactory
import stanic.cmbot.guild.model.Guild

class GuildManager {

    fun getGuildByID(id: String): Guild? = GuildFactory.INSTANCE.guilds
        .values
        .stream()
        .filter { it.id == id }
        .findFirst().orElse(null)

}