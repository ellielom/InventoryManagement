<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<%@ attribute name="color" required="true" rtexprvalue="true" %>
<%@ attribute name="weight" required="false" rtexprvalue="true" %>

<div style="color:${color};font-weight:${weight}"><jsp:doBody/></div>