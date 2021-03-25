<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 문의 상세 정보창</title>

<style type="text/css">

 a { text-decoration : none ; }

</style>
</head>
<body>
		<div id="header">
			<jsp:include page="/member/Header.jsp"/>
		</div>
<form name="frm" method="post" action="/QnA/mql.do?id=${member.id}">
		<c:set var="qna" value="${qna}"></c:set>
		<table align="center" border="1" width="560">
   <tr>
        <td width="550" colspan="2" style="text-align:center; font-size : 15pt ; font-weight:bold ; background-color: skyblue ;">
           1:1문의 내역
        </td>
    </tr>
    <tr>
    <th>문의 상태</th>
    <td><c:choose>
    <c:when test="${qna.rep == 1}">답변기다리는 중</c:when>
    <c:when test="${qna.rep == 2}">답변 완료</c:when>
    </c:choose>
    </tr>
   <tr>
   <th>문의 제목</th>
   <td><input type="text" name="subject" value="${qna.subject}" size="50" readonly></td>
   </tr>
   <tr>
   <th>아이디</th>
   <td><input type="text" name="id" size="50" value="${qna.id}" readonly></td>
   </tr>
   <tr>
   <th>문의내용</th>
   <td><textarea name="content" rows="9" cols="50" readonly>${qna.content}</textarea></td>
   </tr>
   <tr>
   <th>답변내용</th>
   <td><textarea name="reply" rows="9" cols="50"  readonly>${qna.reply}</textarea></td>
   </tr>
   <tr>
   <td colspan="2" style="text-algin:center; background-color: skyblue;">
   <button> <a href="/Ginger/QnA/mql.do?id=${member.id}" role="button">목록으로</a></button> 
   </td>
   </table>
   </form>
</body>
</html>