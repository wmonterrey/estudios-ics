<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<jsp:include page="../fragments/headTag.jsp" />
</head>
<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden">
	<jsp:include page="../fragments/bodyHeader.jsp" />
    <div class="app-body">
        <jsp:include page="../fragments/sideBar.jsp" />
        <!-- Main content -->
        <div class="main">
        	<!-- Breadcrumb -->
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="<spring:url value="/" htmlEscape="true "/>"><spring:message code="home" /></a>
                    <i class="fa fa-angle-right"></i> <a href="<spring:url value="/chf/editarcaso/" htmlEscape="true "/>"><spring:message code="chfcasossearch" /></a>
                </li>
            </ol>
            <div class="container-fluid">
            	<div class="animated fadeIn">
                    <div class="card">
                        <div class="card-header">
                            <i class="fa fa-group"></i> <spring:message code="intensiveMonitoring" /> <spring:message code="house" />
                    									<c:out value="${participante.codigoCaso.casa.codigoCHF}" />
                        </div>
                        <div class="card-block">
                        	<form action="" method="post" enctype="multipart/form-data" class="form-horizontal ">
                        		<div class="form-group row">
	                                <label class="col-md-3 form-control-label"><spring:message code="code" /></label>
	                                <div class="col-md-9">
	                                    <p class="form-control-static"><c:out value="${participante.participante.participante.codigo}"/></p>
	                                </div>
	                            </div>
	                            <div class="form-group row">
	                                <label class="col-md-3 form-control-label"><spring:message code="participant" /></label>
	                                <div class="col-md-9">
	                                    <p class="form-control-static"><c:out value="${participante.participante.participante.nombreCompleto}"/></p>
	                                </div>
	                            </div>
                            </form>
                            <spring:url value="/chf/editarcaso/participants/{codigo}" var="partsUrl">
                                <spring:param name="codigo" value="${participante.codigoCaso.codigoCaso}" />
                            </spring:url>
                            <spring:url value="/chf/editarcaso/newvisit/{codigo}" var="newVisitUrl">
                                <spring:param name="codigo" value="${participante.codigoCasoParticipante}" />
                            </spring:url>
                            <table class="table table-striped table-bordered datatable">
                                <thead>
                                    <tr>
                                        <th><spring:message code="visit" /></th>
		                                <th><spring:message code="visitDate" /></th>
		                                <th><spring:message code="visitHour" /></th>
		                                <th><spring:message code="visitExp" /></th>
		                                <th><spring:message code="visitTemp" /></th>
		                                <th><spring:message code="actions" /></th>
                                    </tr>
                                </thead>
                                <tbody>
	                                <c:forEach items="${visitas}" var="visita">
	                                	<spring:url value="/chf/editarcaso/visitdata/{codigo}/" var="visitUrl">
		                                    <spring:param name="codigo" value="${visita.codigoCasoVisita}" />
		                                </spring:url>
		                                <spring:url value="/chf/editarcaso/editVisit/{codigoCasoVisita}/" var="editUrl">
		                                    <spring:param name="codigoCasoVisita" value="${visita.codigoCasoVisita}" />
		                                </spring:url>
		                                <tr>
		                                    <td><c:out value="${visita.visita}" /></td>
		                                    <td><fmt:formatDate value="${visita.fechaVisita}" pattern="dd/MM/yyyy" /></td>
		                                    <td><c:out value="${visita.horaProbableVisita}" /></td>
		                                    <c:choose>
		                                        <c:when test="${visita.expCS eq 'S'}">
		                                            <td><span class="badge badge-success"><spring:message code="CHF_CAT_SINO_SI" /></span></td>
		                                        </c:when>
		                                        <c:otherwise>
		                                            <td><span class="badge badge-danger"><spring:message code="CHF_CAT_SINO_NO" /></span></td>
		                                        </c:otherwise>
		                                    </c:choose>
		                                    <td><c:out value="${visita.temp}" /></td>
		                                    <td><a href="${fn:escapeXml(editUrl)}" class="btn btn-outline-primary btn-sm"><i class="fa fa-edit"></i></a>
		                                    <a href="${fn:escapeXml(visitUrl)}" class="btn btn-outline-primary btn-sm"><i class="fa fa-clone"></i></a></td>
		                                </tr>
		                            </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="card-footer">
                              <a href="${fn:escapeXml(newVisitUrl)}" class="btn btn-sm btn-success"><i class="fa fa-plus"></i> <spring:message code="add" /> <spring:message code="visit" /></a>
                              <a href="${fn:escapeXml(partsUrl)}" class="btn btn-sm btn-primary"><i class="fa fa-mail-reply"></i> <spring:message code="back" /></a>
                          </div>
                    </div>
                </div>
            	
            </div>
            <!-- /.conainer-fluid -->
        </div>
    </div>
    <jsp:include page="../fragments/bodyFooter.jsp" />
    <jsp:include page="../fragments/corePlugins.jsp" />
    
    <!-- GenesisUI main scripts -->
	<spring:url value="/resources/js/app.js" var="App" />
	<script src="${App}" type="text/javascript"></script>
	
</body>
</html>