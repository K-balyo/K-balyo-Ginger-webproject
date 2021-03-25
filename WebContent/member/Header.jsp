<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dto.GingerMember"%>
<%@ page import="dto.GingerAdmin"%>
<%@ page import="java.util.*"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <style type = "text/css">
   
    ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: white;
}
li {
  float: left;
  border-right: 1px solid #bbb;
}
li:last-child {
  border-right: none;
}
li.dropdown {
  display: inline-block;
}
/* 드롭다운 메뉴 내용 배경 */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: white;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

/* 드롭다운 메뉴 내용 글씨색 */
.dropdown-content a { 
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
background-color: #f1f1f1;
}
/* 헤더 글씨 색*/
li a, .dropbtn {
  display: inline-block;
/*   color: yellow; */
  color: black; 
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown:hover .dropdown-content {
  display: block;
 
}
/* 로그아웃 항목 배경 글씨색 */
li a {
  display: block;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}
/* 헤더 마우스 올릴시 색상변화 */
li a:hover, .dropdown:hover .dropbtn {
/*   background-color: #111; */
  background-color: lightgray;
    background-position: right;
}
.active {
/*   background-color: #4CAF50; */
  background-color: white ;
}
.search{
 margin: 10px;

}
  </style>
  <script type="text/javascript">
function myFunction(){
	frm.action="/Ginger/Ginger/search.do";
}
</script>
    
    <c:choose>
	<c:when test="${sessionScope.member == null}">
	<ul>
    <li><a class="active">Home</a></li>
	<li><a style="color: black;" href="/Ginger/Ginger/LoginForm.jsp">로그인</a></li>
	<li><a style="color: black;" href="/Ginger/Ginger/AddMember.jsp">회원가입</a></li>
	<li style="float:right"><a style="color: black;" >로그인 후 사용 해 주세요 </a></li>
	 
	</ul>
	
	</c:when>
    <c:otherwise>
    <c:set var="member" value="${sessionScope.member}" > </c:set>
    <ul>
     <li><a class="active" href="/Ginger/Ginger/index.do">Home</a></li>
             <li class="dropdown"><a href="javascript:void(0)" class="dropbtn">떠나즈아!</a>
             <div class="dropdown-content">
             <a href="/Ginger/Ginger/category.do?kind=1">실내시설</a>
             <a href="/Ginger/Ginger/category.do?kind=2">여행지</a>
             <a href="/Ginger/Ginger/category.do?kind=3">목줄없는 댕댕's놀이터</a>
             </div></li>
              <li class="dropdown"><a href="javascript:void(0)" class="dropbtn">자유게시판</a>
             <div class="dropdown-content">
             <a href="/Ginger/B-board/BoardList.do?page=1&form=all">자유게시판</a>
             <a href="/Ginger/B-board/MyBoardList.do?id=${member.id}&page=1&form=all">내가 쓴글</a>    
             <a href="/Ginger/B-board/BoardWrite.jsp">게시판 글 작성</a>                      
             </div></li>
             <li class="dropdown"><a href="javascript:void(0)" class="dropbtn">마이페이지</a>
             <div class="dropdown-content">
             <a href="/Ginger/member/mlist.do?id=${member.id}">회원정보</a>
             <a href="/Ginger/Ginger/pickList.do?id=${member.id}">찜 목록</a> 
             <a href="/Ginger/QnA/mql.do?id=${member.id}">문의 내역</a>
             <a href="/Ginger/QnA/QnAWrite.jsp">1:1 문의</a> 
             <a href="/Ginger/member/logout.do">로그아웃</a>
             </div></li>
             <li style="float:right"><a style="color: balck;" >환영합니다 ${member.name} 님 </a></li>
             </ul>
             
   </c:otherwise>
	</c:choose>

