package entities;

import enums.TicketType;

public class Ticket {
	
	private Movie movie;
	private TicketType ticketType;
	protected boolean ticketTypeV;
	private String session;
	
	public Ticket () {
		
	}
	
	public Ticket(Movie movie, TicketType ticketType, int session) {
		this.movie = movie;
		this.ticketType = ticketType;
		this.ticketTypeV = false;
		
		if (session == 1) this.session = "12:00";
		if (session == 2) this.session = "15:00";
		if (session == 3) this.session = "18:00";
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}
	
	public boolean getTicketTypeV() {
		return this.ticketTypeV;
	}
	
	public String cafeteriaAccess() {
		return "Compre um igresso VIP";
		
	}
	
	
}
