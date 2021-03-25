<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type ="text/css">
*{
  margin: 0px;
  padding: 0px;
  text-decoration: none;
  font-family:sans-serif;

}

body {
  background-image: #34495e;
}
.idForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}

.passForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}
.id {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.pw {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}
.loginForm {
  position:absolute;
  width:300px;
  height:400px;
  padding: 30px, 20px;
  background-color:#FFFFFF;
  text-align:center;
  top:50%;
  left:50%;
  transform: translate(-50%,-50%);
  border-radius: 15px;
}
.btn {
  position:relative;
  left:40%;
  transform: translateX(-50%);
  margin-bottom: 40px;
  width:80%;
  height:40px;
  background: linear-gradient(125deg,#81ecec,#6c5ce7,#81ecec);
  background-position: left;
  background-size: 200%;
  color:white;
  font-weight: bold;
  border:none;
  cursor:pointer;
  transition: 0.4s;
  display:inline;
}

.btn:hover {
  background-position: right;
}
.bottomText {
  text-align: center;
}
</style>
<script type="text/javascript">
function loginbtn(){
	var id = document.form.id.value;
	var pw = document.form.password.value;
	if(id == ""){
		alert("아이디를 입력해주세요.");
		document.form.id.focus();
		return false;
	}else if(pw == ""){
		 alert("비밀번호를 입력하세요.");
         document.form.password.focus();
         return false;
	}else{
	form.action="login.do"
	}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body >
<c:set var="noMember" value="${requestScope.noMember }"/>
<c:choose><c:when test="${noMember == 'n'}">
<script> 
alert("아이디 또는 비밀번호가 일치하지 않습니다.") 
window.history.go(-1);
</script>
</c:when>

<c:when test="${noMember !='n'}">
              <form name="form" method="post" class="loginForm">  
              <h2>로그인</h2>
              <div class="idForm">
               <input type="text" class="id" name="id"  placeholder="ID">
               </div>
                <div class="passForm">
                <input type="password" class="pw" name="password" placeholder="PW">
                </div>
              <input type="submit" value="로그인" onclick="loginbtn()" class="btn">
              <div class="bottomText">
                            아직 아이디가 없으시다구욧?!? 
                            <a href="/Ginger/Ginger/AddMember.jsp">회원가입</a>
              </div>
</form>
</c:when>
</c:choose>
</body>
</html>
