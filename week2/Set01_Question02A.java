package week2;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

/**
 * @author kevin vu
 * @since Mar 19 20
 */
public class Set01_Question02A {

	// ASCII code of line feed character
	public static final int LINE_FEED = 10;

	public static void main(String[] args) {

		BufferedReader reader = null;
		CheckedOutputStream checkedOutput = null;
		PrintWriter printWriter = null;

		try {
			// Using buffer reader for efficiency when reading multiple lines
			reader = new BufferedReader(new InputStreamReader(System.in));
			checkedOutput = new CheckedOutputStream(new FileOutputStream("output.txt"), new CRC32());
			printWriter = new PrintWriter(new FileWriter("checksum.txt"));

			// Read in
			System.out.println("Input: ");
			boolean hasNext = true;
			while (hasNext) {
				String line = reader.readLine();
				if (line.equals("x")) {
					hasNext = false;
				} else {
					// Because checkedoutputstream can only read character by character
					char[] characters = line.toCharArray();
					for (char character : characters) {
						checkedOutput.write(character);
					}
					// Add the new line to the end of each line because readLine ommit the newline
					// character
					checkedOutput.write(LINE_FEED);
				}
			}

			printWriter.print(checkedOutput.getChecksum().getValue());

			checkedOutput.close();
			printWriter.close();

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
