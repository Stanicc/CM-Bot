package stanic.cmbot.guild.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import stanic.cmbot.Main
import stanic.cmbot.guild.ticket.model.Ticket
import stanic.cmbot.service.LicenseManager

@Serializable
class Guild(
    val fileLocation: String? = null,
    val id: String
) {

    @Transient var tickets = ArrayList<Ticket>()
    val users = ArrayList<String>()

    val license = LicenseManager().getLicense(id)

    fun get() = Main.INSTANCE.jda.getGuildById(id)

}