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
	href="<%=contextPath%>/stylesheets/bloodCentre.css" />
</head>
<body>
	<div class="container">
		<h1>Registration Form</h1>
		<form action="<%=contextPath%>/bloodCentre" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col">
					<label for="centreName">Centre Name:</label> <input type="text"
						id="centreName" name="centreName" required>
				</div>
				<div class="col">
					<label for="city">City</label> <select id="city"
						name="city" required>
						<option value="kathmandu">Kathmandu</option>
						<option value="lalitpur">Lalitpur</option>
						<option value = "bhaktapur">Bhaktapur</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="startDate">Start Date:</label> <input type="date"
						id="startDate" name="startDate" required>
				</div>
				<div class="col">
					<label for="endDate">End Date:</label> <input type="date"
						id="endDate" name="endDate" required>
				</div>
				

			</div>
			<div class="row">
				
				<div class="col">
					<label for="firstName">Location:</label> <input type="text"
						id="location" name="location" required>
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