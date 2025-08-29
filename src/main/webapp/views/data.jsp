<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Students Data Here</h2>
	<a href="/">Add New Students</a>
	<table border="1">
		<thead>
			<tr>
				<th>S.No</th>
				<th>Name</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Course</th>
				<th>Timing</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="std" items="${students}" varStatus="index">
			<tr>
				<td>${index.count}</td>
				<td>${std.name}</td>
				<td>${std.email}</td>
				<td>${std.gender}</td>
				<td>${std.course}</td>
				<td>${std.timing}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>