package stanic.cmbot.guild.ticket.model

import stanic.cmbot.guild.model.Guild
import stanic.cmbot.guild.ticket.impl.TicketType
import kotlinx.serialization.Serializable
import net.dv8tion.jda.api.Permission
import stanic.cmbot.Main
import java.util.*
import kotlin.collections.ArrayList

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
        val category = guild.get().getCategoriesByName(type.getTypeName(), true).getOrNull(0) ?: guild.get().createCategory(type.getTypeName()).complete()

        channel = guild.get().createTextChannel("${type.getTypeName()}-${Main.INSTANCE.jda.getUserById(owner)?.name}")
            .addMemberPermissionOverride(Main.INSTANCE.jda.getUserById(owner)!!.idLong, EnumSet.of(Permission.VIEW_CHANNEL), null)
            .setParent(category)
            .complete().id
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