<%@page import="dao.AdminDao"%>
<%@page import="controls.MemberDeleteController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="dto.GingerMember"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<style type="text/css">
td, th {
	border: 1px solid black;
}

table {
	width: 800px;
	border
	-
	collapse
	:
	collapse;
}
.content{
position:absolute;
  width:800px;
  height:400px;
  padding: 20px, 10px;
  background-color:#FFFFFF;
  text-align:center;
  top:50%;
  left:50%;
  transform: translate(-50%,-50%);
  border-radius: 10px;
}
</style>
</head>
<body>
	<jsp:include page="adminHeader.jsp" />
<form name="frm" method="post" class="content">
	<%  AdminDao dao = new AdminDao();

		int count = dao.selectCnt(); // 전체 행 갯수 
		
		String tempStart = request.getParameter("page");
		// 현재 페이지를 받아옴 
		int startPage = 0; // limit의 시작값 첫 limit 0, 10 
		int onePageCnt = 10; // 한페이지에 출력할 행의 갯수  

		count = (int)Math.ceil((double) count / (double) onePageCnt);
		// 페이지 수 저장 -->

		if (tempStart != null) { // 처음에는 실행 x -->
			startPage = (Integer.parseInt(tempStart)-1)*onePageCnt;
		}
		Vector<GingerMember> m = dao.selectPage("MEMBER", startPage, onePageCnt);
	%>
	<table border="1">
		<tr>
			<th colspan="10" style="font-size: 40px">회원 목록</th>
		</tr>
		<tr>
			<th>회원번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>핸드폰</th>
			<th>이메일</th>
			<th width="70">회원유지</th>
			<th>셍성날짜</th>
			<th>수정날짜</th>
			<th>삭제</th>
		</tr>
		<%
			for (int i = 0; i < m.size(); i++) {
		%>
		    <tr align="center">
			<td><a href='adminupdate.do?id=<%=m.get(i).getId()%>'><%=m.get(i).getMno()%></a></td>
			<td><%=m.get(i).getId()%></td>
			<td><%=m.get(i).getPassword()%></td>
			<td><%=m.get(i).getName()%></td>
			<td><%=m.get(i).getPhone()%></td>
			<td><%=m.get(i).getEmail()%></td>
			<td><%if (m.get(i).getUseyn().equals("n")) { %> 
				      <span>삭제요청</span> <% } else if(m.get(i).getUseyn().equals("y")){ %>
						<span>회원유지</span> </td>
						<%
				}
			%>	
			<td><%=m.get(i).getCreateDate()%></td>
			<td><%=m.get(i).getModifiedDate()%></td>
			<td><a href='admindelete.do?id=<%=m.get(i).getId()%>'>삭제</a></td>

		</tr>
		<%}%>
	</table><br>
	<%for (int j = 1; j <= count; j++) {%>
	<a href="adminMemberList.jsp?page=<%=j%>">[<%=j%>]
	</a>
	<%
		};
	%>
	<br>
	</form>
</body>
</html>
