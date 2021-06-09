<!DOCTYPE html>
<html>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<script src="js/rest.js"></script>
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
<title>Delete User</title>
</head>
<body>
	<center>
		<h1>User Management</h1>
        <h2>
        	<a href="user-form.jsp">Add New User</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="rest/userInfo">List All Users</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="update.jsp">Edit</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="delete.jsp">Delete</a>
        	
        </h2>
	</center>
	<div align="center">
		<h2>Delete User</h2>
		<form id="deleteForm">
			<div  align:center;">
				<div style="padding:15px;">
					<table border="1" cellpadding="5">
				     	<tr>
				        <th>User Id: </th>
					        <td>
						        <input type="text" name="id" size="45"
						        />
					        </td>
				        </tr>
				     </table>  
				</div>
				<div style="padding:20px;text-align:center">
					<input type="submit" value="Submit" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>  