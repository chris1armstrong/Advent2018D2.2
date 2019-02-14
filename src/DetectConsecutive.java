import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DetectConsecutive {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File f = new File(args[0]);
		ArrayList<ProductID> products = new ArrayList<ProductID>();
		Scanner scan = new Scanner(f);
		
		while (scan.hasNext()) {
			ProductID prod = new ProductID(scan.next());
			products.add(prod);
		}
		
		scan.close();
		
		int consec2 = 0;
		int consec3 = 0;
		for (ProductID p : products) {
			if (p.getNumConsecutive(2)) {
				consec2++;
			}
			if (p.getNumConsecutive(3)) {
				consec3++;
			}
		}
		
		System.out.println("2 consecutive: " + consec2);
		System.out.println("3 consecutive: " + consec3);
		
		int checksum = consec2 * consec3;
		System.out.println("Checksum = " + checksum);
	}

}
