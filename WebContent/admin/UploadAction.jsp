    <%@ page import="file.FileDAO" %>
    <%@ page import="java.io.File" %>
    <%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
    <%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 업로드</title>
</head>
<body>
<div id="haeder">
    <jsp:include page="/admin/adminHeader.jsp"/>
    </div>
<%
String directory = application.getRealPath("/img/");
int maxSize = 1024 * 1024 * 100;
String encoding = "UTF-8";

MultipartRequest multipartRequest
= new MultipartRequest(request, directory, maxSize, encoding,
		new DefaultFileRenamePolicy());

String tag = multipartRequest.getOriginalFileName("file");
String image = multipartRequest.getFilesystemName("file");
String address = multipartRequest.getParameter("address");
String bestyn = multipartRequest.getParameter("bestyn");
String content = multipartRequest.getParameter("content");
String name = multipartRequest.getParameter("name");
String kind = multipartRequest.getParameter("kind");
int state = Integer.parseInt(multipartRequest.getParameter("state").trim().replace(",",""));
int price2 = Integer.parseInt(multipartRequest.getParameter("price2").trim().replace(",", ""));
int price3 = Integer.parseInt(multipartRequest.getParameter("price3").trim().replace(",", ""));
int price = Integer.parseInt(multipartRequest.getParameter("price").trim().replace(",", ""));

new FileDAO().upload(name,kind,price,price2,price3,tag,content,state,address,image,bestyn);

out.write("파일명: " + tag + "<br>");
out.write("실제 파일명: " + image + "<br>");
out.write("파일 경로 : " + directory);
%>
</body>
</html>