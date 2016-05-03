//import java.sql.Time;
import java.util.Scanner;

public class Main {
	

	
	
	public static String HourChange(String a, String b, String c) {
		String[] temp = a.split("\\.");
		String TimeString = temp[0];
		String Hour = TimeString.substring(0, 2);
		String Min = TimeString.substring(2, 4);
		String Sec = TimeString.substring(4, 6);
		String time = "";
		int unChangeTime = Integer.parseInt(Hour);
		unChangeTime=(unChangeTime+8)%24;
				if (unChangeTime < 10) {
					time = "0" + unChangeTime + ":" + Min + ":" + Sec;
				} else {
					time = unChangeTime + ":" + Min + ":" + Sec;
				}				

	

		return time;

	}

	// public static void main(String[] args) {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String a = "";
		String outPut = "";
		int countDown = 0;
		out: do {
			a = in.nextLine();
			if (a.contentEquals("END")) {
				break out;
			} else {

				String[] inputNumSer = a.split("\\,");
				String temp = "";
				if (inputNumSer[0].equals("$GPRMC") && inputNumSer[2].equals("A")) {

					for (int i = 1; i < inputNumSer.length; i++) {
						temp += inputNumSer[i];
					}

					String[] temp21 = temp.split("\\*");
					String temp2 = temp21[0];
					int cal = 0;
					cal ^= 'G';
					cal ^= 'P';
					cal ^= 'R';
					cal ^= 'M';
					cal ^= 'C';
					for (int k = 0; k < temp2.length(); k++) {
						cal ^= temp.charAt(k);
					}
					cal %= 65536;

					int cal2 = Integer.parseInt(temp21[1], 16);

					if (cal == cal2) {
						countDown++;
						outPut += HourChange(inputNumSer[1], inputNumSer[6], inputNumSer[7]);
					} else {
					}
				}
			}
		} while (!a.contentEquals("END"));
		//for (int i = 0; i < outPut.length(); i += 8) {
			System.out.println(outPut.substring(outPut.length()-8, outPut.length()));
		//}

	}
}