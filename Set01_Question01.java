import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * @author kevin vu
 * @since Mar 19 20
 */
public class Set01_Question01 {
	// ASCII code of space character and underscore character
	public static final int SPACE_CHARACTER = 32;
	public static final int UNDERSCORE_CHARACTER = 95;

	public static void main(String[] args) {

		InputStream instr = new BufferedInputStream(System.in);
		OutputStream outstr = new BufferedOutputStream(System.out);

		// Use ArrayList as data structure because the length of the input stream is
		// unknown initially.
		// Integer because InputStream, OutputStream is integer in java8
		ArrayList<Integer> input = new ArrayList<Integer>();

		try {
			System.out.print("Input: ");

			// Read in
			do {
				input.add(instr.read());
			} while (instr.available() > 0);

			System.out.print("Output: ");

			// Replace and Write out
			for (Integer character : input) {
				if (character == SPACE_CHARACTER)
					character = UNDERSCORE_CHARACTER;
				outstr.write(character);
			}

			// "Flushes this output stream and forces any buffered output bytes to be
			// written out."
			outstr.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
