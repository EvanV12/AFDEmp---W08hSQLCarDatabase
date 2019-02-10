<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="newcar" scope="request"
	class="sqlprojectpackage.NewCarBean" />
<jsp:setProperty name="newcar" property="registration"
	param="registration" />
<jsp:setProperty name="newcar" property="factory" param="factory" />
<jsp:setProperty name="newcar" property="model" param="model" />
<jsp:setProperty name="newcar" property="colour" param="colour" />
<jsp:setProperty name="newcar" property="cc" param="cc" />
<jsp:setProperty name="newcar" property="regdate" param="regdate" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Αυτοκίνητα - Νεο Αυτοκίνητο</title>


</head>
<body>

	<br />
	<br />
	<br />

	<%
		request.setCharacterEncoding("utf-8");
		if (request.getParameter("registration") != null && request.getParameter("factory") != null
				&& request.getParameter("model") != null && request.getParameter("colour") != null
				&& request.getParameter("cc") != null && request.getParameter("regdate") != null) {
			String str = newcar.insert();
			if (!str.equals("")) {
	%>
	<div style="width: 400px; margin: auto">
		<%=str%>
	</div>
	<%
		}
		} else {
	%>
	<div style="width:400px; margin:auto">

		<form name="mainform" action="newcar.jsp" method="post">


			<table style="width: 400px" border="1">
				<tr>
					<td colspan="2" style="border: none"><b>Καταχώρηση νέου
							αυτοκινήτου</b></td>
				</tr>

				<tr>
					<td colspan="2" style="border: none" height="10"></td>
				</tr>

				<tr>
					<td width="200">Αριθμός Πινακίδας</td>
					<td width="200" align="center"><input type="text"
						name="registration" value="" /></td>
				</tr>


				<tr>
					<td width="200">Εταιρεία</td>
					<td width="200" align="center"><input type="text"
						name="factory" value="" /></td>
				</tr>


				<tr>
					<td width="200">Μοντέλο</td>
					<td width="200" align="center"><input type="text"
						name="model" value="" /></td>
				</tr>


				<tr>
					<td width="200">Κυβικά</td>
					<td width="200" align="center"><input type="text" name="cc"
						value="" /></td>
				</tr>


				<tr>
					<td width="200">Χρώμα</td>
					<td width="200" align="center"><input type="text"
						name="colour" value="" /></td>
				</tr>


				<tr>
					<td width="200">Έτος Κατασκευής</td>
					<td width="200" align="center"><input type="text"
						name="regdate" value="" /></td>
				</tr>

			</table>
			<input type="submit">
		</form>
		<% }%>
	</div>
</body>
</html>
