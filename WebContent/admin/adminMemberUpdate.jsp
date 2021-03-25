<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function updatebtn(){
	var email = document.userInfo.email.value;
	var phone = document.userInfo.phone.value;
	var password = document.userInfo.password.value;
	var useyn = document.userInfo.useyn.value;
// 	var image = document.userInfo.iamge.value;
	var regex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
	var regexpn= /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/;
	
	if(password ==""){
        alert("비밀번호를 입력하세요.");
        document.userInfo.password.focus();
        return false;
    }else if(email ==""){
        alert("이메일 주소를 입력하세요.");
        document.userInfo.email.focus();
        return false;
    }else if(useyn ==""){
        alert("탈퇴여부 확인해주세요.");
        document.userInfo.useyn.focus();
        return false;
    }else if (regex.test(email) === false) {
        alert("잘못된 이메일 형식입니다.");
        document.userInfo.email.value=""
        document.userInfo.email.focus()
        return false;
    }else if(phone == ""){
        alert("핸드폰 번호를 입력하세요.");
        document.userInfo.phone.focus();
        return false;
    }else if(regexpn.test(phone) === false){
        alert("잘못된 핸드폰 번호 형식입니다.");
        document.userInfo.phone.value=""
        document.userInfo.phone.focus();
        return false;
    }else{
	frm.action ="adminupdate.do";   
	userInfo.submit();
    }
	}
	function btn(str){
		if(str == "home"){
			userInfo.action = "/Ginger/admin/adminindex.do";
			userInfo.submit();
		}else if(str == "list"){
			userInfo.action = "/Ginger/admin/list.do"
				userInfo.submit();
		}
	}
</script>
<style>
.center {
  position: absolute;
  top: 50%;
  width: 100%;
  text-align: center;
  font-size: 18px;
}

p.t input:link {
background-color: white;
  color: red;
  border: 2px solid green;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}
p.t input:hover, p.t input:active {
  background-color: green;
  color: white;
}

</style>
<meta charset="UTF-8">
<title>회원 정보 수정</title>

</head>
<body>
<div id="haeder">
    <jsp:include page="/admin/adminHeader.jsp"/>
    </div>
    <div class="center">
	<form name="userInfo" method='post' onsubmit="return updatebtn()">
<c:set var="member" value="${requestScope.member}"></c:set>
    <p class="t">
        아이디 : <input type="text" name="id" value="${member.id}" readonly><br>   
        비밀번호 : <input type="text" name="password" value="${member.password}" ><br>
        이메일 : <input type="text" name="email" value="${member.email}"><br>
	이름 : <input type="text" name="name" value="${member.name}" readonly><br>
	핸드폰 : <input type="text" name="phone" value="${member.phone}" ><br>
<%-- 	이미지 : <input type="text" name="image" value="${member.image }" readonly><br> --%>
	생성날짜 : <input type="text"  value="${member.createDate}" readonly><br>	
	탈퇴여부: <input type="text" name="useyn" value="${member.useyn}" ><br></p>
	<c:choose>
	<c:when test="">
	</c:when>
	</c:choose>
   <input type="submit" value="수정" >
   <input type="button" value="메인으로" onclick='btn("home");'>
	</form>
</div>
</body>
</html>
