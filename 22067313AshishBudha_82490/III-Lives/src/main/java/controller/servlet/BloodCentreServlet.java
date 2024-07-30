package controller.servlet;

import java.io.IOException;

import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.database.DBController;
import model.ModelBloodCentre;
import utils.StringUtils;
import utils.ValidationUtil;

/**
 * This Servlet class handles student registration requests. It extracts student
 * information from the registration form submission, performs basic data
 * validation (to be implemented), and attempts to register the student in the
 * database using a `DBController`. The user is redirected to the login page
 * upon successful registration.
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/bloodCentre" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class BloodCentreServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final DBController dbController;

	public BloodCentreServlet() {
		this.dbController = new DBController();
	}

	/**
	 * Handles HTTP POST requests for student registration.
	 *
	 * @param request  The HttpServletRequest object containing registration form
	 *                 data.
	 * @param response The HttpServletResponse object for sending responses.
	 * @throws ServletException if a servlet-specific error occurs.
	 * @throws IOException      if an I/O error occurs.
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String centreName = request.getParameter(StringUtils.CENTRE_NAME);
		LocalDate startDate = LocalDate.parse(request.getParameter(StringUtils.START_DATE));
		LocalDate endDate = LocalDate.parse(request.getParameter(StringUtils.END_DATE));
		String city = request.getParameter(StringUtils.CITY);
		String location = request.getParameter(StringUtils.LOCATION);

		
		
		ModelBloodCentre centre = new ModelBloodCentre(centreName,city,startDate,endDate,location);
		
		
	
		if(!ValidationUtil.isTextOnly(centreName) ||
				!ValidationUtil.isTextOnly(location)) {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_INCORRECT_DATA);
			request.getRequestDispatcher(StringUtils.PAGE_URL_BLOODCENTRE).forward(request, response);
		}

	
		int result = dbController.addBloodCentre(centre);

		if (result == 1) {
			request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_REGISTER);
			response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_INDEX+ "?success=true");
		} else if (result == 0) {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_REGISTER);
			request.getRequestDispatcher(StringUtils.PAGE_URL_BLOODCENTRE).forward(request, response);
		} else {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
			request.getRequestDispatcher(StringUtils.PAGE_URL_BLOODCENTRE).forward(request, response);
		}
	}
}