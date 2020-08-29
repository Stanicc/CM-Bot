package stanic.cmbot.guild.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import stanic.cmbot.Main
import stanic.cmbot.guild.ticket.model.Ticket

@Serializable
class Guild(
    var fileLocation: String? = null,
    val id: String
) {

    @Transient var tickets = ArrayList<Ticket>()
    val users = ArrayList<String>()

    var enabled = true

    fun get() = Main.INSTANCE.jda.getGuildById(id)

}