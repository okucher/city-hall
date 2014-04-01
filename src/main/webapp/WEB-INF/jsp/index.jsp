<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>

<table>
<c:forEach items="${testList}" var="test">
    <tr>
        <td>${test.id}</td>
        <td>${test.text}</td>
    </tr>
</c:forEach>
</table> 
</body>

</html>
