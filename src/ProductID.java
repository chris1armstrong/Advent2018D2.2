
public class ProductID {
	
	private int[] characters;
	private String code;
	private char[] charArr;
	
	
	public ProductID(String code) {
		this.characters = countChars(code);
		this.code = code;
		this.charArr = code.toCharArray();
	}

	private int[] countChars(String code) {
		int[] chars = new int[26];
		int length = code.length();
		int i = 0;
		while (i < length) {
			chars[code.charAt(i) - 'a']++;
			i++;
		}
		
		return chars;
	}
	
	public Boolean getNumConsecutive(int length) {
		Boolean ret = false;
		for (int i : this.characters) {
			if (i == length) {
				ret = true;
			}
		}
		return ret;
	}

	public String getCode() {
		return code;
	}
	
	public char[] getCharArr() {
		return charArr;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean offByOne(ProductID next) {
		Boolean ret = false;
		int count = 0;
		char[] original = this.getCharArr();
		char[] testing = next.getCharArr();
		int length = original.length;
		int i = 0;
		while (count <= 1 && i < length) {
			if (original[i] != testing[i]) {
				count++;
			}
			i++;
		}
		if (count <= 1) {
			ret = true;
		}
		return ret;
	}
}
