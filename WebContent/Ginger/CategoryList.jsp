<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 리스트</title>
<style type="text/css">
.new {
  width: 80%;
    margin: 60px;
}

</style>
</head>
<body>

<div id="haeder">
    <jsp:include page="/member/Header.jsp"/>
    </div>
     <c:choose>
	<c:when test="${sessionScope.member == null}">
	    <table> 
            <tr><td><c:choose>
        	<c:when test="${productList[0].kind == 1}"><h3>실내시설</h3></c:when>
        	<c:when test="${productList[0].kind == 2}"><h3>여행지</h3></c:when>
        	<c:when test="${productList[0].kind == 3}"><h3>목줄없는 댕댕공원</h3></c:when>
        	</c:choose></td></tr></table>
 <c:forEach var="pl" items="${productList}">
<div class="responsive">
  <div class="gallery">
      <img src="/Ginger/img/${pl.image}" alt="Cinque Terre" width="600" height="400">
    <div class="desc">${pl.name}/${pl.content}/추천${pl.state} 개/ 입장료 : ${pl.price2} 원</div>
  </div>
</div>
</c:forEach>
		</c:when>
	<c:otherwise>
	
	<table border="1" align="center" class="new">
		<tr>
			<td colspan="4" align="center"><c:choose>
        	<c:when test="${productList[0].kind == 1}"><h3>실내시설</h3></c:when>
        	<c:when test="${productList[0].kind == 2}"><h3>여행지</h3></c:when>
        	<c:when test="${productList[0].kind == 3}"><h3>목줄없는 댕댕공원</h3></c:when>
        	</c:choose></td>
		</tr>
		<tr>
			<td align="center">이미지</td>
			<td align="center">내용</td>
		</tr>
	<c:forEach var="pl" items="${productList}">
		<tr align="center">
			<td> <a href="/Ginger/member/productdetail.do?pseq=${pl.pseq}">
      <img src="/Ginger/img/${pl.image}" alt="Mountains" width="300" height="300">
    </a></td>
			<td>${pl.name}<br>
    <c:choose>
        	<c:when test="${pl.price2 == 0}">입장료 : 무료</c:when>
        	<c:when test="${pl.price2 != 0}">입장료 : ${pl.price2} 원</c:when></c:choose><br>
        	추천수 : ♥ ${pl.state}<br>
        	 주 소 : ${pl.address}</td>
		</tr>
		</c:forEach>
	</table>
	</c:otherwise>
	</c:choose>
</body>
</html>