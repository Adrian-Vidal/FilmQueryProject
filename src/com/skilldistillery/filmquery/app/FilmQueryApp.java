package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
//		app.test2();
//		app.test3();
		app.launch();
		
	}

//	private void test() {
//		Film film = db.findFilmById(1);
//		System.out.println(film);
//	}
//
//	private void test2() {
//		Actor actor = db.findActorById(1);
//		System.out.println(actor);
//	}
//	
//	private void test3() {
//		List<Actor> actors = db.findActorsByFilmId(1);
//		System.out.println(actors);
//	}

	

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		
		do {
			
			System.out.println("=============================================================================\n"
					+ "||									   ||\n"
					+ "||  Welcome to the Film Query App, please select an option from the menu:  ||\n"
					+ "||\t\t\t1.) Look up a film by its ID			   ||\n"
					+ "||\t\t\t2.) Look up a film by a search word		   ||\n"
					+ "||\t\t\t3.) Exit the application			   ||\n"
					+ "||								  	   ||\n"
					+ "=============================================================================\n");
			
			int userInput = input.nextInt();
			if (userInput == 1) {
				System.out.println("\nPlease enter the ID number of the film you would like to view:\n");
					int userIdSelection = input.nextInt();
					Film film = db.findFilmById(userIdSelection);
					System.out.println("\n" + film + "\n");					
			} else if (userInput == 2) {
				System.out.println("\nUse keywords to search for a movie title");
				String userIdSelection = input.next();
				List<Film> film = db.findFilmByKeyword(userIdSelection);
				System.out.println("\n" + film + "\n");
				
			} else if (userInput == 3) {
				System.out.println("\n...[Application terminated]\n\n"
						+ "Thank you for using the Film Query App!");
				return;
			}
			
		} while (input != null);
		// TODO
		// do-while loop:
		// Get User Choice
		// Call DAO methods to get data
		// Display results
	}

}
