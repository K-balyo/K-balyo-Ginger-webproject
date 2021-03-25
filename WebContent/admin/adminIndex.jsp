<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.addForm {
  position:absolute;
  width:500px;
  height:400px;
  padding: 30px, 20px;
  background-color:#FFFFFF;
  text-align:center;
  top:50%;
  left:50%;
  transform: translate(-50%,-50%);
  border-radius: 15px;
}
</style>
<meta charset="UTF-8">
<title>메인 페이지</title>
<script type="text/javascript">
function btn(str){
	if(str == "memberlist"){
	frm.action="/Ginger/admin/list.do";
	frm.submit();
	}else if(str == "qnalist"){
    frm.action="/Ginger/admin/adminqna.do";	
    frm.submit();
	}else if(str == "insert"){
		frm.action="/Ginger/admin/adminUpload.jsp";
			frm.submit();
	}else if(str == "categorylist"){
		frm.action="/Ginger/admin/adminCategoryList.do";
		frm.submit();
	}
}
</script>

</head>
<body>
<div id="haeder">
    <jsp:include page="/admin/adminHeader.jsp"/>
    </div>
<form name="frm" method="post" class="addForm">
    <c:choose>
	<c:when test="${sessionScope.admin == null}">
	<div class="desc">로그인 먼저 ~</div>
	</c:when>
	<c:otherwise>
    <input type="button" value="회원 목록" onclick='btn("memberlist");'> 
    <input type="button" value="문의 리스트" onclick='btn("qnalist");'> 
    <input type="button" value="상품 등록" onclick='btn("insert");' > 
    <input type="button" value="상품 목록" onclick='btn("categorylist");' > 

	</c:otherwise>
	</c:choose>
	</form>
</body>
</html>