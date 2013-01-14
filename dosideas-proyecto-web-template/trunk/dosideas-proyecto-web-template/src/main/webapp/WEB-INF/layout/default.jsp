<%@page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jawr.net/tags" prefix="jwr" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <%--
            Set base for all urls. The base MUST is an absolute URI.
            Read more: http://stackoverflow.com/questions/6271075/how-to-get-the-base-url-from-jsp-request-object
        --%>
        <c:set var="req" value="${pageContext.request}" />
        <c:set var="uri" value="${req.requestURI}" />
        <base href="${fn:replace(req.requestURL, fn:substring(uri, 0, fn:length(uri)), req.contextPath)}/" />

        <title><tiles:getAsString name="title"/></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

        <jwr:style src="/bundles/all.css" />
        <jwr:script src="/bundles/all.js" />
    </head>
    <body>
        <tiles:insertAttribute name="body"/>
    </body>
</html>

