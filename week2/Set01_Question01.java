package week2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * @author kevin vu
 * @since Mar 19 20
 */
public class Set01_Question01 {

	// ASCII code of space character, underscore, line feed character
	public static final int SPACE_CHARACTER = 32;
	public static final int UNDERSCORE_CHARACTER = 95;
	public static final int LINE_FEED = 10;

	public static void main(String[] args) {

		BufferedReader instr = null;
		OutputStream outstr = null;

		try {
			// Get and fileter console stream using BufferedReader
			instr = new BufferedReader(new InputStreamReader(System.in));
			// Redirect to console stream
			outstr = System.out;

			System.out.println("Input:");
			boolean hasNext = true;
			while (hasNext) {
				// Read in
				int character = instr.read();
				// Replace space with underscore
				if (character == SPACE_CHARACTER) {
					character = UNDERSCORE_CHARACTER;
				} else if (character == LINE_FEED) {
					hasNext = false;
				}
				// Write out
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