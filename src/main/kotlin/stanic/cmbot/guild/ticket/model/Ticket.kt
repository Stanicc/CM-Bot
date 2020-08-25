package stanic.cmbot.guild.ticket.model

import stanic.cmbot.guild.model.Guild
import stanic.cmbot.guild.ticket.impl.TicketImpl

class Ticket(
    val type: TicketImpl,
    val guild: Guild,
    val id: Int,
    val owner: String,
    val members: ArrayList<Members>
) {

    lateinit var channel: String

    fun create() {
        //Create ticket
    }

    fun close() {
        //Close ticket
    }

    fun delete() {
        //Delete ticket
    }

    class Members(
        val manager: Boolean,
        val id: String
    )

}