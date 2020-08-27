package stanic.cmbot.factory

import stanic.cmbot.database.loadGuilds
import stanic.cmbot.guild.model.Guild

class GuildFactory {

    companion object {
        lateinit var INSTANCE: GuildFactory
    }

    fun start() {
        INSTANCE = this

        guilds = loadGuilds()
    }

    lateinit var guilds: HashMap<String, Guild>

}