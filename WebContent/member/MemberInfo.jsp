<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function btn(str){		
			if(str == "home"){
				document.getElementById("frmId").action = "/Ginger/Ginger/index.do";
				document.getElementById("frmId").submit();
			}
			else if(str == "update"){
				document.getElementById("frmId").action = "/Ginger/member/update.do?sss=sss";
				document.getElementById("frmId").submit();
			}else if(str == "withdrawal"){
				alert("회원정보 탈퇴하였습니다 !")
				document.getElementById("frmId").action = "/Ginger/member/delete.do?id="+${member.id};
				document.getElementById("frmId").submit();
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
<title>회원 정보</title>
</head>
<body>
 <div id="haeder">
    <jsp:include page="/member/Header.jsp"/>
    </div>
	<form name="frm" id="frmId" method='post' class="infoForm">
 <h2>회원정보</h2>
<c:set var="member" value="${requestScope.member}"></c:set>
                 <div class="idForm">
               <label for="fname"><h3>아이디</h3> </label>
               <input type="text" class="id" name="id"  value="${member.id}" readonly>
               </div>
                <div class="passForm">
               <label for="fname"><h3>비밀번호 </h3></label>  
                <input type="text" class="pw" name="password" value="${member.password}" readonly>
                </div>
                 <div class="nameForm">
                <label for="fname"><h3>이름 </h3></label>
                <input type="text" class="name" name="name" placeholder="이름" value="${member.name}" readonly>
                </div>
                <div class="emailForm">
                <label for="fname"><h3>이메일 </h3></label>
                <input type="text" class="email" name="email" placeholder="이메일" value="${member.email}" readonly>
                </div>
                <div class="phoneForm">
                <label for="fname"><h3>핸드폰</h3> </label>
                <input type="text" class="phone" name="phone" placeholder="핸드폰" value="${member.phone}" readonly>
                </div>
                 <div class="cdForm">
                <label for="fname"> <h3>생성날짜</h3> </label>
                <input type="text" class="cd" name="cd" value="${member.createDate}" readonly>
                
                 </div>
                 <div class="bottomText">
                 <input type="button" value="수정하러가기" onclick='btn("update");'>
       <input type="button" value="회원탈퇴" onclick='btn("withdrawal");'>
	   <input type="button" value="메인으로" onclick='btn("home");'> 
	</div>
	</form>
</body>
</html>
