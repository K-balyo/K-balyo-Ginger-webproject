<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="dto.GingerProduct"%>
<%@page import="java.util.ArrayList"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
 <script type="text/javascript">
	function btn(str) {
		if(str == "pick"){
			frm.action = "/Ginger/Ginger/pick.do?pseq="+${product.pseq}+"&id="+${member.id};
			frm.submit();
		alert("찜뽕했습니다")			
		}else if(str == "alreadypick"){
			alert("이미 찜뽕했었어요")
		}else if(str == "like"){
			frm.action = "/Ginger/Ginger/likey.do?pseq="+${product.pseq}+"&id="+${member.id};
			frm.submit();
			alert("좋아용")
		}else if(str == "dislike"){
			frm.action = "/Ginger/Ginger/dislikey.do?pseq="+${product.pseq}+"&id="+${member.id};
			frm.submit();
			alert("좋아요 취소")
		}else if(str == "back"){
			frm.action = "/Ginger/Ginger/index.do";
			frm.submit();
		}
	}
	</script>
<style type="text/css">
.quantity {
	text-indent: 30px;
}

#header {
	background-color: black;
	height: 150px;
}

#nav {
	background-color: green;
	width: 200px;
	height: 300px;
	float: left;
}

#section {
	width: 600px;
	height: 200px;
	float: left;
	padding: 10px;
}

#footer {
	background-color: #FFCC00;
	height: 100px;
	clear: both;
}
a { text-decoration : none ; }
</style>
</head>
<body>
	<form name="frm" method="post">
		<div id="header">
			<jsp:include page="/member/Header.jsp"/>
		</div>
 <c:choose>
	<c:when test="${sessionScope.member == null}">
		<div id="section">
			<fieldset>
				<legend> 상세 정보 </legend>
				<span style="float: left"> <img
					src="/Ginger/img/${product.image}" width="300px"
					height="200px">
				</span>
				<h2 align="center">${product.name}</h2>
				<h3 class="quantity">
					<label> 입장료 : ${product.price2} 원 </label><br>
					<label> 주소 : ${product.address} </label><br>
					<label> 추천수 : ${product.state} 개 </label><br>
				</h3>
				<hr />
			</fieldset>
			<div class="clear"></div>
			<c:set var="member" value="${sessionScope.member}" > </c:set>
			<div id="buttons" align="center">
				 <a href="/Ginger/Ginger/index.do">[찜하기]</a>
				 <a href="/Ginger/Ginger/index.do">[추천이용]</a>
				<a href="/Ginger/Ginger/index.do">[메인으로]</a>
			</div>
		</div>
		</c:when>
	<c:otherwise>
		<div id="section">
			<fieldset>
				<legend> 상세 정보 </legend>
				<span style="float: left"> <img
					src="/Ginger/img/${product.image}" width="300px"
					height="200px">
				</span>
				<h2 align="center">${product.name}</h2>
				<h3 class="quantity">
					<label> 
					<c:choose>
        	<c:when test="${product.price2 == 0}">무료이용</c:when>
        	<c:when test="${product.price2 != 0}">입장료 : ${product.price2} 원</c:when></c:choose>
					 </label><br>
					<label> 주소 : ${product.address} </label><br>
					<label> 추천수 : ♥ ${product.state}  </label><br>
				</h3>
				<hr />
			</fieldset>
			<div class="clear"></div>
			
		   
			<div id="buttons" align="center">
			<c:set var="member" value="${sessionScope.member}" > </c:set>
			 <c:set var="pk" value="false" />
		    <c:forEach var="pick" items="${sessionScope.pickList}" varStatus="status">
		     <c:if test="${not pk}">
		     <c:if test="${pick.pseq == product.pseq }">
		       <c:set var="pk" value="true" >
		       </c:set>
		       </c:if>
		     </c:if>
		    </c:forEach>
		    <input type="button" value="찜하기" 
		           ${pk == false ? "onclick=btn('pick');" : "onclick=btn('alreadypick');"}> 
		           
			<c:set var="lk" value="false" />
		    <c:forEach var="like" items="${sessionScope.likeList}" varStatus="status1">
		     <c:if test="${not lk}">
		     <c:if test="${like.pseq == product.pseq }">
		       <c:set var="lk" value="true" >
		       </c:set>
		       </c:if>
		     </c:if>
		    </c:forEach>
		    <input type="button" 
		           ${lk == false ? "value='♡'  onclick=btn('like');" : "value='♥' onclick=btn('dislike');"}> 
			<input type="button" value="메인으로" onclick='btn("back");'>
			</div>
		</div>	</c:otherwise>
	</c:choose>
	</form>
</body>
</html>