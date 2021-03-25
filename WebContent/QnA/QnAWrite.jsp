<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의하기</title>
<script type="text/javascript">
	function btn(str) {
	if (str == "join") {
		var subject = document.userInfo.subject.value;
		var content = document.userInfo.content.value;
		var id = document.userInfo.id.value;
		if (id == "") {
			alert("아이디를 입력해 주세요!!!");
			document.userInfo.id.focus();
			return false;
		}else if(subject == ""){
            alert("제목을 입력하세요.");
            document.userInfo.subject.focus();
            return false;
        }else if(content == ""){
            alert("내용을 입력하세요.");
            document.userInfo.content.focus();
            return false;
        }else{
        	userInfo.action="/Ginger/QnA/qnaadd.do"
        	}
        }
	}
</script>
<style type="text/css">

 a { text-decoration : none ; }

</style>
</head>
<body>
 <div id="header">
   <jsp:include page="/member/Header.jsp"/>
   </div>
   <form   method="post" onsubmit="return btn('join');"name="userInfo" >
    <c:set var="member" value="${sessionScope.member}" > </c:set>
   <div id="section">
   <h3>고객 문의 게시판</h3>
   <table align="center" border="1" width="560">
   <tr>
        <td width="550" colspan="2" style="text-align:center; font-size : 15pt ; font-weight:bold ; background-color: skyblue ;">
           문의게시판
        </td>
    </tr>
   <tr>
   <th>문의 제목</th>
   <td><input type="text" name="subject" id="subject" maxlength="100" size="50"/></td>
   </tr>
   <tr>
   <th>아이디</th>
   <td><input type="text" name="id" size="50" value="${member.id}" readonly></td>
   </tr>
   <tr>
   <th>내용</th>
   <td><textarea name="content" id="content" rows="9" cols="50"></textarea></td>
   </tr>
   <tr>
   <td colspan="2" style="text-algin:center; background-color: skyblue;">
   <input type="submit" value="글쓰기"  >
   <input type="reset" value="내용 지우기" class=button>
   </td>
   </table>
   </div>
   </form>
</body>
</html>