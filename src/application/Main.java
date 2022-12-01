package application;


import entities.MenuController;
import entities.Movie;

public class Main {

	public static void main(String[] args) {
		MenuController menu = new MenuController();
		while (true) {
			Movie movie = menu.selectMovie();
			if (movie.getName() == "Inválido") break;
			menu.buyTicket(movie);
		}
		System.out.print("\n");
		System.out.printf("Total a pagar: R$ %.2f", menu.result());
	}
	
}
