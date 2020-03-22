package week2;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;

/**
 * @author kevin vu
 * @since Mar 19 20
 */
public class Set01_Question02B {

	public static void main(String[] args) {

		CheckedInputStream checkedInput = null;
		FileInputStream fileInput = null;

		try {
			checkedInput = new CheckedInputStream(new FileInputStream("output.txt"), new CRC32());
			fileInput = new FileInputStream("checksum.txt");

			while (checkedInput.available() > 0) {
				// Converting int to char dynamically
				System.out.print((char) checkedInput.read());
			}
			// Write the checksum calculated from the input
			System.out.println("\nChecksum calculated: " + checkedInput.getChecksum().getValue());

			// Write the checksum from file
			System.out.print("\nChecksum from file: ");
			while (fileInput.available() > 0) {
				System.out.print((char) fileInput.read());
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

}
