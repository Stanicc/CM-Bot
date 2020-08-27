package stanic.cmbot.guild.ticket.model

import stanic.cmbot.guild.model.Guild
import stanic.cmbot.guild.ticket.impl.TicketType
import kotlinx.serialization.Serializable

@Serializable
class Ticket(
    val type: TicketType,
    val guild: Guild,
    val id: String,
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

    @Serializable
    class Members(
        val manager: Boolean,
        val id: String
    )

}