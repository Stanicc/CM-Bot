package stanic.cmbot.guild.ticket.impl

import stanic.cmbot.guild.ticket.impl.types.*

enum class TicketImpl constructor(
    val type: TicketType
) {

    SUPPORT(Support()),
    COMMISSION(Commission()),
    CHARGEBACK(Chargeback()),
    APPEAL(Appeal()),
    APPLICATION(Application());

    override fun toString(): String {
        return type.typeName
    }

    fun getCategory() = type.category
    fun getTypeName() = type.typeName

    companion object {
        fun getFromString(type: String): TicketImpl? = values().filter { it.type.typeName == type }.getOrNull(0)
    }

}

interface TicketType {
    val typeName: String

    /**
     * Categories:
     * Billing, Support, Appeal & Application
     */
    val category: String
}