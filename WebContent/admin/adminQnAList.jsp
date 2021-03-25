<%@page import="dao.QnADao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="dto.GingerQnA"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 문의 게시판</title>
<script type="text/javascript">
	
</script>
<style type="text/css">
.content{
position:absolute;
  width:500px;
  height:400px;
  padding: 30px, 20px;
  background-color:#FFFFFF;
  text-align:center;
  top:50%;
  left:50%;
  transform: translate(-50%,-50%);
  border-radius: 15px;
}
a { text-decoration : none ; }

</style>
</head>
<body>
	<div id="header">
		<jsp:include page="/admin/adminHeader.jsp" />
	</div>
	<form name="frm" method="post"  class="content">
		<%
			QnADao dao = new QnADao();

			int count = dao.selectCnt(); // 전체 행 갯수 

			String tempStart = request.getParameter("page");
			// 현재 페이지를 받아옴 
			int startPage = 0; // limit의 시작값 첫 limit 0, 10 
			int onePageCnt = 10; // 한페이지에 출력할 행의 갯수  

			count = (int) Math.ceil((double) count / (double) onePageCnt);
			// 페이지 수 저장 -->

			if (tempStart != null) { // 처음에는 실행 x -->
				startPage = (Integer.parseInt(tempStart) - 1) * onePageCnt;
			}
			Vector<GingerQnA> v = dao.selectPage("QNA", startPage, onePageCnt);
		%>
		<table border="1">
			<tr>
				<th colspan="7" style="font-size: 40px">문의 목록</th>
			</tr>
			<tr>
				<th>문의번호</th>
				<th>아이디</th>
				<th>제목</th>
				<th>답변여부</th>
				<th>질문날짜</th>
			</tr>
			<%
				for (int i = 0; i < v.size(); i++) {
			%>
			<tr align="center">
				<td><%=v.get(i).getQseq()%></td>
				<td><%=v.get(i).getId()%></td>
				<td><%=v.get(i).getSubject()%></td>
				<td><a href='adminQnAreply.do?qseq=<%=v.get(i).getQseq()%>'>
						<%
							if (v.get(i).getRep().equals("1")) {
						%> <span>답변기다리는 중</span> <%
 	} else {
 %>
						<span>답변완료!</span> <%
 	}
 %>
				</a></td>
				<td><%=v.get(i).getCRE_DATE()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<br>
		<%
			for (int k = 1; k <= count; k++) {
		%>
		<a href="adminQnAList.jsp?page=<%=k%>">[<%=k%>]
		</a>
		<%
			}
			;
		%>
		
		<br>

	</form>
</body>
</html>