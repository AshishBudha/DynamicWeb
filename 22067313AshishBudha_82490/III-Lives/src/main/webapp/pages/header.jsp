<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "utils.StringUtils" %>
    <%@page import = "javax.servlet.http.HttpServletRequest" %>
    <%@page import = "javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<%
	//Get the session and request objects
	HttpSession userSession = request.getSession(false);
	String currentUser = (String) userSession.getAttribute(StringUtils.USERNAME);
	String contextPath = request.getContextPath();
%>
<head>
	
</head>
<header>

    <div class="container">

      <nav class="navbar">

        <a href="#">
          <img src="<%=request.getContextPath()%>/blood_img.jpg" alt="III-Lives" width="70" class="logo-light">
          <img src="./assets/images/logo-dark.svg" alt="III-Lives" width="100" class="logo-dark">
        </a>

        <div class="btn-group">

          <button class="theme-btn theme-btn-mobile light">
            <ion-icon name="moon" class="moon"></ion-icon>
            <ion-icon name="sunny" class="sun"></ion-icon>
          </button>

          <button class="nav-menu-btn">
            <ion-icon name="menu-outline"></ion-icon>
          </button>

        </div>

        <div class="flex-wrapper">

          <ul class="desktop-nav">

            <li>
              <a href="#" class="nav-link">Donors</a>
            </li>

            <li>
              <a href="<%=contextPath%>/pages/bloodcentre.jsp" class="nav-link">BloodCentre</a>
            </li>

            <li>
              <a href="#" class="nav-link">Profile</a>
            </li>
            
           
            <li> 
            	<form action ="<% 
            		if (currentUser!= null)
            		{
            			out.print(contextPath + StringUtils.PAGE_URL_LOGIN);
            		}
            		else
            		{
            			out.print(contextPath + StringUtils.PAGE_URL_LOGIN);
            		}
            	%>"method ="post">
            	<input class = "nav-link" type="submit" value="<%
                        // Conditionally set the button label based on user session
                        if (currentUser != null) {
                            out.print(StringUtils.LOGOUT);
                        } else {
                            out.print(StringUtils.LOGIN);
                        }
                    %>"/>
            	</form>
            </li>

            

          </ul>

          <button class="theme-btn theme-btn-desktop light">
            <ion-icon name="moon" class="moon"></ion-icon>
            <ion-icon name="sunny" class="sun"></ion-icon>
          </button>

        </div>

        <div class="mobile-nav">

          <button class="nav-close-btn">
            <ion-icon name="close-outline"></ion-icon>
          </button>

          <div class="wrapper">

            <p class="h3 nav-title">Main Menu</p>

            <ul>
              <li class="nav-item">
                <a href="#" class="nav-link">Home</a>
              </li>

              <li class="nav-item">
                <a href="#" class="nav-link">About Me</a>
              </li>

              <li class="nav-item">
                <a href="#" class="nav-link">Contact</a>
              </li>
            </ul>

          </div>

          <div>

            <p class="h3 nav-title">Topics</p>

            <ul>
              <li class="nav-item">
                <a href="#" class="nav-link">Database</a>
              </li>

              <li class="nav-item">
                <a href="#" class="nav-link">Accessibility</a>
              </li>

              <li class="nav-item">
                <a href="#" class="nav-link">Web Performance</a>
              </li>
            </ul>

          </div>

        </div>

      </nav>

    </div>

  </header>