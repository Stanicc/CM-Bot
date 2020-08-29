package stanic.cmbot.guild.ticket

import stanic.cmbot.guild.model.Guild
import stanic.cmbot.guild.ticket.model.Ticket

class TicketManager {

    fun getTicketByID(guild: Guild, id: String): Ticket? = guild.tickets
        .filter { it.id == id }
        .getOrNull(0)

}