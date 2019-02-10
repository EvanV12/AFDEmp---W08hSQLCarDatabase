<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
input {
	background-color: lavender;
	float: right;
}

th {
	color: green;
}
</style>
<body>

	<form action="InsertCar" method="post">
		<table border="1">
			<tr>
				<th>Insert New Car</th>
			</tr>

			<tr>
				<td>Registration info: <input type="text" name="LicensePlate"></td>
			</tr>

			<tr>
				<td>Factory: <input type="text" name="Factory"></td>
			</tr>

			<tr>
				<td>Model: <input type="text" name="Model"></td>
			</tr>

			<tr>
				<td>Color: <input type="text" name="Color"></td>
			</tr>

			<tr>
				<td>CC: <input type="text" name="cc"></td>
			</tr>

			<tr>
				<td>Registration Date: <input type="text" name="RegDate"></td>
			</tr>


		</table>
		<br> <input type="submit" style="float: left;">

	</form>

	<br>
	<br>

	<form action="FindCar" method="post">
		<table border="1">
			<tr>
				<th>Find Car</th>
			</tr>

			<tr>
				<td>Registration info: <input type="text" name="LicensePlate"></td>
			</tr>

			<tr>
				<td>Factory: <input type="text" name="Factory"></td>
			</tr>

			<tr>
				<td>Model: <input type="text" name="Model"></td>
			</tr>

			<tr>
				<td>Color: <input type="text" name="Color"></td>
			</tr>

			<tr>
				<td>CC: <input type="text" name="cc"></td>
			</tr>

			<tr>
				<td>Registration Date: <input type="text" name="RegDate"></td>
			</tr>


		</table>
		<br> <input type="submit" style="float: left;">

	</form>

</body>
</html>