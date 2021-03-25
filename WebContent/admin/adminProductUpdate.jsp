<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 업로드</title>
<style type="text/css">
.name {
  width: 70%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}
.bestyn {
  width: 70%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}
.price {
  width: 70%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}
.price2 {
  width: 70%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}
.price3 {
  width: 70%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}
.kind {
  width: 70%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}
.address {
  width: 70%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}
.state {
  width: 70%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}
.pseq {
  width: 70%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
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
</head>
<body>
<div id="haeder">
    <jsp:include page="/admin/adminHeader.jsp"/>
    </div>
<form action="adminproductupdate.do"  method="post"  class="addForm">
    <c:set var="pu" value="${requestScope.product}"></c:set>
    
상품번호 :<input type="text" name="pseq" class="pseq" value="${pu.pseq}" /><br/>
명  칭 :<input type="text" name="name" class="name" value="${pu.name}" /><br/>
베스트 :<input type="text" name="bestyn" class="bestyn"  value="${pu.bestyn}" /><br/>
가  격  :<input type="text" name="price" class="price"  value="${pu.price}"/><br/>
가 격2 :<input type="text" name="price2" class="price2"  value="${pu.price2}"/><br/>
가 격3 :<input type="text" name="price3" class="price3"  value="${pu.price3}"/><br/>
종  류  :<input type="text" name="kind" class="kind"  value="${pu.kind}"/><br/>
주  소  :<input type="text" name="address" class="address"  value="${pu.address}"/><br/>
상  태  :<input type="text" name="state" class="state"   value="${pu.state}"/><br/>

내  용 : <textarea rows="10" cols="40" name="content"  class="content" >
${pu.content}
</textarea><br/>

<input type="submit" value="수정" class="btn"><br>
</form> 
</body>
</html>