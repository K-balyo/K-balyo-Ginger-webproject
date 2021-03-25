<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 창</title>
    <script type="text/javascript">
	function btn(str) {
	if (str == "join") {
				var id = document.userInfo.id.value;
				var phone = document.userInfo.phone.value;
				var name = document.userInfo.name.value;
				var password = document.userInfo.password.value;
				var idCheck = document.userInfo.idDuplication.value
				var regexpn= /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/;

				if (id == "") {
					alert("아이디를 입력해 주세요!!!");
					document.userInfo.id.focus();
					return false;
				}else if((id < "0" || id > "9") && (id < "A" || id > "Z") && (id < "a" || id > "z")){ 
	                alert("아이디는 알파벳 대소문자와 숫자만 사용가능합니다.");
	                document.userInfo.id.focus();
	                return false;
	            }else if (document.userInfo.id.value.indexOf(" ") >= 0) {
	                alert("아이디에 공백을 사용할 수 없습니다.")
	                document.userInfo.id.focus()
	                document.userInfo.id.select()
	                return false;
	            }else if(password ==""){
	                alert("비밀번호를 입력하세요.");
	                document.userInfo.password.focus();
	                return false;
	            }else if(name == ""){
	                alert("이름을 입력하세요.");
	                document.userInfo.name.focus();
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
	            }else if(idCheck == "idUncheck"){
	            	alert("아이디 중복 체크를 해주세요.");
	            	return false;
	            }else if(document.userInfo.name.value.length<2){
	                alert("이름을 2자 이상 입력해주십시오.")
	                document.userInfo.name.focus()
	                return false;
	            }else { 
					userInfo.action = "/Ginger/admin/addadmin.do";
				}
			}else if (str == "chch") {
				var id = document.userInfo.id.value;
				if (id == "") {
					alert("아이디를 입력해 주세요!!!");
					document.userInfo.id.focus();
					return false;
				}else if((id < "0" || id > "9") && (id < "A" || id > "Z") && (id < "a" || id > "z")) { 
	                alert("아이디는 알파벳 대소문자와 숫자만 사용가능합니다. 공백도 사용할 수 없습니다.");
	                return false;
	            }else if (document.userInfo.id.value.indexOf(" ") >= 0) {
	                alert("아이디에 공백을 사용할 수 없습니다.")
	                document.userInfo.id.focus()
	                document.userInfo.id.select()
	                return false;
	            }else {  
					window.open('/Ginger/admin/adminidCheck.do?id=' + id + '', '',
						'width=400 , height=400');
				}
			} 
	}
	 			function inputIdChk(){
	 	            document.userInfo.idDuplication.value ="idUncheck";
	 	        }
</script>
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
.id {
  width: 80%;
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
.name {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}
.phone {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}
.email {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
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
.nameForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}
.emailForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}
.phoneForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
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
</head>
<body>

	<form name="userInfo" method="post" onsubmit="return btn('join');" class="addForm">
		 <div class="idForm">
               <input type="text" class="id" name="id"  placeholder="ID" onkeydown="inputIdChk()">
               <input type="button" value="중복확인" onclick='btn("chch");'>    
               <input type="hidden" name="idDuplication" value="idUncheck" >
               </div>
                <div class="passForm">
                <input type="password" class="pw" name="password" placeholder="PW">
                </div>
			<div class="nameForm">
                <input type="text" class="name" name="name" placeholder="이름">
                </div>
                <div class="phoneForm">
                <input type="text" class="phone" name="phone" placeholder="핸드폰">
                </div>
                <input type="submit" value="가입"	 class="btn"> 
	         <div class="bottomText">
                           아이디가 있던가요? <a href="/Ginger/admin/adminLoginForm.jsp">뒤로</a>
              </div>
	</form>
</body>
</html>