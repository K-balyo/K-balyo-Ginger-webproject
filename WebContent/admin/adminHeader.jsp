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
  background-color: #333;
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
  background-color: yellow;
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
  color: yellow;
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
  color: yellow;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}
/* 헤더 마우스 올릴시 색상변화 */
li a:hover, .dropdown:hover .dropbtn {
/*   background-color: #111; */
  background-color: green;
}
.active {
/*   background-color: #4CAF50; */
  background-color: black ;
}
  </style>
    
    <c:choose>
	<c:when test="${sessionScope.admin == null}">
	<ul>
    <li><a class="active">Home</a></li>
	<li><a style="color: lightgrey;" href="/Ginger/admin/adminLoginForm.jsp">로그인</a></li>
	<li><a style="color: lightgrey;" href="/Ginger/admin/AddAdmin.jsp">회원가입</a></li>
	<li style="float:right"><a style="color: lightgrey;" >로그인 후 사용 해 주세요 </a></li>
	</ul>
	</c:when>
    <c:otherwise>
    <c:set var="admin" value="${sessionScope.admin}" > </c:set>
    <ul>
	 <li><a class="active" href="/Ginger/admin/adminindex.do">Home</a></li>
	         <li class="dropdown"><a href="javascript:void(0)" class="dropbtn">회원관리</a>
             <div class="dropdown-content">
             <a href="/Ginger/admin/list.do">회원목록</a>
             </div></li>
             <li class="dropdown"><a href="javascript:void(0)" class="dropbtn">상품관리</a>
             <div class="dropdown-content">
             <a href="/Ginger/admin/adminUpload.jsp">상품등록</a>
             <a href="/Ginger/admin/adminCategoryList.do">상품리스트</a>
             </div></li>
             <li class="dropdown"><a href="javascript:void(0)" class="dropbtn">고객센터</a>
             <div class="dropdown-content">
             <a href="/Ginger/admin/adminqna.do">문의 리스트</a>
             </div></li>
             <li><a href="/Ginger/admin/adminlogout.do">로그아웃</a></li>
             <li style="float:right"><a style="color: lightgrey;" >환영합니다 ${admin.id} 관리자 님 </a></li>
             </ul>
   </c:otherwise>
	</c:choose>

