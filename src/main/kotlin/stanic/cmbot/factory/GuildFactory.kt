package stanic.cmbot.factory

import stanic.cmbot.guild.model.Guild

class GuildFactory {

    companion object {
        lateinit var INSTANCE: GuildFactory
    }

    fun start() {
        INSTANCE = this
    }

    val guilds = HashMap<String, Guild>()

}