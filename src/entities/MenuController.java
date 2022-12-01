package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import enums.TicketType;

public class MenuController {
	
	Scanner sc = new Scanner(System.in);
	
	Movie adaoNegro = new Movie("Adão Negro", "Jaume Collet-Serra", "Adão Negro é o filme solo do anti-herói, baseado no personagem em quadrinhos Black Adam (Dwayne Johnson) da DC Comics.", "Ação Fantasia", "02:05");
	Movie onePieceRed = new Movie("One Piece - Red", "Gorō Taniguchi", "Em ONE PIECE FILM RED todos conhecerão Uta, a cantora mais amada do planeta,", "Fantasia Aventura", "01:55");
	Movie aOrfa2 = new Movie("A Órfã 2", "William Brent Bell", "Continuação do primeiro filme", "Terror Drama", "1:39");
	Movie invalid = new Movie("Inválido", "Inválido", "Inválido", "Inválido", "Inválido");
	
	
	private List<Ticket> tickets = new ArrayList<>();
	
	public Movie selectMovie() {
		System.out.println("------------------");
		System.out.println("SELECIONE O FILME");
		System.out.println("[1]Adao Negro");
		System.out.println("[2]One Piece Red");
		System.out.println("[3]A Órfã 2");
		System.out.println("[0]Finalizar");
		System.out.println("------------------");
		int movie = sc.nextInt();
		if (movie == 1) return adaoNegro;
		if (movie == 2) return onePieceRed;
		if (movie == 3) return aOrfa2;
		if (movie == 0) return invalid;
		else return invalid;
	}
	
	public void buyTicket(Movie movie) {
		
		System.out.println("------------------");
		System.out.println("SELECIONE A SESSÃO");
		System.out.println("[1]12:00");
		System.out.println("[2]15:00");
		System.out.println("[3]18:00");
		System.out.println("------------------");
		int session = sc.nextInt();
		System.out.print("Quantos ingressos serão comprados? ");
		int quantityOfTicket = sc.nextInt();
		for (int i = 0; i <quantityOfTicket; i++) {
			System.out.printf("DADOS INGRESSO #%d\n", i+1);
			System.out.print("TIPO DO INGRESSO [Inteira/Meia]: ");
			String typeOfTicket = sc.next();
			while (!typeOfTicket.equals("Inteira") && !typeOfTicket.equals("Meia")) {
				System.out.print("TIPO DO INGRESSO [Inteira/Meia]: ");
				typeOfTicket = sc.next();
			}
			
			System.out.print("TIPO DO INGRESSO [Vip/Comum]: ");
			String typeOfTicketV = sc.next();
			while (!typeOfTicketV.equals("Vip") && !typeOfTicketV.equals("Comum")) {
				System.out.print("TIPO DO INGRESSO [Vip/Comum]: ");
				typeOfTicketV = sc.next();
			}
			
		
			System.out.print("FILME 3D? [s/n]: ");
			char is3D = sc.next().charAt(0);
			while (is3D != 's' && is3D != 'n' ) {
				System.out.print("FILME 3D? [s/n]: ");
				is3D = sc.next().charAt(0);
			}
			
			if (is3D == 's') {
				if (typeOfTicketV.equals("Comum")) {
					System.out.print("ACESSO NEGADO | APENAS TICKETS VIPS | FILME COMUM SELECIONADO");
					Ticket ticket = new Ticket(movie, TicketType.valueOf(typeOfTicket), session);
					System.out.println();
					System.out.println("Situação da lanchonete: " + ticket.cafeteriaAccess());
					tickets.add(ticket);
				}
				if (typeOfTicketV.equals("Vip")) {
					movie.setThreeDFilm(true);
					Ticket ticket = new TicketVip(movie, TicketType.valueOf(typeOfTicket), session);
					this.tickets.add(ticket);
					System.out.println();
					System.out.println("Situação da lanchonete: " + ticket.cafeteriaAccess());
				}
			}
			if (is3D == 'n') {
				if (typeOfTicketV.equals("Comum")) {
					Ticket ticket = new Ticket(movie, TicketType.valueOf(typeOfTicket), session);
					System.out.println();
					System.out.println("Situação da lanchonete: " + ticket.cafeteriaAccess());
					this.tickets.add(ticket);
				}
				if (typeOfTicketV.equals("Vip")) {
					Ticket ticket = new TicketVip(movie, TicketType.valueOf(typeOfTicket), session);
					System.out.println();
					System.out.println("Situação da lanchonete: " + ticket.cafeteriaAccess());
					tickets.add(ticket);
				}
			}
		}
	}
	
	public double result() {
		double sum = 0;
		for (Ticket ticket : tickets) {
			if (ticket.getTicketTypeV() == true && ticket.getTicketType() == TicketType.Meia) sum += 24;
			if (ticket.getTicketTypeV() == true && ticket.getTicketType() == TicketType.Inteira) sum += 48;
			if (ticket.getTicketTypeV() == false && ticket.getTicketType() == TicketType.Meia) sum += 12;
			if (ticket.getTicketTypeV() == false && ticket.getTicketType() == TicketType.Inteira) sum += 24;
		}
		return sum;
	}
}
