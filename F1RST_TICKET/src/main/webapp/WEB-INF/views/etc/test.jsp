<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="common.JDBCTemplate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    request.setCharacterEncoding("utf-8");
    
    Connection conn = JDBCTemplate.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    
    String id=(String)session.getAttribute("viewid");
    String sql ="SELECT * FROM usertable WHERE userid=?";
    ps=conn.prepareStatement(sql);
    ps.setString(1, id);
    rs = ps.executeQuery();
    
    %>
    
    <h2>나의 정보 조회</h2>

<table border="1">
<tr>
	<td>아이디</td>
	<td>비밀번호</td>
	<td>이름</td>
</tr>

<%while(rs.next()){%>
<tr>
	<td><%=rs.getString("viewid") %></td>
	<td><%=rs.getString("viewpw") %></td>
	<td><%=rs.getString("viewName") %></td>
</tr>
<%}%>
</table>