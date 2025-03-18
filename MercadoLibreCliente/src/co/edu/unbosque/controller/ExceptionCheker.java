package co.edu.unbosque.controller;

import co.edu.unbosque.util.exception.CapitalException;
import co.edu.unbosque.util.exception.CharacterException;
import co.edu.unbosque.util.exception.EqualPasswordException;
import co.edu.unbosque.util.exception.NumberException;
import co.edu.unbosque.util.exception.SymbolException;
import co.edu.unbosque.util.exception.SmallException;

public class ExceptionCheker {

	public static void checkerPasword(String a)
			throws CapitalException, CharacterException, NumberException, SymbolException, SmallException {
		checkerCapital(a);
		checkerCharacter(a);
		checkerNumber(a);
		checkerSymbol(a);
		checkerSmall(a);

	}

	public static void checkerCharacter(String a) throws CharacterException {
		if (a.length() < 8) {
			throw new CharacterException();
		}
	}

	public static void checkerEqualPassword(String a, String b) throws EqualPasswordException {
		if (!a.equals(b)) {
			throw new EqualPasswordException();
		}
	}

	public static void checkerCapital(String a) throws CapitalException {
		if (!a.matches(".*[A-Z].*")) {
			throw new CapitalException();
		}
	}

	public static void checkerSmall(String a) throws SmallException {
		if (!a.matches(".*[a-z].*")) {
			throw new SmallException();
		}
	}

	public static void checkerNumber(String a) throws NumberException {

		if (!a.matches(".*\\d.*")) {
			throw new NumberException();
		}
	}

	public static void checkerSymbol(String a) throws SymbolException {

		if (!a.matches(".*[^A-Za-z0-9].*")) {
			throw new SymbolException();
		}
	}

}
