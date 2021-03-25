 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="dto.GingerMember"%>
   <%@ page import="dao.MySqlMemberDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 체크</title>    
 <script type="text/javascript">
   function sendCheckValue(){
	   try{
	   opener.document.userInfo.idDuplication.value="idCheck";
	   self.close();
	   }catch(e){
		   alert(e);
	   }
	  
   }
</script>
</head>
<body>
<form name="frm" method="post">
   <c:set var="member" value="${member}"></c:set>
<c:choose>
<c:when test="${empty member}">
   사용 가능 아이디입니다.
<input type="button" value="사용하기" onClick="sendCheckValue()"/>
</c:when>
<c:otherwise>
사용 불가능 아이디입니다.
<input type="button" value="닫기" onClick="window.close()"/>
</c:otherwise>
</c:choose>
         </form>   
</body>
</html>