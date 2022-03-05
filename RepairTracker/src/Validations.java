import java.util.regex.Pattern;

import javax.swing.JOptionPane;

/*
 * 
 * 
 * 
 * 
 */

public class Validations {

	static Pattern p = Pattern.compile("^[A-Za-z0-9-]*$");

	
	static public int userLoggingCheck(String uName, String uPassword) {

		if (uName.equals("") || uPassword.equals("")) {

			return 2;
		}
		if (uName.contains("z") || uName.contains("Z")) {

			return 1;
		}
		return 9;
	}

}
