<%@ tag language="java" pageEncoding="UTF-8" body-content="scriptless"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="type" required="true" rtexprvalue="true"%>
<c:if test="${error eq type }">
<jsp:doBody></jsp:doBody>
</c:if>