package com.kb.rest.resource;

import java.io.PrintWriter;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kb.model.User;
import com.kb.service.UserService;

@Path("/userInfo")
public class UserResource {
	UserService userService = new UserService();

	// CRUD -- CREATE operation
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String createUser(@FormParam("id") String id,@FormParam("name") String name,@FormParam("email") String email, @FormParam("country") String country) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setCountry(country);
		User userResponse = userService.createUser(user);
		List<User> userList = userService.getAllUsers();
				
		String response ="<html>"+
						"<head>"+
						 "<title>User Management Application</title>"+
						"</head>"+
						"<body>"+
						 "<center>"+
						  "<h1>User Management</h1>"+
						        "<h2>"+
						         "<a href='../user-form.jsp'>Add New User</a>"+
						         "&nbsp;&nbsp;&nbsp;"+
						         "<a href='../rest/userInfo'>List All Users</a>"+
						         "&nbsp;&nbsp;&nbsp;"+
						         "<a href='../update.jsp'>Edit</a>"+
						         "&nbsp;&nbsp;&nbsp;"+
						         "<a href='../delete.jsp'>Delete</a>"+
						        "</h2>"+
						 "</center>"+
						    "<div align='center'>"+
						        "<table border='1' cellpadding='5'>"+
						            "<caption><h2>List of Users</h2></caption>"+
						            "<tr>"+
						                "<th>ID</th>"+
						                "<th>Name</th>"+
						                "<th>Email</th>"+
						                "<th>Country</th>"+
						            "</tr>";
						          for(User user_list: userList) {
						        	response += 
						        	"<tr>"+
				                    "<td>"+ user_list.getId() +"</td>"+
				                    "<td>"+ user_list.getName() + "</td>"+
				                    "<td>"+ user_list.getEmail() +"</td>"+
				                    "<td>"+ user_list.getCountry() +"</td>"+
				                    "</tr>";
						          }
						        response +=  
						        "</table>"+
						    "</div>"+
						"</body>"+
						"</html>";
									
				
		return response;
	}

	// CRUD -- READ operation
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getAllUsers() {
		List<User> userList = userService.getAllUsers();
		
		String response ="<html>"+
						"<head>"+
						 "<title>User Management Application</title>"+
						"</head>"+
						"<body>"+
						 "<center>"+
						  "<h1>User Management</h1>"+
						        "<h2>"+
						         "<a href='../user-form.jsp'>Add New User</a>"+
						         "&nbsp;&nbsp;&nbsp;"+
						         "<a href='../rest/userInfo'>List All Users</a>"+
						         "&nbsp;&nbsp;&nbsp;"+
						         "<a href='../update.jsp'>Edit</a>"+
						         "&nbsp;&nbsp;&nbsp;"+
						         "<a href='../delete.jsp'>Delete</a>"+
						        "</h2>"+
						 "</center>"+
						    "<div align='center'>"+
						        "<table border='1' cellpadding='5'>"+
						            "<caption><h2>List of Users</h2></caption>"+
						            "<tr>"+
						                "<th>ID</th>"+
						                "<th>Name</th>"+
						                "<th>Email</th>"+
						                "<th>Country</th>"+
						            "</tr>";
						          for(User user: userList) {
						        	response += 
						        	"<tr>"+
				                    "<td>"+ user.getId() +"</td>"+
				                    "<td>"+ user.getName() + "</td>"+
				                    "<td>"+ user.getEmail() +"</td>"+
				                    "<td>"+ user.getCountry() +"</td>"+
				                    "</tr>";
						          }
						        response +=  
						        "</table>"+
						    "</div>"+
						"</body>"+
						"</html>";
						        
		return response;
	}


	// CRUD -- UPDATE operation
	@PUT
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateUser(@FormParam("id") String id,@FormParam("name") String name,@FormParam("email") String email, @FormParam("country") String country) {
		User user = userService.getUserForId(id);
		user.setName(name);
		user.setEmail(email);
		user.setCountry(country);
		User userResponse = userService.updateUser(user);
		
		String response ="<html>"+
				"<head>"+
					"<title>User Management Application</title>"+
				"</head>"+
				"<body>"+
					"<center>"+
						"<h1>User Management</h1>"+
				        "<h2>"+
				        	"<a href='user-form.jsp'>Add New User</a>"+
				        	"&nbsp;&nbsp;&nbsp;"+
				        	"<a href='rest/userInfo'>List All Users</a>"+
				        "</h2>"+
					"</center>"+
				    "<div align='center'>"+
						"<c:if test='${user != null}'>"+
							"<form action='rest/userInfo' method='post'>"+
				        "</c:if>"+
				        "<c:if test='${user == null}'>"+
							"<form action='insert' method='post'>"+
				        "</c:if>"+
				        "<table border='1' cellpadding='5'>"+
				        	"<tr>"+
				                "<th>User Id: </th>"+
				                "<td>"+
				                	"<input type='text' name='id' size='45'"+
				                		"/>"+
				                "</td>"+
				            "</tr>"+           
				            "<tr>"+
				                "<th>User Name: </th>"+
				                "<td>"+
				                	"<input type='text' name='name' size='45'"+
				                		"/>"+
				                "</td>"+
				            "</tr>"+
				            "<tr>"+
				                "<th>User Email: </th>"+
				                "<td>"+
				                	"<input type='text' name='email' size='45'"+
				                	"/>"+
				                "</td>"+
				            "</tr>"+
				            "<tr>"+
				                "<th>Country: </th>"+
				                "<td>"+
				                	"<input type='text' name='country' size='15' "+
				                	"/>"+
				                "</td>"+
				            "</tr>"+
				            "<tr>"+
				            	"<td colspan='2' align='center'>"+
				            		"<input type='submit' value='Save' />"+
				            	"</td>"+
				            "</tr>"+
				        "</table>"+
				        "</form>"+
				    "</div>	"+
				"</body>"+
				"</html>";
		
		return response;
	}
	


	// CRUD -- DELETE operation
	@DELETE
	@Produces(MediaType.TEXT_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public User deleteeUser(@FormParam("id") String id) {
		User userResponse = userService.deleteUser(id);
		return userResponse;
	}
}
