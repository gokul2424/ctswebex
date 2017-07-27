<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Our First Page</title>
<style>

	.ng-invalid {
		border: 1px solid red;
	}
	.ng-valid {
		border: 1px solid green;
	}
</style>
</head>
<body ng-app>

 <h1 class="ng-invalid">Employee Profile Page</h1>

<p>${employee}</p>

<form:form method="POST" commandName="employee" modelAttribute="salaryIncrement">
<table>
   
    <tr>
        <td>Employee Id:</td>
        <td><form:input path="employeeId" type="number" /></td>
        <td><form:errors path="employeeId" cssClass="error" /></td>
    </tr>
    
    <tr>
        <td>Increment Salary By:</td>
        <td><form:input path="amount" type="number" ng-model="amount" min="1000"/> {{amount}}</td>
        <td><form:errors path="amount" cssClass="error" /></td>
    </tr>
    
    <tr>
        <td colspan="2"><input type="submit" value="Update Salary"></td>
    </tr>
</table>
</form:form>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.5/angular.min.js"></script>
<script>
</script>
</body>
</html>