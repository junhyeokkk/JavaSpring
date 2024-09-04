<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>User1::register</title>
</head>
<body>
<h3>User2 수정</h3>
<a href="/ch04">처음으로</a>
<a href="/ch04/user2/list">목록</a>

<form action="/ch04/user2/modify" method="POST">
  <table border="1">
    <tr>
      <td>아이디</td>
      <td><input type="text" name="uid" value="${user2DTO.uid}" readonly/></td>
    </tr>
    <tr>
      <td>이름</td>
      <td><input type="text" name="name" value="${user2DTO.name}"/></td>
    </tr>
    <tr>
      <td>생년월일</td>
      <td><input type="date" name="birth" value="${user2DTO.birth}"/></td>
    </tr>
    <tr>
      <td>주소</td>
      <td><input type="text" name="addr" value="${user2DTO.addr}"/></td>
    </tr>
    <tr>
      <td colspan="2" align="right">
        <input type="submit" values="등록하기"/>
      </td>
    </tr>

  </table>
</form>
</body>
</html>
