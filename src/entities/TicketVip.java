package entities;

import enums.TicketType;

public class TicketVip extends Ticket{

	public TicketVip () {
		super();
	}
	
	
	public TicketVip(Movie movie, TicketType ticketType, int session) {
		super(movie, ticketType, session);
		this.ticketTypeV = true;
	}

	@Override
	public String cafeteriaAccess() {
		return "Lanchonete do cinema liberada";
		
	}
	
}
