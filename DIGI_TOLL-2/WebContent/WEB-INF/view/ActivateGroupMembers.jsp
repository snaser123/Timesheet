<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html>
<head>
<link href="<c:url value="/resources/theme1/css/style1.css" />" rel="stylesheet">
</head>
<body>
<marquee>${message}</marquee>
<table id="customers">
  <tr>
    <th> ID</th>
    <th>applicant name</th>
	    <th>id proof</th>
    <th>activate</th>

  </tr>
  <c:forEach var="request" items="${group_details}">
  <tr>
    <td><c:out value="${request.getId()}"/></td>
	<td><c:out value="${request.getApplicant_name()}"/></td>
	<td><img src="data:image/jpg;base64,<c:out value='${request.getData()}'/>" /></td>
	<img src='data:image/jpg;base64,<s:property value='enImage'/>' alt="my image" />
    <td>
							<form action="ActivateService.html">
								<input type="hidden" name="serviceId" value="${request.getId()}">
									<input type="submit" value="ACTIVATE" class="link"/>
							</form>
						</td>
					</tr>
				</c:forEach>
 
  
</table>

<a href="index.jsp">exit</a>
</body>
</html>
	
	

	


