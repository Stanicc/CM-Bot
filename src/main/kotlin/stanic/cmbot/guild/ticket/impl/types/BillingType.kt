package stanic.cmbot.guild.ticket.impl.types

import stanic.cmbot.guild.ticket.impl.TicketImpl

class Commission : TicketImpl {
    override val typeName = "Commission"
    override val category = "billing-cm"
}

class Chargeback : TicketImpl {
    override val typeName = "Chargeback"
    override val category = "billing-cb"
}