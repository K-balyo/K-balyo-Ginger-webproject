<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function updatebtn(){
	var id = "${sessionScope.member.id}";
	var email = document.userInfo.email.value;
	var phone = document.userInfo.phone.value;
	var password = document.userInfo.password.value;
	var regex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
	var regexpn= /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/;
	if(id == ""){
		  alert("로그인을 먼저 해주세요.");
		  return false; 
	}else if(password ==""){
        alert("비밀번호를 입력하세요.");
        document.userInfo.password.focus();
        return false;
    }else if(email ==""){
        alert("이메일 주소를 입력하세요.");
        document.userInfo.email.focus();
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
	userInfo.action ="update.do";  
    alert("회원정보 수정 완료 !"); 	
    }
	}
	function btn(str){
		if(str == "home"){
			userInfo.action = "/Ginger/Ginger/index.do";
			userInfo.submit();
		}
	}
</script>
<style>
.id {
  width: 40%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}
.pw {
  width: 40%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}
.name {
  width: 40%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}
.phone {
  width: 60%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}
.email {
  width: 60%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}
.cd {
  width: 60%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}
.idForm{
  border-bottom: 2px solid #adadad;
  margin: 40px;
  padding: 5px 5px;
}
.passForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 5px 5px;
}
.nameForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 5px 5px;
}
.emailForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 5px 5px;
}
.phoneForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 5px 5px;
}
.cdForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 5px 5px;
}
.infoForm {
  position:absolute;
  width:250px;
  height:400px;
  padding: 20px, 10px;
  background-color:#FFFFFF;
  text-align:center;
  top:40%;
  left:50%;
  transform: translate(-50%,-50%);
  border-radius: 15px;
}
.bottomText {
   position:relative;
  left:50%;
  transform: translateX(-50%);
  margin-bottom: 40px;
  width:80;
  height:40px;
  border:none;
}

</style>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
<div id="haeder">
    <jsp:include page="/member/Header.jsp"/>
    </div>
    <div class="center">
	<form name="userInfo" method='post' onsubmit="return updatebtn()" class="infoForm">
<h2>회원정보 수정</h2>
<c:set var="member" value="${requestScope.member}"></c:set>
     <div class="idForm">
               <label for="fname"><h3>아이디</h3> </label>
               <input type="text" class="id" name="id"  value="${member.id}" readonly>
               </div>
                <div class="passForm">
               <label for="fname"><h3>비밀번호 </h3></label>  
                <input type="text" class="pw" name="password" value="${member.password}" >
                </div>
                 <div class="nameForm">
                <label for="fname"><h3>이름 </h3></label>
                <input type="text" class="name" name="name" placeholder="이름" value="${member.name}" readonly>
                </div>
                <div class="emailForm">
                <label for="fname"><h3>이메일 </h3></label>
                <input type="text" class="email" name="email" placeholder="이메일" value="${member.email}" >
                </div>
                <div class="phoneForm">
                <label for="fname"><h3>핸드폰</h3> </label>
                <input type="text" class="phone" name="phone" placeholder="핸드폰" value="${member.phone}" >
                </div>
                 <div class="cdForm">
                <label for="fname"> <h3>생성날짜</h3> </label>
                <input type="text" class="cd" name="cd" value="${member.createDate}" readonly>
                
                 </div>
                 <div class="bottomText">
                 <input type="submit" value="수정" >
   <input type="button" value="메인으로" onclick='btn("home");'>
	</div>
	</form>
</div>
</body>
</html>

