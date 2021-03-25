<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Content-Type" content="text/html; charset=UTF-8" >
<title>생강 프로젝트</title>


<script type="text/javascript">
function myFunction(){
	frm.action="/Ginger/Ginger/search.do";
}
</script>
<style type="text/css">
.new {
  width: 80%;
    margin: 60px;
}

</style>
<body>

<form name="frm" method="post">
    <div id="haeder">
    <jsp:include page="/member/Header.jsp"/>
    </div>
      <div >
    <input align="center" class="search" type="text" name="add" placeholder="주소 검색창입니다."> 
     <input type="submit" value="검색" onclick="myFunction()"> </div>
   
     
    <c:choose>
	<c:when test="${sessionScope.member == null}">
		
		<table border="1" align="center" class="new">
		<tr>
			<td colspan="4" align="center"><h2>핫하고 힙한 곳</h2></td>
		</tr>
		<tr>
			<td align="center">이미지</td>
			<td align="center">내용</td>
		</tr>
		<c:forEach var="n" items="${productlist2}">
		<tr align="center">
			<td> 
      <img src="/Ginger/img/${n.image}" alt="Cinque Terre" width="300" height="300"></td>
			<td>${n.name}<br>
			 <c:choose>
        	<c:when test="${n.price2 == 0}">입장료 : 무료</c:when>
        	<c:when test="${n.price2 != 0}">입장료 : ${n.price2} 원</c:when>
        	</c:choose><br>
                          추천수 : ♥ ${n.state}<br>
                           주 소 :${n.address}</td>
		</tr>
		</c:forEach>
	</table>
<table border="1" align="center" class="new">
		<tr>
			<td colspan="4" align="center"><h2>새로 추가된 곳</h2></td>
		</tr>
		<tr>
			<td align="center">이미지</td>
			<td align="center">내용</td>
		</tr>
	<c:forEach var="h" items="${productlist}">
		<tr align="center">
			<td> 
      <img src="/Ginger/img/${h.image}" alt="Mountains" width="300" height="300">
    </td>
			<td>${h.name}<br>
    <c:choose>
        	<c:when test="${h.price2 == 0}">입장료 : 무료</c:when>
        	<c:when test="${h.price2 != 0}">입장료 : ${h.price2} 원</c:when></c:choose><br>
        	추천수 : ♥ ${h.state}<br>
        	 주 소 : ${h.address}</td>
		</tr>
		</c:forEach>
	</table>
	</c:when>
	<c:otherwise>
	
		<table border="1" align="center" class="new">
		<tr>
			<td colspan="4" align="center"><h2>핫하고 힙한곳</h2></td>
		</tr>
		<tr>
			<td align="center">이미지</td>
			<td align="center">내용</td>
		</tr>
		<c:forEach var="n" items="${productlist2}">
		<tr align="center">
			<td> <a href="/Ginger/member/productdetail.do?pseq=${n.pseq}">
      <img src="/Ginger/img/${n.image}" alt="Cinque Terre" width="300" height="300"></a></td>
			<td>${n.name}<br>
			 <c:choose>
        	<c:when test="${n.price2 == 0}">입장료 : 무료</c:when>
        	<c:when test="${n.price2 != 0}">입장료 : ${n.price2} 원</c:when>
        	</c:choose><br>
                          추천수 : ♥ ${n.state}<br>
                           주 소 :${n.address}</td>
		</tr>
		</c:forEach>
	</table>

<table border="1" align="center" class="new">
		<tr>
			<td colspan="4" align="center"><h2>새로 추가된곳</h2></td>
		</tr>
		<tr>
			<td align="center">이미지</td>
			<td align="center">내용</td>
		</tr>
	<c:forEach var="h" items="${productlist}">
		<tr align="center">
			<td> <a href="/Ginger/member/productdetail.do?pseq=${h.pseq}">
      <img src="/Ginger/img/${h.image}" alt="Mountains" width="300" height="300">
    </a></td>
			<td>${h.name}<br>
    <c:choose>
        	<c:when test="${h.price2 == 0}">입장료 : 무료</c:when>
        	<c:when test="${h.price2 != 0}">입장료 : ${h.price2} 원</c:when></c:choose><br>
        	추천수 : ♥ ${h.state}<br>
        	 주 소 : ${h.address}</td>
		</tr>
		</c:forEach>
	</table>
	</c:otherwise>
	</c:choose>
	</form>
</body>
</html>