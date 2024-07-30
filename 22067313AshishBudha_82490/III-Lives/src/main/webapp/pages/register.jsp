<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import = "utils.StringUtils" %>


<%
String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheets/register.css" />
</head>
<body>
	<div class="container">
		<h1>Registration Form</h1>
		<form action="<%=contextPath%>/registerDonor" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col">
					<label for="firstName">First Name:</label> <input type="text"
						id="firstName" name="firstName" required>
				</div>
				<div class="col">
					<label for="lastName">Last Name:</label> <input type="text"
						id="lastName" name="lastName" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="username">Username:</label> <input type="text"
						id="username" name="username" required>
				</div>
				<div class="col">
					<label for="birthday">Birthday:</label> <input type="date"
						id="birthday" name="birthday" required>
				</div>

			</div>
			<div class="row">
				<div class="col">
					<label for="city">City</label> <select id="city"
						name="city" required>
						<option value="kathmandu">Kathmandu</option>
						<option value="lalitpur">Lalitpur</option>
						<option value = "bhaktapur">Bhaktapur</option>
					</select>
				</div>
				<div class="col">
					<label for="email">Email:</label> <input type="email" id="email"
						name="email" value="example@gmail.com" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="bloodType">Blood Type:</label><select id = "bloodType"
						name = "bloodType" required>
						<option value = "A+">A+</option>
						<option value = "A-">A-</option>
						<option value = "B+">B+</option>
						<option value = "B-">B-</option>
						<option value = "AB+">AB+</option>
						<option value = "AB-">AB-</option>
						<option value = "O+">O+</option>
						<option value = "O-">O-</option>
					
					
					</select>
				</div>
				<div class="col">
					<label for="disease">Disease:</label> <select id="disease"
						name="disease" required>
						<option value="no">No</option>
						<option value="yes">Yes</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="password">Password:</label> <input type="password"
						id="password" value="" name="password" required>
				</div>
				<div class="col">
					<label for="retypePassword">Retype Password:</label> <input
						type="password" value="" id="retypePassword" name="retypePassword" required>
				</div>
			</div>
			<button type="submit">Submit</button>
		</form>
		<%
		String errMsg = (String) request.getAttribute(StringUtils.MESSAGE_ERROR);
		String successMsg = (String) request.getAttribute(StringUtils.MESSAGE_SUCCESS);

		if (errMsg != null) {
			// print
		%>
		<h4 class="error-msg">
			<%
			out.println(errMsg);
			%>
		</h4>
		<%
		}

		if (successMsg != null) {
		// print
		%>
		<h4 class="success-msg">
			<%
			out.println(successMsg);
			%>
		</h4>
		<%
		}
		%>
	</div>
</body>
</html>