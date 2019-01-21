import java.util.Arrays;
import java.util.Scanner;

public class Physics {
	static Scanner sc;
	static String kepTime = "keplersPeriodTime";
	static String kepMass = "keplersPeriodMass";
	static String chargedRod = "chargedRod";
	static String kinematicTime = "kineMaticTime";
	static String[] eqlist = { kepTime, kepMass, chargedRod };
	static double ans;
//Constants
	static final double G = 6.673 * Math.pow(10, -11);

// Selects the final function to execute 
	private static void selectFunction(String eqName) {
		eqName = eqName.toUpperCase();
		System.out.println("You Chose : " + eqName);
		if (kepTime.toUpperCase().contains(eqName)) {
			PhysicsEquationHolder.keplersPeriodTime();
		}
		if (kepMass.toUpperCase().contains(eqName)) {
			PhysicsEquationHolder.keplersPeriodMass();
		}
		if (chargedRod.toUpperCase().contains(eqName)) {
			PhysicsEquationHolder.chargedRod();
		}
	}
//Start of program

	public static void main(String[] args) {
		System.out.println("Please type an Equation");
		sc = new Scanner(System.in);
		String input = "";
		System.out.println("Availible Functions : \n");
		while (true) {
			input = sc.nextLine();
			process(input, eqlist);
		}
	}

	private static void process(String input, String[] activeList) {
		int nNum = 0;
		String newList[] = new String[activeList.length];
		if (input.toLowerCase().equals("back") || input.equals("")) {
			System.out.println("Please enter a NEW search HEWRE");
			input = sc.nextLine();
			process(input, eqlist);
		}
		if (input.toLowerCase().equals("exit")) {
			System.exit(0);
		}
		for (int i = 0; i < activeList.length; i++) {
			if (activeList[i].toLowerCase().contains(input.toLowerCase())) {
				System.out.println("FOund : " + activeList[i]);
				newList[nNum] = activeList[i];
				nNum++;
			}
		}
		newList = Arrays.copyOf(newList, nNum);
		if (nNum == 1) {
			System.out.println("DEV : choosing function named : " + newList[0]);
			selectFunction(newList[0]);
		}
		if (nNum == 0) {
			System.out.println("Please Enter a New Search: NOTHING WAS FOUND");
			process(sc.next(), eqlist);
		}
		System.out.println("Enter more accurate search");
		process(sc.next(), newList);
	}

	static void finishFunc() {
		System.out.println("Please enter a new Equation or exit to QUIT");
		process(sc.next(), eqlist);

	}

	public static double getNum() {
		String num = sc.next();
		if (num.toLowerCase().equals("ans")) {
			return ans;
		}
		return Double.parseDouble(num);
	}

	static String convertTime(double result) {
		String ret = result / 60 + " minutes \n";
		ret += result / 3600 + " hours \n";
		ret += result / 3600 / 24 + " days \n";
		ret += result / 3600 / 24 / 365.25 + " years \n";
		return ret;
	}
}
