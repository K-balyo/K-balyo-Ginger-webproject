package webapp;



import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
/*
  웹 애플리케이션
  웹 애플리케이션은 웹(인터넷)을 기반으로 실행되는 애플리케이션을 말합니다.
  즉, 브라우저로 접근하여 사용되는 애플리케이션을 말합니다.
  
    웹 애플리케이션의 동작원리
    사용자가 브라우저의 주소 입력란에 특정 사이트의 주소를 입력합니다.
    그러면 브라우저가 해당 웹 서버에 웹 페이지를 요청하는 것이 됩니다.
    웹 서버는 클라이언트에게 제공할 페이지를 찾습니다.
    웹 서버는 찾은 웹 페이지를 다시 클라이언트 즉 브라우저에 보내주어 요청에 대한 응답을 합니다.
    
     HTML
     브라우저를 통해서 각종 정보를 제공해주는 웹 페이지는 HTML을 사용하여 웹 프로그래밍을 한 것입니다.
     하지만 HTML만으로는 매일 매일 변경되는 새로운 정보들을 제공해주지 못합니다.
     왜냐하면 HTML은 같은 내용만 표시해주는 정적인 페이지이기 때문입니다.
     우리가 사용하는 인터넷은 매일 매일 새로운 내욜을 제공해주어야 하기 때문에 HTML만 가지고 웹 프로그래밍을 하는 데 문제가 있습니다.
     
     서블릿/JSP
     그래서 등장하게 된 것이 동적인 페이지입니다.
     동적 페이지에서 개로운 정보를 제공해주기 위해서는 방대한 정보를 관리할 데이터베이스가 필요합니다.
     예를 들어 게시판에 게재되는 글을 데이터베이스에 저장되었다가 보여주는 것입니다.
     이렇듯 다양한 정보를 데이터베이스에서 얻거나 저장해야 하기 위해서 등장한 기술이 PHP,ASP,서블릿/JSP 입니다.
     
     목표는 서블릿/JSP를 사용하여 웹 애플리케이션을 개발하는 것입니다.
     여러분이 쇼핑몰을 웹 애플리케이션으로 구축하는 것을 목표로 한다면 사용자가 원하는 상품을 검색한 후 구입을 하는 과정을
     모두 서블린/JSP를 사용하여 제작해야 합니다.
     
     웹서버(Web Server)/
     웹 애플리케이션 서버
     (Web Application Server : WAS)
     서버는 일반적으로 사용자(클라이언트)의 요청이 들어오면 이를 받아들여서 결과 페이지를 전송하는
     웹 서버(Web Server) 와 실질적으로 요청한 페이지의 로직이나 데이터베이스와의 연동을 처리할 수 있는
     비즈니스 로직이 구현되어야 하는 웹 애플리케이션 서버(Web Application Server : WAS)로 이루어져 있습니다.
     대표적인 WAS로는 BEA사의 웹로직(WebLogic), INM의 웹스파이어(WebShpere),
   SUN사의 iPlanet, Oracle 9iAS, 티맥스의 제우스(jeus) 등이 있습니다.
    내 컴퓨터에 웹 애플리케이션 서버인 톰캣을 설치하면 내 컴퓨터는 웹 서비스가 가능한 웹 서버가 됩니다.
    
    서블릿(Servlet)
    서블릿(Servlet)은 Server + Applet 의 합성어로 서버 상에서 실행되는
    Apleet이란 의미로 자바를 이용하여 웹상에서 실행되는 프로그램을 작성하는 기술을 말합니다.
    
    서블릿은 자바 클래스 형태의 웹 애플리케이션을 말하는데, 브라우저를 통해 자바 클래스가 실행되도록
    하기 위해서는 javax.servlet.http 패키지에서 제공하는 HttpServlet 클래스를 상속받아 구현해야 합니다.
    HttpServlet 클래스를 상속 받아 만든 서브 클래스를 서블릿 클래스라고 합니다.
 */
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ServletEx")
public class ServletEx extends HttpServlet{
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//	         throws ServletException, IOException{
//	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException{
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Hello Servlet");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
