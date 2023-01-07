package com.func;

public class FunctionSummary {

	public static boolean checkOperant(String op) {
		if (op.equals("*") || op.equals("+") || op.equals("-") || op.equals("") || op.equals("/"))
			return true;
		return false;
	}

	/**
	 * Eingabe prüfen ob sie ein Numerischer Wert ist => zu erst alle Decimal
	 * Trennzeichen entfernen falls vorhanden danach jeden einzelnen Char prüfen ob
	 * er ein Digit ist
	 * 
	 * @param nextLine
	 *            => Eingabe einer eventuellen Zahl über die Konsole
	 * @return
	 */
	public static boolean isInputNumeric(String nextLine) {
		String inputWithoutDecimal = stringWithoutDecimalSymbol(nextLine);

		for (char c : inputWithoutDecimal.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}

	public static Double getDoubleFromString(String input) {
		return Double.parseDouble(replaceDecimalSymbolForDouble(input));
	}

	private static String stringWithoutDecimalSymbol(String nextLine) {
		String inputWithoutDecimal = nextLine;
		if (nextLine.contains(",") || nextLine.contains(".")) {
			inputWithoutDecimal = inputWithoutDecimal.replace('.', ' ');
			inputWithoutDecimal = inputWithoutDecimal.replace(',', ' ');
			inputWithoutDecimal = inputWithoutDecimal.replaceAll(" ", "");
		}
		return inputWithoutDecimal;
	}

	private static String replaceDecimalSymbolForDouble(String nextLine) {
		String inputWithoutDecimal = nextLine;
		if (nextLine.contains(","))
			inputWithoutDecimal = inputWithoutDecimal.replace(',', '.');
		return inputWithoutDecimal;
	}
}
