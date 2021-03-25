<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찜 목록</title>
 <script type="text/javascript">
	function btn(str , pseq) {
		if(str == "delete"){
			alert("삭제 완료하였습니다.")
			frm.action = "/Ginger/Ginger/deletepick.do?pseq="+pseq+"&id="+${member.id};
			frm.submit();
		}
	}
	</script>
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
</head>
<body>
<form name="frm" method="post">
<div id="haeder">
    <jsp:include page="/member/Header.jsp"/>
    </div>
     <c:choose>
	<c:when test="${sessionScope.member == null}">
	로그인 후 사용해 주세요
	</c:when>
	<c:otherwise>
	
 <c:forEach var="pl" items="${pickList}">
<div class="responsive">
<c:set var="member" value="${sessionScope.member}" > </c:set>
  <div class="gallery">
    <a href="/Ginger/member/productdetail.do?pseq=${pl.pseq}">
      <img src="/Ginger/img/${pl.image}" alt="Cinque Terre" width="600" height="400">
    </a>
    <div class="desc">${pl.pname}   <c:choose>
        	<c:when test="${pl.price2 == 0}">무료이용</c:when>
        	<c:when test="${pl.price2 != 0}">입장료 : ${pl.price2} 원</c:when></c:choose>원  주소:${pl.address} 추천수 : ♥ ${pl.state}
        	<input type="button" value="삭제" onclick='btn("delete", ${pl.pseq});'></div>
        	
  </div>
</div>
</c:forEach>

	</c:otherwise>
	</c:choose>
	</form>
</body>
</html>