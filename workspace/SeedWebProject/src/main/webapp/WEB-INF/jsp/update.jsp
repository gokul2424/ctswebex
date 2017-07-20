<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
 .error {
 color: red;
 }

</style>
</head>
<body>
<h1>Test</h1>
<form:form method="POST" commandName="updatesalary" modelAttribute="employee" name="userForm">
<table>
    <tr>	
        <td>User Id :</td>
        <td><form:input path="id" required="true" disabled="true"/></td> 
        <td><form:errors path="id" cssClass="error" /></td>

    </tr>
    
    <tr>
        <td>Name :</td>
        <td><form:input path="name" disabled="true"/></td>
        <td><form:errors path="name" cssClass="error" /></td>
    </tr>
    
    <tr>
        <td>Salary :</td>
        <td><form:input path="salary" type="number" disabled="true" /></td>
        <td><form:errors path="salary" cssClass="error" /></td>
    </tr>
    
    <tr>
        <td>Salary :</td>
        <td><form:input path="newsalary" type="number" /></td>
        <td><form:errors path="newsalary" cssClass="error" /></td>
    </tr>
    
    <tr>
        <td colspan="2"><input type="submit" value="Update Salary"></td>
    </tr>
</table>
</form:form>

</body>
</html>