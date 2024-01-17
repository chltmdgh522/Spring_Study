<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %><%--
  Created by IntelliJ IDEA.
  User: chltm
  Date: 2023-07-11
  Time: 오전 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //request, response는 그냥 사용 가능! 왜냐하면 jsp도 서블릿으로 전환되기때문에 사용이 가능하다고 한다.
     MemberRepository memberRepository = MemberRepository.getInstance();
    System.out.println("MemberSaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age")); //꺼내지는게 항상 string 이라서 int 로 바꿈

    Member member =new Member(username,age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ui>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ui>
<a href="/index.html"></a>
</body>
</html>
