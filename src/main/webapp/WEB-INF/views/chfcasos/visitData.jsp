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
	                                    <p class="form-control-static"><c:out value="${participante.participante.participante.nombreCompleto}"/>  -  <spring:message code="visit" /> <c:out value="${visita.visita}"/> 
	                                     	- <fmt:formatDate value="${visita.fechaVisita}" pattern="dd/MM/yyyy" /></p>
	                                </div>
	                            </div>
                            </form>
                            <spring:url value="/chf/editarcaso/participantdata/{codigo}" var="partUrl">
                                <spring:param name="codigo" value="${participante.codigoCasoParticipante}" />
                            </spring:url>
                            <spring:url value="/chf/editarcaso/newsint/{codigoCasoVisita}" var="newSintUrl">
                                <spring:param name="codigoCasoVisita" value="${visita.codigoCasoVisita}" />
                            </spring:url>
                            <table class="table table-striped table-bordered datatable">
                                <thead>
                                    <tr>
		                                <th><spring:message code="fechaSintomas" /></th>
		                                <th><spring:message code="fiebre" /></th>
		                                <th><spring:message code="dolorGarganta" /></th>
		                                <th><spring:message code="secrecionNasal" /></th>
		                                <th><spring:message code="tos" /></th>
		                                <th></th>
                                    </tr>
                                </thead>
                                <tbody>
	                                <c:forEach items="${sintomas}" var="sintoma">
		                                <spring:url value="/chf/editarcaso/editSint/{codigoCasoSintoma}/" var="sintomaUrl">
		                                    <spring:param name="codigoCasoSintoma" value="${sintoma.codigoCasoSintoma}" />
		                                </spring:url>
		                                <tr>
		                                    <td><fmt:formatDate value="${sintoma.fechaSintomas}" pattern="dd/MM/yyyy" /></td>
		                                    <c:choose>
		                                        <c:when test="${sintoma.fiebre eq '1'}">
		                                            <td><span class="badge badge-danger"><spring:message code="CHF_CAT_SINO_SI" /></span></td>
		                                        </c:when>
		                                        <c:otherwise>
		                                            <td><span class="badge badge-success"><spring:message code="CHF_CAT_SINO_NO" /></span></td>
		                                        </c:otherwise>
		                                    </c:choose>
		                                    <c:choose>
		                                        <c:when test="${sintoma.dolorGarganta eq '1'}">
		                                            <td><span class="badge badge-danger"><spring:message code="CHF_CAT_SINO_SI" /></span></td>
		                                        </c:when>
		                                        <c:otherwise>
		                                            <td><span class="badge badge-success"><spring:message code="CHF_CAT_SINO_NO" /></span></td>
		                                        </c:otherwise>
		                                    </c:choose>
		                                    <c:choose>
		                                        <c:when test="${sintoma.secrecionNasal eq '1'}">
		                                            <td><span class="badge badge-danger"><spring:message code="CHF_CAT_SINO_SI" /></span></td>
		                                        </c:when>
		                                        <c:otherwise>
		                                            <td><span class="badge badge-success"><spring:message code="CHF_CAT_SINO_NO" /></span></td>
		                                        </c:otherwise>
		                                    </c:choose>
		                                    <c:choose>
		                                        <c:when test="${sintoma.tos eq '1'}">
		                                            <td><span class="badge badge-danger"><spring:message code="CHF_CAT_SINO_SI" /></span></td>
		                                        </c:when>
		                                        <c:otherwise>
		                                            <td><span class="badge badge-success"><spring:message code="CHF_CAT_SINO_NO" /></span></td>
		                                        </c:otherwise>
		                                    </c:choose>
		                                    <td><a href="${fn:escapeXml(sintomaUrl)}" class="btn btn-outline-primary btn-sm"><i class="fa fa-edit"></i></a>
		                                </tr>
		                            </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="card-footer">
                              <a href="${fn:escapeXml(newSintUrl)}" class="btn btn-sm btn-success"><i class="fa fa-plus"></i> <spring:message code="add" /> <spring:message code="sympt" /></a>
                              <a href="${fn:escapeXml(partUrl)}" class="btn btn-sm btn-primary"><i class="fa fa-mail-reply"></i> <spring:message code="back" /></a>
                       	</div>
                    </div>
                    
                     <div class="card">
                        <div class="card-header">
                            <i class="fa fa-group"></i> <spring:message code="contact" /> 
                        </div>
                            <spring:url value="/chf/editarcaso/newcont/{codigoCasoVisita}" var="newContUrl">
                                <spring:param name="codigoCasoVisita" value="${visita.codigoCasoVisita}" />
                            </spring:url>
                            <table class="table table-striped table-bordered" id="tabla_contactos">
                                <thead>
                                    <tr>
		                                <th><spring:message code="fechaContacto" /></th>
		                                <th><spring:message code="partContacto" /></th>
		                                <th><spring:message code="tiempo" /></th>
		                                <th><spring:message code="tipo" /></th>
		                                <th></th>
                                    </tr>
                                </thead>
                                <tbody>
	                                <c:forEach items="${contactos}" var="contacto">
		                                <spring:url value="/chf/editarcaso/editCont/{codigoCasoContacto}/" var="contactoUrl">
		                                    <spring:param name="codigoCasoContacto" value="${contacto.codigoCasoContacto}" />
		                                </spring:url>
		                                <tr>
		                                    <td><fmt:formatDate value="${contacto.fechaContacto}" pattern="dd/MM/yyyy" /></td>
		                                    <td><c:out value="${contacto.partContacto.participante.nombreCompleto}" /></td>
		                                    <td><c:out value="${contacto.tiempoInteraccion}" /></td>
		                                    <td><c:out value="${contacto.tipoInteraccion}" /></td>
		                                    <td><a href="${fn:escapeXml(contactoUrl)}" class="btn btn-outline-primary btn-sm"><i class="fa fa-edit"></i></a>
		                                </tr>
		                            </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="card-footer">
                              <a href="${fn:escapeXml(newContUrl)}" class="btn btn-sm btn-success"><i class="fa fa-plus"></i> <spring:message code="add" /> <spring:message code="contact" /></a>
                              <a href="${fn:escapeXml(partUrl)}" class="btn btn-sm btn-primary"><i class="fa fa-mail-reply"></i> <spring:message code="back" /></a>
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
	
	<spring:url value="/resources/js/libs/jquery.dataTables.js" var="dataTableJs" />
	<script src="${dataTableJs}" type="text/javascript"></script>
	
	<spring:url value="/resources/js/libs/data-tables/DT_bootstrap.js" var="dataTablesBS" />
	<script type="text/javascript" src="${dataTablesBS}"></script>
	
	<spring:url value="/resources/js/libs/data-tables/i18n/label_{language}.json" var="dataTablesLang">
   <spring:param name="language" value="es" />
</spring:url>

<script>
    jQuery(document).ready(function() {
        $('#tabla_contactos').DataTable({
            "oLanguage": {
                "sUrl": "${dataTablesLang}"
            }
        });
    });
</script> 
	
</body>
</html>