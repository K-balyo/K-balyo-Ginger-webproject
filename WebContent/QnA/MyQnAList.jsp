<%@page import="dao.QnADao"%>
<%@page import="dto.GingerMember"%>
<%@page import="dto.GingerQnA"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 내역</title>
<script type="text/javascript">
function myFunction(){
	frm.action="/Ginger/Ginger/search.do";
}
</script>
<style type="text/css">
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
 <c:choose>
	<c:when test="${sessionScope.member == null}">
	 <div id="header">
   <jsp:include page="/member/Header.jsp"/>
   </div>
   로그인 후 사용해 주세요
	</c:when>
		<c:otherwise>
 <div id="header">
   <jsp:include page="/member/Header.jsp"/>
   </div>
<form name="frm" method="post" class="content">
<%
         GingerMember loginInfo = (GingerMember) session.getAttribute("member");
       
		    QnADao dao = new QnADao();
 
		    int count = dao.mselectCnt(loginInfo.getId()); // 전체 행 갯수 
	
			String tempStart = request.getParameter("page");
			// 현재 페이지를 받아옴 
			int startPage = 0; // limit의 시작값 첫 limit 0, 10 
			int onePageCnt = 10; // 한페이지에 출력할 행의 갯수  

			count = (int) Math.ceil((double) count / (double) onePageCnt);
			// 페이지 수 저장 -->

			if (tempStart != null) { // 처음에는 실행 x -->
				startPage = (Integer.parseInt(tempStart) - 1) * onePageCnt;
			}
			Vector<GingerQnA> v = dao.mselectPage("QNA",loginInfo.getId(), startPage, onePageCnt);
		%>
		
<table border="1">
<tr>		
<th colspan="6" style="font-size: 40px">문의 내역</th>
</tr>
            <tr>
        	<th>  질문번호   </th>
        	<th> 제목   </th>
        	<th> 답변여부  </th>
        	<th>  질문날짜   </th>
        	</tr>
        	<%
				for (int i = 0; i < v.size(); i++) {
			%>
			<tr align="center">
				<td><%=v.get(i).getQseq()%></td>
				<td><a href='boarddetail.do?qseq=<%=v.get(i).getQseq()%>'><%=v.get(i).getSubject()%></a></td>
				<td><%if (v.get(i).getRep().equals("1")) { %> 
				      <span>답변기다리는 중</span> <% } else { %>
						<span>답변완료!</span> </td>
						<%
				}
			%>
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
		<a href="MyQnAList.jsp?page=<%=k%>">[<%=k%>]
		</a>
		<%
			}
			;
		%> <button>  <a href="/Ginger/QnA/QnAWrite.jsp">글쓰기</a></button>
		<br>
</form>
</c:otherwise>
	</c:choose>
</body>
</html>