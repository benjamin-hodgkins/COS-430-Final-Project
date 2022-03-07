import java.util.regex.Pattern;

import javax.swing.JOptionPane;

/*
 * 
 * 
 * 
 * 
 */

public class Validations {

	static Pattern userNamePattern = Pattern.compile("^[A-Za-z0-9-]*$");
	static Pattern passwordPattern = Pattern.compile("^[A-Za-z0-9!@#$%&*()_+=|<>?{}\\\\[\\\\]~-]*$");

	static public boolean inPutValidations(String mat, String total,
			String eng, String clock, String reason, String area) {
		// Check to see if values are blank. This is recycled from an old project I completed. The Names will change once a new user interface is designed.
		if (mat.equals("") || total.equals("") || clock.equals("")
				|| eng.equals("") || reason.equals("") || area.equals("")) {
			JOptionPane
					.showMessageDialog(null,
							"Please Fill everything in or Use N/A if an Item needs to be blank.");

			return false;
		}
		// Making sure the values are alpha-Numeric Only. NO special characters
		if (userNamePattern.matcher(eng).find() == false || userNamePattern.matcher(clock).find() == false
				|| userNamePattern.matcher(mat).find() == false) {
			JOptionPane
					.showMessageDialog(null,
							"Please use only alpha-Numeric Values only A(a)-Z(z) 0-9 or -.");
			return false;
		}
		return true;
	}

	static public int userLoggingCheck(String uName, String uPassword) {
		//Will be used when a new user creates account
		Pattern secondaryPasswordCheck = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])((?<!" + Pattern.quote(uName) + ").(?!" + Pattern.quote(uName) + ")){8,}");

		if (uName.equals("") && uPassword.equals("")) {

			return 1;
		}
		if(uName.equals("") && !uPassword.equals("")) {
			return 2;
		}
		if(!uName.equals("") && uPassword.equals("")) {
			return 3;
		}
		if (userNamePattern.matcher(uName).find() == false || passwordPattern.matcher(uPassword).find() == false){
			return 4;
		}	
		if(secondaryPasswordCheck.matcher(uPassword).find() == false) {
			return 5;
		}
		return 0;
	}


}
