<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>User Management Application</title>
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
		<c:if test="${user != null}">
			<form action="rest/userInfo" method="post">
        </c:if>
        <c:if test="${user == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
        	<tr>
                <th>User Id: </th>
                <td>
                	<input type="text" name="id" size="45"
                		/>
                </td>
            </tr>           
            <tr>
                <th>User Name: </th>
                <td>
                	<input type="text" name="name" size="45"
                		/>
                </td>
            </tr>
            <tr>
                <th>User Email: </th>
                <td>
                	<input type="text" name="email" size="45"
                	/>
                </td>
            </tr>
            <tr>
                <th>Country: </th>
                <td>
                	<input type="text" name="country" size="15" 
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>
