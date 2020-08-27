package stanic.cmbot.guild.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import net.dv8tion.jda.api.entities.Guild
import stanic.cmbot.guild.impl.GuildImpl
import stanic.cmbot.guild.ticket.model.Ticket
import stanic.cmbot.service.LicenseManager
import java.io.File

@Serializable
data class Guild(
    @Contextual val file: File,
    private val guild: Guild
) : GuildImpl {

    val tickets = ArrayList<@Contextual Ticket>()
    val users = ArrayList<String>()

    override val id = guild.id
    override val license = LicenseManager().getLicense(id)

    fun get() = guild

}