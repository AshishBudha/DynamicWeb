package controller.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DonorsModel;
import model.LoginModel;
import model.ModelBloodCentre;
import model.PasswordEncryptionWithAes;
import model.PatientsModel;
import utils.StringUtils;

public class DBController {

	/**
	 * Establishes a connection to the database using pre-defined credentials and
	 * driver information.
	 * 
	 * @return A `Connection` object representing the established connection to the
	 *         database.
	 * @throws SQLException           if a database access error occurs.
	 * @throws ClassNotFoundException if the JDBC driver class is not found.
	 */
	public Connection getConnection() throws SQLException, ClassNotFoundException {

		// Load the JDBC driver class specified by the StringUtils.DRIVER_NAME constant
		Class.forName(StringUtils.DRIVER_NAME);

		// Create a connection to the database using the provided credentials
		return DriverManager.getConnection(StringUtils.LOCALHOST_URL, StringUtils.LOCALHOST_USERNAME,
				StringUtils.LOCALHOST_PASSWORD);
	}

	/**
	 * This method attempts to register a new student in the database.
	 * 
	 * @param student A `StudentModel` object containing the student's information.
	 * @return An integer value indicating the registration status: - 1:
	 *         Registration successful - 0: Registration failed (no rows affected) -
	 *         -1: Internal error (e.g., ClassNotFound or SQLException)
	 * @throws SQLException           if a database access error occurs.
	 * @throws ClassNotFoundException if the JDBC driver class is not found.
	 */
	public int registerDonor(DonorsModel donor) {

		try {
			// Prepare a statement using the predefined query for student registration
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_REGISTER_DONOR);

			// Set the student information in the prepared statement
			stmt.setString(1, donor.getFirst_name());
			stmt.setString(2, donor.getLast_name());
			stmt.setDate(3, Date.valueOf(donor.getBirthday()));
			stmt.setString(4, donor.getUsername());
			stmt.setString(5, PasswordEncryptionWithAes.encrypt(donor.getUsername(), donor.getPassword()));
			stmt.setString(6,donor.getEmail());
			stmt.setString(7, donor.getCity());
			stmt.setString(8, donor.getBlood_type());
			stmt.setString(9, donor.getDisease());

			// Execute the update statement and store the number of affected rows
			int result = stmt.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (result > 0) {
				return 1; // Registration successful
			} else {
				return 0; // Registration failed (no rows affected)
			}

		} catch (ClassNotFoundException | SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1; // Internal error
		}
	}
	
	public int registerPatient(PatientsModel patient) 
	{
		try {
			// Prepare a statement using the predefined query for student registration
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_REGISTER_PATIENT);

			// Set the student information in the prepared statement
			stmt.setString(1, patient.getFirst_name());
			stmt.setString(2, patient.getLast_name());
			stmt.setDate(3, Date.valueOf(patient.getBirthday()));
			stmt.setString(4, patient.getUsername());
			stmt.setString(5, PasswordEncryptionWithAes.encrypt(patient.getUsername(), patient.getPassword()));
			stmt.setString(6,patient.getEmail());
			stmt.setString(7, patient.getCity());
			stmt.setString(8, patient.getBlood_type());
			stmt.setString(9, patient.getBlood_centre());

			// Execute the update statement and store the number of affected rows
			int result = stmt.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (result > 0) {
				return 1; // Registration successful
			} else {
				return 0; // Registration failed (no rows affected)
			}

		} catch (ClassNotFoundException | SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1; // Internal error
		}
	}	
	
	
	/**
	 * This method attempts to validate a student login by checking the username and
	 * password against a database.
	 * 
	 * @param username The username provided by the user attempting to log in.
	 * @param password The password provided by the user attempting to log in.
	 * @return An integer value indicating the login status: - 1: Login successful -
	 *         0: Username or password mismatch - -1: Username not found in the
	 *         database - -2: Internal error (e.g., SQL or ClassNotFound exceptions)
	 * @throws SQLException           if a database access error occurs.
	 * @throws ClassNotFoundException if the JDBC driver class is not found.
	 */
	
	public int getDonorLoginInfo(LoginModel loginModel) {
		try {
			// Prepare a statement using the predefined query for login check
			PreparedStatement st = getConnection().prepareStatement(StringUtils.QUERY_LOGIN_DONOR_CHECK);

			// Set the username in the first parameter of the prepared statement
			st.setString(1, loginModel.getUsername());

			// Execute the query and store the result set
			ResultSet result = st.executeQuery();

			// Check if there's a record returned from the query
			if (result.next()) {
				// Get the username from the database
				String userDb = result.getString(StringUtils.USERNAME);

				// Get the password from the database
				String encryptedPwd = result.getString(StringUtils.PASSWORD);

				String decryptedPwd = PasswordEncryptionWithAes.decrypt(encryptedPwd, userDb);
				// Check if the username and password match the credentials from the database
				if (userDb.equals(loginModel.getUsername()) && decryptedPwd.equals(loginModel.getPassword())) {
					// Login successful, return 1
					return 1;
				} else {
					// Username or password mismatch, return 0
					return 0;
				}
			} else {
				// Username not found in the database, return -1
				return -1;
			}

			// Catch SQLException and ClassNotFoundException if they occur
		} catch (SQLException | ClassNotFoundException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			// Return -2 to indicate an internal error
			return -2;
		}
	}
	
	
	public int getPatientLoginInfo(LoginModel loginModel) {
		// Try-catch block to handle potential SQL or ClassNotFound exceptions
		try {
			// Prepare a statement using the predefined query for login check
			PreparedStatement st = getConnection().prepareStatement(StringUtils.QUERY_LOGIN_PATIENT_CHECK);

			// Set the username in the first parameter of the prepared statement
			st.setString(1, loginModel.getUsername());

			// Execute the query and store the result set
			ResultSet result = st.executeQuery();

			// Check if there's a record returned from the query
			if (result.next()) {
				// Get the username from the database
				String userDb = result.getString(StringUtils.USERNAME);

				// Get the password from the database
				String encryptedPwd = result.getString(StringUtils.PASSWORD);

				String decryptedPwd = PasswordEncryptionWithAes.decrypt(encryptedPwd, userDb);
				// Check if the username and password match the credentials from the database
				if (userDb.equals(loginModel.getUsername()) && decryptedPwd.equals(loginModel.getPassword())) {
					// Login successful, return 1
					return 1;
				} else {
					// Username or password mismatch, return 0
					return 0;
				}
			} else {
				// Username not found in the database, return -1
				return -1;
			}

			// Catch SQLException and ClassNotFoundException if they occur
		} catch (SQLException | ClassNotFoundException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			// Return -2 to indicate an internal error
			return -2;
		}
	}

	
	public int addBloodCentre(ModelBloodCentre centre) {

		try {
			// Prepare a statement using the predefined query for student registration
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_ADD_BLOODCENTRE);

			// Set the student information in the prepared statement
			stmt.setString(1, centre.getCentreName());
			stmt.setString(2,centre.getLocation());
			stmt.setString(3, centre.getCity());
			stmt.setDate(4, Date.valueOf(centre.getStartDate()));
			stmt.setDate(5, Date.valueOf(centre.getEndDate()));
			// Execute the update statement and store the number of affected rows
			int result = stmt.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (result > 0) {
				return 1; // Registration successful
			} else {
				return 0; // Registration failed (no rows affected)
			}

		} catch (ClassNotFoundException | SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1; // Internal error
		}
	}
	
	
	
	
	
	
	
	public Boolean checkEmailIfExists(String email) {
		// TODO: Implement logic to check if the provided email address exists in the
		// database
		// This method should likely query the database using DBController and return
		// true if the email exists, false otherwise.
		return false;
	}

	public Boolean checkNumberIfExists(String number) {
		// TODO: Implement logic to check if the provided phone number exists in the
		// database
		// This method should likely query the database using DBController and return
		// true if the phone number exists, false otherwise.
		return false;
	}

	public Boolean checkUsernameIfExists(String username) {
		// TODO: Implement logic to check if the provided username exists in the
		// database
		// This method should likely query the database using DBController and return
		// true if the username exists, false otherwise.
		return false;
	}

	public ArrayList<DonorsModel> getAllDonorsInfo() {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_GET_ALL_DONORS);
			ResultSet result = stmt.executeQuery();

			ArrayList<DonorsModel> donors = new ArrayList<DonorsModel>();

			while (result.next()) {
				DonorsModel donor= new DonorsModel();
				donor.setFirst_name(result.getString("firstName"));
				donor.setLast_name(result.getString("lastName"));
				donor.setBirthday(result.getDate("birthday").toLocalDate()); // Might have error here ----------------------
				donor.setUsername(result.getString("username"));	
				donor.setPassword(result.getString("password"));
				donor.setEmail(result.getString("email"));
				donor.setCity(result.getString("city"));
				donor.setBlood_type(result.getString("bloodType"));
				donor.setDisease(result.getString("disease"));	
				donor.setBlood_centre(result.getString("bloodCentre"));
				donors.add(donor);
			}
			return donors;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<ModelBloodCentre> getAllCentreInfo() {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_GET_ALL_CENTRE);
			ResultSet result = stmt.executeQuery();

			ArrayList<ModelBloodCentre> centres = new ArrayList<ModelBloodCentre>();

			while (result.next()) {
				ModelBloodCentre centre= new ModelBloodCentre();
				centre.setCentreName(result.getString("centreName"));
				centre.setLocation(result.getString("location"));
				centre.setCity(result.getString("city"));
				centre.setStartDate(result.getDate("startDate").toLocalDate());
				centre.setEndDate(result.getDate("endDate").toLocalDate());
				centres.add(centre);
			}
			return centres;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	//We might need the livebloodcentre info using the arraylist
	
	
	public int deleteDonorInfo(String username) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(StringUtils.QUERY_DELETE_DONOR);
			st.setString(1, username);
			return st.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		}
	}
	public int deleteCentreInfo(String centreName) 
	{
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(StringUtils.QUERY_DELETE_CENTRE);
			st.setString(1, centreName);
			return st.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		}
	}
}