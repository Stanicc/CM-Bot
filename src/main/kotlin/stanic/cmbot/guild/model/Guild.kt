package stanic.cmbot.guild.model

import net.dv8tion.jda.api.entities.Guild
import stanic.cmbot.guild.impl.GuildImpl
import stanic.cmbot.service.License
import stanic.cmbot.service.LicenseManager
import java.io.File

class Guild(
    val file: File,
    private val guild: Guild
) : GuildImpl {

    override val id = guild.id
    override val license = LicenseManager().getLicense(id)

    fun get() = guild

}