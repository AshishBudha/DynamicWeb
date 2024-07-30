<%@page import="controller.database.DBController"%>
<%@page import="utils.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import = "utils.StringUtils" %>
<%@page import = "model.ModelBloodCentre" %>
<%@page import = "java.util.ArrayList" %>
<%
	String contextPath = request.getContextPath();
%>
 <!DOCTYPE html>

<%HttpSession userSession = request.getSession(false);%>
<html lang="en">


<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>SimpleBlog - Julia Walker's Personal Blog</title>

  <link rel = "stylesheet" type = "text/css"
  	href = "<%=contextPath%>/stylesheets/header.css" />
  <link rel = "stylesheet" type = "text/css" 
  	href = "<%=contextPath%>/stylesheets/home.css" />
  <link rel = "stylesheet" type = "text/css"
  	href = "<%=contextPath%>/stylesheets/footer.css" />
  	
  <script src = "<%=request.getContextPath()%>/stylesheets/script.js" defer></script>
</head>

<body class="light-theme">

  <!--
    - #HEADER
  -->
  <jsp:include page = "<%=StringUtils.PAGE_URL_HEADER%>" />

  <main>

    <!--
      - #HERO SECTION
    -->

    <div class="hero">
		
      <div class="container">

        <div class="left">

          <h1 class="h1">
            One Pint, <b>One Life&nbsp;</b>.
            <br>Donate Blood Now
          </h1>


          <div class="btn-group">
            <a href="#" class="btn btn-primary">Contact Us</a>
          </div>

        </div>

        <div class="right">

          <div class="pattern-bg"></div>
          <div class="img-box">
            
          </div>

        </div>

      </div>

    </div>





    <div class="main">

      <div class="container">

        <!--
          - BLOG SECTION
        -->

        <div class="blog">

          <h2 class="h2">Available Blood Centres</h2>

          <div class="blog-card-group">
          
          
          <%DBController dbController = new DBController();
          ArrayList<ModelBloodCentre> centres = dbController.getAllCentreInfo();
  		request.setAttribute(StringUtils.CENTRE_LISTS, centres );
 			%>
          
          
          <c:if test="${empty centreLists}">
				<p>No students found.</p>
			</c:if>

			<c:if test="${not empty centreLists}">
				<c:forEach var="centre" items="${centreLists}">
				
					<div class="blog-card">
		              <div class="blog-card-banner">
		                <ion-icon name="globe"></ion-icon>
		              </div>
		
		              <div class="blog-content-wrapper">
						<form id="deleteForm-${centre.centreName}" method="post"
							action="<%=contextPath + StringUtils.SERVLET_URL_MODIFY_USER%> ">
							<input type="hidden" name="<%=StringUtils.DELETE_ID %>" value="${centre.centreName}" />
							<button type="button" class = "blog-topic text-tiny">Delete</button>
						</form>
	
		                <h4>
		                    Centre Name : ${centre.centreName} <br>
		                    City 		: ${centre.city}  <br>
		                    Location 	: ${centre.location}<br>
		                    Start Date  : ${centre.startDate} <br>
		                    End Date  	: ${centre.endDate} <br>
                </h4>

                
              </div>

            </div>
				
				</c:forEach>
			</c:if>

          </div>

        </div>





        <!--
          - ASIDE
        -->

        <div class="aside">

          <div class="topics">

            <h2 class="h2">Topics</h2>

            <a href="#" class="topic-btn">
              <div class="icon-box">
                <ion-icon name="logo-facebook"></ion-icon>
              </div>

              <p>Follow us on Facebook</p>
            </a>

            <a href="#" class="topic-btn">
              <div class="icon-box">
                <ion-icon name="logo-instagram"></ion-icon>
              </div>

              <p>Follow us on Instagram</p>
            </a>

            <a href="#" class="topic-btn">
              <div class="icon-box">
                <ion-icon name="logo-youtube"></ion-icon>
              </div>

              <p>Follow us on Youtube</p>
            </a>

          </div>

        </div>

      </div>

    </div>

  </main>

<jsp:include page = "<%=StringUtils.PAGE_URL_FOOTER %>"  />





  <!--
    - custom js link
  -->
  <script src="./assets/js/script.js"></script>

  <!--
    - ionicon link
  -->
  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>

</html>