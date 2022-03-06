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

		if (uName.equals("") && uPassword.equals("")) {

			return 1;
		}
		if(uName.equals("") || !uPassword.equals("")) {
			return 2;
		}
		if(!uName.equals("") || uPassword.equals("")) {
			return 3;
		}

		return 0;
	}

}
