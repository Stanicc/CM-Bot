package stanic.cmbot.guild.ticket.impl.types

import stanic.cmbot.guild.ticket.impl.TicketType

class Commission : TicketType {
    override val typeName = "Commission"
    override val category = "billing-cm"
}

class Chargeback : TicketType {
    override val typeName = "Chargeback"
    override val category = "billing-cb"
}