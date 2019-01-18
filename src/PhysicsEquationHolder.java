
public class PhysicsEquationHolder {
	// Equations'
	// keplersPeriodTime,keplersPeriodMass
	public static void keplersPeriodMass() {
		System.out.println("Calculating Mass for orbit PLEASE ENTER \n RADIUS(m) TIME(seconds)");
		double rad = Physics.getNum();
		double time = Physics.getNum();
		double result = keplersPeriodMassCalc(rad, time);
		Physics.ans = result;
		System.out.println("Mass " + result + " kg \n");
		Physics.finishFunc();
	}

	private static double keplersPeriodMassCalc(double r, double t) {
		return 1 / (t * t * Physics.G) / (4 * Math.PI * Math.PI * Math.pow(r, 3));
	}

	public static void keplersPeriodTime() {
		System.out.println("Calculating Orbital time \n Please Enter \n RADIUS MASS");
		double rad = Physics.getNum();
		double mass = Physics.getNum();
		double result = keplersPeriodTimeCalc(rad, mass);
		Physics.ans = result;
		System.out.println("Time = " + result + " seconds \n");
		System.out.println(Physics.convertTime(result));
		Physics.finishFunc();
	}

	private static double keplersPeriodTimeCalc(double r, double m) {
		return Math.sqrt(4 * Math.PI * Math.PI * Math.pow(r, 3) / (m * Physics.G));
	}

	public static void chargedRod() {
		System.out.println(
				"Calculating force on a charged rod -    | \n Please Enter \n DISTANCE LENGTH RODCHARGE POINTCHARGE");
		double dist = Physics.getNum();
		double length = Physics.getNum();
		double chargeRod = Physics.getNum();
		double chargePoint = Physics.getNum();
		double result = chargedRodCalc(dist, length, chargeRod, chargePoint);
		Physics.ans = result;
		System.out.println("Force = " + result + "N");
		Physics.finishFunc();

	}

	private static double chargedRodCalc(double d, double l, double cR, double cP) {
		return (cR * cP * d) / (Math.pow(d * d + l * l, 1.5));
	}
}