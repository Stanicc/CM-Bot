package stanic.cmbot.guild.impl

import stanic.cmbot.service.License

interface GuildImpl {
    val id: String
    val license: License
}