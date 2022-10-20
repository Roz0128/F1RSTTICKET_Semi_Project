<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- layout.css -->
<link rel="stylesheet" href="/resources/css/layout.css">

</head>
<body>

<!--  비 로그인 --> 
<% if(session.getAttribute("adminlogin") == null )  { %>
  <div class="topmenu"></div>
<%@ include file = "./admin/login.jsp" %>
<% }  %>

<!-- 로그인 -->
<% if(session.getAttribute("adminlogin") != null  && (boolean)session.getAttribute("adminlogin"))  { %>
  <div class="topmenu">
	<ul style="list-style-type: none">
		<li style="display:inline; color: #fff;"><%=session.getAttribute("adminid") %>님, 환영합니다.</li>
		<li style="display:inline"><a href="/admin/logout" id="adMainOut">로그아웃</a></li>
	</ul>    
  </div>
<%@ include file = "./admin/adminpage.jsp" %>
<% }  %>

