<%@page import="dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="dto.GingerProduct"%>
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
  border-radius: 15px;
}
a { text-decoration : none ; }
</style>
</head>
<body>
	<jsp:include page="adminHeader.jsp" />
<form name="frm" method="post" class="content">
	<%  ProductDao dao = new ProductDao();

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
		Vector<GingerProduct> ap = dao.selectPage("PRODUCT", startPage, onePageCnt);
	%>
	<table border="1">
		<tr>
			<th colspan="7" style="font-size: 40px">상품 목록</th>
		</tr>
		<tr>
			<th>상품번호</th>
			<th>명칭</th>
			<th>내용</th>
			<th>추천수</th>
			<th>입장료</th>
			
		</tr>
		<%
			for (int i = 0; i < ap.size(); i++) {
		%>
		    <tr align="center">
			<td><a href='/Ginger/admin/adminproductupdate.do?pseq=<%=ap.get(i).getPseq()%>'><%=ap.get(i).getPseq()%></a></td>
			<td><%=ap.get(i).getName()%></td>
			<td><%=ap.get(i).getContent()%></td>
			<td><%=ap.get(i).getState()%></td>
			<td><%=ap.get(i).getPrice2()%></td>

		</tr>
		<%}%>
	</table><br>
	<%for (int j = 1; j <= count; j++) {%>
	<a href="adminProductlist.jsp?page=<%=j%>">[<%=j%>]
	</a>
	<%
		};
	%>
	<br>
	</form>
</body>
</html>
