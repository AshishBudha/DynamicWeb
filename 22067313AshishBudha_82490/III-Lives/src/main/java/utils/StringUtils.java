package utils;
import java.io.File;

public class StringUtils {

	// Start: DB Connection
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String LOCALHOST_URL = "jdbc:mysql://localhost:3306/iii-lives";
	public static final String LOCALHOST_USERNAME = "root";
	public static final String LOCALHOST_PASSWORD = "";
	public static final String IMAGE_ROOT_PATH = "C:\\Users\\ashis\\eclipse-workspace\\III-Lives\\src\\main\\webapp\resources\\images\\";
	public static final String IMAGE_DIR_PRODUCT = "C:/" + IMAGE_ROOT_PATH + "product\\";
	public static final String IMAGE_DIR_USER = "C:/" + IMAGE_ROOT_PATH + "user\\";
	// End: DB Connection

	// Start: Queries
	public static final String QUERY_REGISTER_DONOR = "INSERT INTO donor ("
			+ "firstName, lastName, DOB, username, password, email, city, bloodType, disease) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String QUERY_REGISTER_PATIENT = "INSERT INTO donor ("
			+ "first_name, last_name, birthday, username, password, email, city, blood_type) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String QUERY_ADD_BLOODCENTRE = "INSERT INTO bloodcentrearea ("
			+ "centreName, location, city, startDate, endDate) "
			+ "VALUES (?,?,?,?,?)";
	public static final String QUERY_LOGIN_DONOR_CHECK = "SELECT * FROM donor WHERE username = ?";
	public static final String QUERY_LOGIN_PATIENT_CHECK = "SELECT * FROM patients WHERE username = ?";
	public static final String QUERY_GET_ALL_CENTRE = "SELECT * FROM bloodcentrearea";
	public static final String QUERY_GET_ALL_DONORS = "SELECT * FROM donors";
	public static final String QUERY_GET_ALL_PATIENTS = "SELECT * FROM patients";
	public static final String QUERY_GET_DONOR_ID = "SELECT id FROM donors WHERE username = ?";
	public static final String QUERY_GET_PATIENT_ID = "SELECT id FROM patients WHERE username = ?";
	public static final String QUERY_DELETE_DONOR = "DELETE FROM donors WHERE username = ?";
	public static final String QUERY_DELETE_PATIENT = "DELETE FROM patients WHERE username = ?";
	public static final String QUERY_DELETE_CENTRE = "DELETE FROM bloodcentrearea WHERE centreName = ?";
// End: Queries

	// Start: Parameter names
	public static final String USERNAME = "username";
	public static final String USER_NAME = "user_name";
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String BIRTHDAY = "birthday";
	public static final String GENDER = "gender";
	public static final String EMAIL = "email";
	public static final String CITY = "city";
	public static final String BLOOD_TYPE = "bloodType";
	public static final String DISEASE = "disease";
	public static final String BLOOD_CENTRE = "bloodCentre";
	public static final String START_DATE = "startDate";
	public static final String END_DATE = "endDate";
	public static final String LOCATION = "location";
	public static final String CENTRE_NAME = "centreName";
	//public static final String PHONE_NUMBER = "phoneNumber";
	
	public static final String PASSWORD = "password";
	public static final String RETYPE_PASSWORD = "retypePassword";
	public static final String IMAGE = "image";
	// End: Parameter names

	// Start: Validation Messages
	// Register Page Messages
	public static final String MESSAGE_SUCCESS_REGISTER = "Successfully Registered!";
	public static final String MESSAGE_ERROR_REGISTER = "Please correct the form data.";
	public static final String MESSAGE_ERROR_USERNAME = "Username is already registered.";
	public static final String MESSAGE_ERROR_EMAIL = "Email is already registered.";
	public static final String MESSAGE_ERROR_PHONE_NUMBER = "Phone number is already registered.";
	public static final String MESSAGE_ERROR_PASSWORD_UNMATCHED = "Password is not matched.";
	public static final String MESSAGE_ERROR_INCORRECT_DATA = "Please correct all the fields.";

	// Login Page Messages
	public static final String MESSAGE_SUCCESS_LOGIN = "Successfully LoggedIn!";
	public static final String MESSAGE_ERROR_LOGIN = "Either username or password is not correct!";
	public static final String MESSAGE_ERROR_CREATE_ACCOUNT = "Account for this username is not registered! Please create a new account.";

	// Other Messages
	public static final String MESSAGE_ERROR_SERVER = "An unexpected server error occurred.";
	public static final String MESSAGE_SUCCESS_DELETE = "Successfully Deleted!";
	public static final String MESSAGE_ERROR_DELETE = "Cannot delete the user!";
	
	public static final String MESSAGE_SUCCESS = "successMessage";
	public static final String MESSAGE_ERROR = "errorMessage";
	// End: Validation Messages

	// Start: JSP Route
	public static final String PAGE_URL_LOGIN = "/pages/login.jsp";
	public static final String PAGE_URL_REGISTER = "/pages/register.jsp";
	public static final String PAGE_URL_WELCOME = "/pages/welcome.jsp";
	public static final String PAGE_URL_INDEX = "/pages/index.jsp";
	public static final String PAGE_URL_FOOTER = "/pages/footer.jsp";
	public static final String PAGE_URL_HEADER = "/pages/header.jsp";
	public static final String PAGE_URL_BLOODCENTRE = "/pages/bloodcentre.jsp";
	public static final String URL_LOGIN = "/login.jsp";
	public static final String URL_INDEX = "/index.jsp";
	// End: JSP Route

	// Start: Servlet Route
	public static final String SERVLET_URL_LOGINDONOR = "/loginDonor";
	public static final String SERVLET_URL_REGISTERDONOR = "/registerDonor";
	public static final String SERVLET_URL_REGISTERPATIENT = "/registerPatient";
	public static final String SERVLET_URL_LOGOUT = "/logout";
	public static final String SERVLET_URL_HOME = "/home";
	public static final String SERVLET_URL_MODIFY_USER = "/modifyUser";
	// End: Servlet Route

	// Start: Normal Text
	public static final String USER = "user";
	public static final String SUCCESS = "success";
	public static final String TRUE = "true";
	public static final String JSESSIONID = "JSESSIONID";
	public static final String LOGIN = "Login";
	public static final String LOGOUT = "Logout";
	public static final String CENTRE_LISTS = "centreLists";
	public static final String SLASH= "/";
	public static final String DELETE_ID= "deleteId";
	public static final String UPDATE_ID= "updateId";
	
	
	// End: Normal Text
}
