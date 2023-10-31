public class Main {

     public static void main(String[] args) {
        var cFrame = new CaesarFrame();
        cFrame.setVisible(true);  
     }

     public static String caesarCode(String input, char offset) {
		char[] out = input.toUpperCase().toCharArray();
		for (int i = 0; i < out.length; i++) {
			out[i] += offset - 'A';
			if (out[i] > 'Z')
				out[i] -= 'Z' - 'A' + 1;
		}
		return new String(out);
	}
}