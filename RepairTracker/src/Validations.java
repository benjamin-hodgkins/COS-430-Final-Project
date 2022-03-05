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

	static public boolean inPutValidations(String mat, String total,
			String eng, String clock, String reason, String area) {
		// Check to see if values are blank
		if (mat.equals("") || total.equals("") || clock.equals("")
				|| eng.equals("") || reason.equals("") || area.equals("")) {
			JOptionPane
					.showMessageDialog(null,
							"Please Fill everything in or Use N/A if an Item needs to be blank.");

			return false;
		}
		// Making sure the values are alpha-Numeric Only. NO special characters
		if (p.matcher(eng).find() == false || p.matcher(clock).find() == false
				|| p.matcher(mat).find() == false) {
			JOptionPane
					.showMessageDialog(null,
							"Please use only alpha-Numeric Values only A(a)-Z(z) 0-9 or -.");
			return false;
		}
		return true;
	}

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
