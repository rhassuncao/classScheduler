<%@ page import="classscheduler.Subject; classscheduler.Teacher; classscheduler.Period" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'classscheduler.label', default: 'Schedule')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-school" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
</div>

<form id="newClassForm" name="newClassForm" action="create" method="post" >
    <input type="text" name="name">
    <g:select name="teacher.id" from="${Teacher.list()}" value="${teacher?.id}" noSelection="['':'-Choose a teacher-']" optionKey="id" optionValue="name"/>
    <g:select name="period.id" from="${Period.list()}" value="${period?.id}" noSelection="['':'-Choose a period-']" optionKey="id" optionValue="name"/>
    <g:select name="subject.id" from="${Subject.list()}" value="${subject?.id}" noSelection="['':'-Choose a subject-']" optionKey="id" optionValue="name"/>
    <button class="submit" type="submit">Submit</button>
</form>

<div id="list-unit" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>

    <table>
        <thead>
        <tr>
            <th>Room</th>
            <th>Subject</th>
            <th>Period</th>
            <th>Teacher</th>
        </tr>
        </thead>
        <tbody>
        <g:each status="i" var="scheduled" in="${scheduledList}">
            <tr class="${ (i % 2) == 0 ? 'a' : 'b'}">
                <td>${scheduled.name}</td>
                <td>${scheduled.subject.name}</td>
                <td>${scheduled.period.name}</td>
                <td>${scheduled.teacher.name}</td>
            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${scheduledCount ?: 0}" />
    </div>
</div>

</body>
</html>