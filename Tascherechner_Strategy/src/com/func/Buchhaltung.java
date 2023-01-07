package com.func;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.func.FunctionSummary;
import com.src.Calculator;


public class Buchhaltung {

	public static void main(String... args) {

		Scanner sc = new Scanner(System.in);
		boolean eingabeState = false;
		String operant = null;
		/**
		 * Eingabe des Rechenzeichen => wird solange Wiederholt bis Eingabe ein
		 * korrektes Rechenzeichen ist
		 */
		do {
			System.out.println("Bitte geben Sie eines der nachfolgenden Rechen Zeichen ein \n + | - | * | /");
			operant = sc.nextLine();
			if (!FunctionSummary.checkOperant(operant)) {
				System.out.println("Ihre Eingabe war leider nicht korrekt!");
				eingabeState = true;
			}
		} while (eingabeState);

		eingabeState = false;
		System.out
				.println("Danke für ihre Eingabe!\nBitte geben Sie nun ihre 2 zu brechnenden Zahlen nacheinander ein");

		/**
		 * Prüfen der Eingabe => Sind beide Zahlen ein Numerischer Wert?
		 */
		String input = null;
		List<Double> numbers = new ArrayList();
		for (int i = 0; i < 2;) {
			System.out.printf("Bitte geben sie ihre %s Zahle ein: ", i == 0 ? "erste" : "zweite");
			do {
				input = sc.nextLine();
				eingabeState = FunctionSummary.isInputNumeric(input);
				if (!eingabeState)
					System.out.println("Ihre Eingabe war leider nicht korrekt\nBitte nochmal!");
			} while (!eingabeState);
			numbers.add(FunctionSummary.getDoubleFromString(input));
			i++;
		}

		Calculator c = new Calculator(numbers, operant);
		System.out.println(c.cal());
	}
}
