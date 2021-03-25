<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 리스트</title>
<style>
div.gallery {
  border: 1px solid #ccc;
  width: 300px;
  height: 300px;
}

div.gallery:hover {
  border: 1px solid #777;
}

div.gallery img {
  width: 300px;
  height: 300px;
}

div.desc {
  padding: 15px;
  text-align: center;
}

/*  {  */
/*  box-sizing: border-box;  */
/*  } */

 .responsive { 
   padding: 0 6px;  
float: left; 
/*  width: 24.99999%; */
 } 

@media only screen and (max-width: 700px) {
  .responsive {
    width: 49.99999%;
    margin: 6px 0;
  }
}

@media only screen and (max-width: 500px) {
  .responsive {
    width: 100%;
  }
}

.clearfix:after {
  content: "";
  display: table;
  clear: both;
}
</style>
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
</head>
<body>
 <form name="frm" method="post">
<div id="haeder">
    <jsp:include page="/member/Header.jsp"/>
    </div>
             <div >
             <input class="search" type="text" name="add" placeholder="주소 검색창입니다."> 
             <input type="submit" value="검색" onclick="myFunction()">
            </div>
            <table border="1" align="center" class="new">
		<tr>
			<td colspan="4" align="center"><h2>검색리스트</h2></td>
		</tr>
		<tr>
			<td align="center">이미지</td>
			<td align="center">내용</td>
		</tr>
 <c:forEach var="pl" items="${productsearch}">
 <tr align="center">
			<td> <a href="/Ginger/member/productdetail.do?pseq=${pl.pseq}">
      <img src="/Ginger/img/${pl.image}" alt="Cinque Terre" width="300" height="300">
    </a></td>
			<td>${pl.name}<br>
    <c:choose>
        	<c:when test="${pl.price2 == 0}">입장료 : 무료</c:when>
        	<c:when test="${pl.price2 != 0}">입장료 : ${pl.price2} 원</c:when></c:choose><br>
        	추천수 : ♥ ${pl.state}<br>
        	 주소 : ${pl.address}</td>
        	
		</tr>	</c:forEach>
	</table>
</form>
</body>
</html>