<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 상세 페이지</title>
<script type="text/javascript">
	function btn(str) {
		if(str == "like"){
			frm.action = "/Ginger/B-board/boardlikey.do?bseq="+${board.bseq}+"&id="+${member.id};
			frm.submit();
			alert("좋아용")
		}else if(str == "dislike"){
			frm.action = "/Ginger/B-board/boarddislikey.do?bseq="+${board.bseq}+"&id="+${member.id};
			frm.submit();
			alert("좋아요 취소")
		}else if(str == "back"){
			frm.action = "/Ginger/B-board/BoardList.do?page=1&form=all";
			frm.submit();
		}
	}
	</script>
<style type="text/css">

 a { text-decoration : none ; }

</style>
</head>
<body>
<form name="frm" method="post" ">
		<div id="header">
			<jsp:include page="/member/Header.jsp"/>
		</div>

	<c:choose>
	<c:when test="${sessionScope.member == null}">
		<div id="section">
			<fieldset>
				<legend> 로그인 후 이용해 주세요 </legend>
				
			</fieldset>
		</div>
		</c:when>
	<c:otherwise>
		<c:set var="board" value="${board}"></c:set>
		<table align="center" border="1" width="560">
   <tr>
        <td width="550" colspan="2" style="text-align:center; font-size : 15pt ; font-weight:bold ; background-color: skyblue ;">
           자유게시판 상세 페이지   
        </td>
    </tr>
   <tr>
   <th>게시글 제목</th>
   <td><input type="text" name="subject" value="${board.subject}" size="50" readonly></td>
   </tr>
   <tr>
   <th>게시자 아이디</th>
   <td><input type="text" name="id" size="50" value="${board.id}" readonly></td>
   </tr>
   <tr>
   <th>게시글 내용</th>
   <td><textarea name="content" rows="9" cols="50" readonly>${board.content}</textarea></td>
   </tr>
   <tr>
   <td colspan="2" style="text-algin:center; background-color: skyblue;">
   <c:set var="member" value="${sessionScope.member}" > </c:set>
   <c:set var="boardlk" value="false" />
		    <c:forEach var="boardlike" items="${sessionScope.boardlikeList}" varStatus="status">
		     <c:if test="${not boardlk}">
		     <c:if test="${boardlike.bseq == board.bseq }">
		       <c:set var="boardlk" value="true" >
		       </c:set>
		       </c:if>
		     </c:if>
		    </c:forEach>
   <input type="button" 
		           ${boardlk == false ? "value='♡추천이요'  onclick=btn('like');" : "value='♥ 추천취소할래요' onclick=btn('dislike');"}> 
		           <input type="button" value="목록으로" onclick='btn("back");'>
		           추천수 : ${board.likey} 조회수 :  ${board.rep}
   </td>
   </table>
   </c:otherwise>
	</c:choose>
   </form>
</body>
</html>