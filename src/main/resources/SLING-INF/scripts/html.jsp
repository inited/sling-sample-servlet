<%@page import="cz.inited.sample.SampleClass"%>
<%@page session="false"
                contentType="text/html;charset=UTF-8"
                import="org.apache.sling.api.request.ResponseUtil"
                trimDirectiveWhitespaces="true"
%>
<%@taglib prefix="sling" uri="http://sling.apache.org/taglibs/sling/1.0"%>
<sling:defineObjects/>
<%
final SampleClass sampleClass = new SampleClass();
%>
<html>
  <head>
    <title><%= ResponseUtil.escapeXml(currentNode.getName()) %></title>
  </head>
  <body>
    <h1>Hello world</h1>
    <%= sampleClass.getString() %>
  </body>
</html>
