<%@ page import="java.util.*, model.*, data.*, org.hibernate.*, org.hibernate.cfg.*" %>

<%! long idChild; String nameChild; String cChild; boolean isChildNaughty; Present p; 
long idPresent; String namePresent; boolean isValidPresent; boolean isPresentMade;%>

<body>
	<table border="1">
	<tr>
		<th>CHILD ID</th>
		<th>NAME</th>
		<th>CITY</th>
		<th>NAUGHTY CHILD ?</th>
		
		<th>PRESENT ID</th>
		<th>NAME</th>
		<th>OK ?</th>
		<th>MADE ?</th>
	</tr>		

<%
			IDAOChild dao = new DAOChild();
			List<Child> myList = dao.getStock();
			
			for(Child child : myList) {
				long idChild = child.getId();
				String nameChild = child.getName(); 
				String cChild = child.getCity(); 
				boolean isChildNaughty = child.getIsNaughty();
				Present p = child.getPresent();
				long idPresent = p.getId(); 
				String namePresent = p.getName(); 
				boolean isValidPresent = p.getIsValid(); 
				boolean isPresentMade = p.getIsMade();
		%>		
			<tr>
				<td><%=idChild%></td>
				<td><%=nameChild%></td>
				<td><%=cChild%></td>
				<td><%=isChildNaughty%></td>
				
				<td><%=idPresent%></td>
				<td><%=namePresent%></td>
				<td><%=isValidPresent%></td>
				<td><%=isPresentMade%></td>
				
			</tr>
<% }
%>
		</table>
		
		<br/>
			<div class="">
            	<h2>UPDATE CHILD</h2>
                <ul>
                	<li><a href="updateChild.jsp">Update a Child</a></li>
                </ul>
            </div>
        
	</body>
</html>