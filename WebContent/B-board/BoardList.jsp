<%@page import="dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="dto.GingerBoard"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유 게시판</title>
<script type="text/javascript">
function btn(str){
		if(str == "search"){
			var option = document.getElementById("sh").options;
			var form = "";
			for(i=0; i<option.length;i++){
				if( option[i].selected ==true ){
					form =option[i].value 
				}
			}
				document.getElementById("frm").action = "/Ginger/B-board/BoardList.do?my=null&page=1&form="+form;
				document.getElementById("frm").submit();
		}
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
.bsearch{
  
  margin: 30px;
  padding: 10px 10px;
}
a { text-decoration : none ; }
.s {
  width: 50%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}
</style>
</head>
<body>
	<div id="header">
		<jsp:include page="/member/Header.jsp"/>
   </div>
	<div class="content">
	<form name="frm" method="post" id="frm"  >
	<select name="sh" id="sh">
	<c:set var="lk" value="${formvalue}" />
	<option value="id"  ${lk == "id" ? "selected" : "" } >아이디</option>
	<option value="sub" ${lk == "sub" ? "selected" : "" }>제목</option>
    <option value="con" ${lk == "con" ? "selected" : "" }>내용</option>
	<option value="rep" ${lk == "rep" ? "selected" : "" }>제목+조회수</option>
	<option value="likey" ${lk == "likey" ? "selected" : "" }>제목+인기순</option>
	</select>
	<input type="text" name="searchn" placeholder="검색어를 입력하세요" class="s"> 
    <input type="submit" value="검색" onclick='btn("search")'>
    <button> <a href="/Ginger/B-board/BoardWrite.jsp">글쓰기</a></button>
    	</form>
		<table border="1" > 
			<tr>
				<th colspan="8" style="font-size: 40px">게시글 목록</th>
			</tr>
			<tr>
				<th>게시글번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>추천수</th>
				<th>조회수</th>
				<th>질문날짜</th>
			</tr>
			<c:forEach var="b" items="${board}">
			<tr>
			<td>${b.bseq}</td>
			<td>${b.id}</td>
			<td><a href='boarddetail.do?bseq=${b.bseq}'>${b.subject}</a></td>
			<td>${b.likey}</td>
			<td>${b.rep}</td>
			<td>${b.CRE_DATE}</td>
			</tr>
			 </c:forEach>	
		</table>
		<br>
		<br>
		<c:forEach var="cnt" begin="1" end="${countlist }">
		<a href="BoardList.jsp?page="${cnt}>[${cnt}]</a>
		</c:forEach>
		</div>
</body>
</html>