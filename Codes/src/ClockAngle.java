
public class ClockAngle {

	public static void main(String[] args) {
		//time tested 12:30
		System.out.println(angle(12, 30));
	}
	
	// h = 1..12, m = 0..59
	static double angle(int h, int m) {
	    double hAngle = 0.5D * (h * 60 + m);
	    double mAngle = 6 * m;
	    double angle = Math.abs(hAngle - mAngle);
	    angle = Math.min(angle, 360 - angle);
	    return angle;
	}
}
