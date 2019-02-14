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
		
		Boolean end = false;
		int i = 0; //position in products list
		int j = products.size();
		
		while (!end) {
			ProductID current = products.get(i);
			int x = i; //save start point
			while (i < j - 1) {
				ProductID next = products.get(i + 1);
				if (current.offByOne(next)) {
					end = true;
					System.out.println("first code: " + current.getCode());
					System.out.println("second code: " + next.getCode());
					char[] result = stripUnlikeChar(current,next);
					System.out.print("common chars: ");
					System.out.println(result);
					break;
				}
				
				
				i++;
			}
			
			i = x + 1; //restore start point
		}
		
		/*
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
		System.out.println("Checksum = " + checksum);*/
	}

	private static char[] stripUnlikeChar(ProductID current, ProductID next) {
		char[] original = current.getCharArr();
		char[] testing = next.getCharArr();
		int length = original.length;
		char[] res = new char[length-1];
		
		int i = 0;
		int j = 0;
		while (i < length) {
			if (original[i] == testing[i]) {
				res[j] = original[i];
				j++;
			}
			i++;
		}
		return res;
	}

}
