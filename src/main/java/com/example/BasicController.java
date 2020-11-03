package com.example;

import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import com.example.AWSS3Ctrl;

@RestController
public class BasicController {

        @RequestMapping("/home")
	public String home_page() {
            return "" + "<a href=\"/edit\">Edit Profile</a>"
                       + "<hr>"
                       + "<h1>Home Page</h1>"
                       + "<br><p>(image holder)</p>"
                       + "Name"
                       + "<br> Description"
                       ;  
        }

        @RequestMapping("/test")
	public String welcome_page() {
            return "" + "<a href=\"/home\">Return</a>" +
                    //"<script src=\"/html/test.html\"></script>"
                    "  <form action=\"/files\">\n" +
                    "  <label for=\"img\">Select image:</label>\n" +
                    "  <input type=\"file\" id=\"img\" name=\"img\" accept=\"image/*\">\n" +
                    "  <input type=\"submit\">\n" +
                    "  <script src=\"/js/custom.js\"></script>"+
                    "  </form>"
                    ;
        }
        
        @RequestMapping("/edit")
	public String edit_profile() {
            return ""+ "<a href=\"/home\">Home</a>"
                    //+ "<br><a href=\"/edit\">Edit Profile</a>"
                    + "<hr>"
                         
                    + "<h1>Edit Profile </h1>"

                    + "<form id='profile' action='http://assn3.s3-website.us-east-2.amazonaws.com' method'POST' enctype=”multipart/form-data”>"
                    + "<br><label for=\"img\">Edit Photo:</label>"
                    + "<input type=\"file\" id=\"img\" name=\"img\" accept=\"image/*\">" 
                       
                    + "<br><label for=\"name\">Edit Name:</label>"
                    + "<input type=\"text\" id=\"name\" name=\"name\">" 

                    + "<br><label for=\"bio\">Edit Biography:</label>"
                    + "<input type=\"text\" id=\"bio\" name=\"bio\">" 
                    + "<input type=\"submit\" value=\"Submit\">"
                    + "</form>"
                    ;	
        }
        
        @RequestMapping("/login")
	public String login() {
		return "<h1>Login</h1>" 
                        + "<a href=\"/login\">Login</a>"
                        + "<br><a href=\"/edit\">Edit Profile</a>"
                        + "<hr>"
                        ;                
	}
        
        @RequestMapping("/")
	public String index(HttpServletResponse httpResponse) throws Exception{
                httpResponse.sendRedirect("/home");
                return null;
        }
        
}
