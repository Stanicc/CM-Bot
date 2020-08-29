package stanic.cmbot.factory

import stanic.cmbot.database.loadAll
import stanic.cmbot.guild.model.Guild

class GuildFactory {

    companion object {
        lateinit var INSTANCE: GuildFactory
    }

    fun start() {
        INSTANCE = this

        guilds = loadAll()
    }

    lateinit var guilds: HashMap<String, Guild>

}