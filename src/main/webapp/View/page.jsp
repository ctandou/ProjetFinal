<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edition des taux de remise</h1>
        <form method="post">
            <label>Code :* </label>
            <input type="text" name="Code" size="1" maxlength="1"/>
            <p>* La lettre doit être unique.</p>
            
            <label>Taux</label>:<input type="number"name="Taux" min="0" max="100" step="0.1"/> 
            <input type="hidden" name="action" value="add">
            <button type="submit">Ajouter</button>
        </form>
        <br>
        <%--  --%>
        <c:if test="${Code.equals(dao.discount_code)}"   >
            <div>
                * La lettre doit être unique.
            </div>
        </c:if>

        <table border=2 >
            <tr>
                <th>Code</th>
                <th>Taux</th>
                <th>Action</th>
            </tr> 
            <c:forEach var="item" items="${listCode}" varStatus="status">
                <tr> 
                    <td><c:out value="${item.code}"/></td>
                    <td><c:out value="${item.taux}"/></td>
                    <td>
                        <form method="post">
                            <input type="hidden" name="Code" value="<c:out value="${item.code}"/>">
                            <input type="hidden" name="action" value="delete">
                            <button type="submit">Delete</button>
                    </td>


                    </form>                    
                </tr>

            </c:forEach>


        </table>      
    </body>
</html>
