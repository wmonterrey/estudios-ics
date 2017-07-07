<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <jsp:include page="../../fragments/headTag.jsp" />
    <spring:url value="/resources/js/libs/data-tables/TableTools/css/dataTables.tableTools.css" var="dtttcss" />
    <link rel="stylesheet" href="${dtttcss}"/>
</head>
<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden">
<jsp:include page="../../fragments/bodyHeader.jsp" />
<div class="app-body">
    <jsp:include page="../../fragments/sideBar.jsp" />
    <!-- Main content -->
    <div class="main">
        <!-- Breadcrumb -->
        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="<spring:url value="/" htmlEscape="true "/>"><spring:message code="home" /></a>
                <i class="fa fa-angle-right"></i> <a href="<spring:url value="/super/casacaso/" htmlEscape="true "/>"><spring:message code="intensiveMonitoring" /></a>
            </li>
        </ol>
        <c:set var="exportar"><spring:message code="export" /></c:set>
        <c:set var="confirmar"><spring:message code="confirm" /></c:set>
        <c:set var="deshabilitar"><spring:message code="disable" /></c:set>
        <c:set var="recordDisabledLabel"><spring:message code="recordDisabled" /></c:set>
        <spring:url value="/super/particaso/getParticipantsCasos" var="getCodesUrl"/>

        <div class="container-fluid">
            <div class="card">
                <div class="card-header">
                    <i class="fa fa-list-alt"></i> <spring:message code="intensiveMonitoring" />
                </div>
                <div class="card-block">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="btn-group">
                                <spring:url value="/super/casacaso/newCase"	var="newCase"/>
                                <button id="new_version" onclick="location.href='${fn:escapeXml(newCase)}'" class="btn btn-success">
                                    <spring:message code="add" /> <i class="fa fa-plus"></i>
                                </button>
                            </div>
                            <br>
                            <br>
                        </div>
                    </div>
                    <div class="row table-toolbar">
                        <div class="col-md-12">
                        </div>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-hover table-bordered" id="lista_casos">
                            <thead>
                            <tr>
                                <th><spring:message code="house" /></th>
                                <th><spring:message code="logindate" /></th>
                                <th><spring:message code="positive" /></th>
                                <th><spring:message code="fif" /></th>
                                <th><spring:message code="logoutdate" /></th>
                                <th><spring:message code="actions" /></th>
                            </tr>
                            </thead>
                            <c:forEach items="${casos}" var="parti">
                                <spring:url value="/super/casacaso/editCase/{codigo}"
                                            var="editUrl">
                                    <spring:param name="codigo" value="${parti.codigoCasoParticipante}" />
                                </spring:url>
                                <spring:url value="/super/casacaso/participants/{codigo}"
                                            var="participantsUrl">
                                    <spring:param name="codigo" value="${parti.codigoCaso.codigoCaso}" />
                                </spring:url>
                                <spring:url value="/admin/vcartas/habdes/disable/{codigo}"
                                            var="disableUrl">
                                    <spring:param name="codigo" value="${parti.codigoCaso.codigoCaso}" />
                                </spring:url>
                                <tr>
                                    <td><c:out value="${parti.codigoCaso.casa.codigoCHF}" /></td>
                                    <td><fmt:formatDate value="${parti.codigoCaso.fechaInicio}" pattern="dd/MM/yyyy" /></td>
                                    <td><c:out value="${parti.participante.participante.codigo}" /></td>
                                    <td><fmt:formatDate value="${parti.fechaEnfermedad}" pattern="dd/MM/yyyy" /></td>
                                    <td><fmt:formatDate value="${parti.codigoCaso.fechaInactiva}" pattern="dd/MM/yyyy" /></td>
                                    <td>
                                        <a href="${fn:escapeXml(editUrl)}" title="Editar" class="btn btn-outline-primary btn-sm"><i class="fa fa-edit"></i></a>
                                        <a href="${fn:escapeXml(participantsUrl)}" class="btn btn-outline-primary btn-sm"><i class="fa fa-users"></i></a>
                                        <a href="#" class="btn btn-outline-primary btn-sm"><i class="fa fa-ban"></i></a>
                                        <!--<a data-toggle="modal" data-id= "${fn:escapeXml(disableUrl)}" class="btn btn-outline-primary btn-sm desact"><i class="fa fa-trash-o"></i></a>
                                        -->
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <br>
                    <br>
                    <br>
                    <div class="row">
                        <div class="col-md-2">
                        </div>
                        <div class="col-md-8">
                            <form action="#" autocomplete="off" id="print-form" class="form-horizontal">
                                <div class="form-group row">
                                    <label class="form-control-label col-md-4" for="visita"><spring:message code="visit" />
                                        <span class="required">*</span>
                                    </label>
                                    <div class="input-group col-md-6">
                                    <span class="input-group-addon">
                                        <i class="fa fa-calendar-check-o"></i>
                                    </span>
                                        <select class="form-control select2-single" id="visita" name="visita">
                                            <option selected value=""><spring:message code="select" />...</option>
                                            <c:forEach items="${visitas}" var="visita">
                                                <option value="${visita.messageKey}">${visita.spanish}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="form-control-label col-md-4" for="etiquetas"><spring:message code="label.types" />
                                        <span class="required">*</span>
                                    </label>
                                    <div class="input-group col-md-6">
                                    <span class="input-group-addon">
                                        <i class="fa fa-eyedropper"></i>
                                    </span>
                                        <select class="form-control select2-multiple" multiple="" id="etiquetas" name="etiquetas">
                                            <c:forEach items="${etiquetas}" var="etiqueta">
                                                <option value="${etiqueta.messageKey}">${etiqueta.spanish}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <br>
                                <br>
                                <div class="form-actions fluid">
                                    <div class="col-md-offset-10 col-md-12">
                                        <button id="btnPrint" type="button" name="btnPrint" class="btn btn-success">
                                            <spring:message code="print.selected" /> <i class="fa fa-print"></i>
                                        </button>
                                        <br>
                                        <br>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="col-md-2">
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="basic" tabindex="-1" data-role="basic" data-backdrop="static" data-aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" data-aria-hidden="true"></button>
                            <div id="titulo"></div>
                        </div>
                        <div class="modal-body">
                            <input type=hidden id="accionUrl"/>
                            <div id="cuerpo"></div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="cancel" /></button>
                            <button type="button" class="btn btn-info" onclick="ejecutarAccion()"><spring:message code="ok" /></button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
            <div class="modal fade" id="confirModal" tabindex="-1" data-role="basic" data-backdrop="static" data-aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" data-aria-hidden="true"></button>
                            <div>Confirmación</div>
                        </div>
                        <div class="modal-body">
                            <div>Imprimir seleccionados?</div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="cancel" /></button>
                            <button type="button" class="btn btn-info" id="okPrint" name="okPrint"><spring:message code="ok" /></button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
        </div>
        <!-- /.conainer-fluid -->
    </div>
</div>
<jsp:include page="../../fragments/bodyFooter.jsp" />
<jsp:include page="../../fragments/corePlugins.jsp" />
<c:choose>
    <c:when test="${cookie.eIcsLang.value == null}">
        <c:set var="lenguaje" value="es"/>
    </c:when>
    <c:otherwise>
        <c:set var="lenguaje" value="${cookie.eIcsLang.value}"/>
    </c:otherwise>
</c:choose>
<!-- GenesisUI main scripts -->
<spring:url value="/resources/js/libs/jquery.dataTables.js" var="dataTableJs" />
<script src="${dataTableJs}" type="text/javascript"></script>

<spring:url value="/resources/js/libs/data-tables/DT_bootstrap.js" var="dataTablesBS" />
<script type="text/javascript" src="${dataTablesBS}"></script>

<spring:url value="/resources/js/libs/data-tables/TableTools/js/dataTables.tableTools.js" var="dataTablesTT" />
<script type="text/javascript" src="${dataTablesTT}"></script>

<spring:url value="/resources/js/libs/data-tables/TableTools/swf/copy_csv_xls_pdf.swf" var="dataTablesTTSWF" />

<spring:url value="/resources/js/libs/select2.min.js" var="selectJs" />
<script type="text/javascript" src="${selectJs}"></script>
<spring:url value="/resources/js/libs/jquery.validate.js" var="validateJs" />
<script src="${validateJs}" type="text/javascript"></script>
<spring:url value="/resources/js/libs/jquery-validation/localization/messages_{language}.js" var="jQValidationLoc">
    <spring:param name="language" value="${lenguaje}" />
</spring:url>
<script src="${jQValidationLoc}"></script>

<spring:url value="/resources/js/app.js" var="App" />
<script src="${App}" type="text/javascript"></script>
<c:choose>
    <c:when test="${cookie.eIcsLang.value == null}">
        <c:set var="lenguaje" value="es"/>
    </c:when>
    <c:otherwise>
        <c:set var="lenguaje" value="${cookie.eIcsLang.value}"/>
    </c:otherwise>
</c:choose>

<spring:url value="/resources/js/libs/data-tables/i18n/label_{language}.json" var="dataTablesLang">
    <spring:param name="language" value="${lenguaje}" />
</spring:url>
<script>
    jQuery(document).ready(function() {
        var table = $('#lista_casos').DataTable({
            "oLanguage": {
                "sUrl": "${dataTablesLang}"
            }
        });

        var tt = new $.fn.dataTable.TableTools( table, {
            "sSwfPath": "${dataTablesTTSWF}",
            "sRowSelect": "single",
            "aButtons": [
                {
                    "sExtends":    "collection",
                    "sButtonText": "${exportar}",
                    "aButtons": [
                        {
                            "sExtends": "csv",
                            "oSelectorOpts": { filter: 'applied', order: 'current' },
                            "mColumns": [ 0, 1, 2, 3, 4 ]
                        },
                        {
                            "sExtends": "pdf",
                            "oSelectorOpts": { filter: 'applied', order: 'current' },
                            "mColumns": [ 0, 1, 2, 3, 4 ],
                            "sPdfOrientation": "landscape"
                        }
                    ]
                }//,
                //{"sExtends": "select_all", "sButtonText": "todos"},
                //{"sExtends": "select_none", "sButtonText": "ninguno"}

            ]
        } );

        $( tt.fnContainer() ).insertBefore('div.table-toolbar');

        if ("${deshabilitado}"){
            toastr.error("${recordDisabledLabel}", "${registroVersion}" );
        }
        $(".desact").click(function(){
            $('#accionUrl').val($(this).data('id').substr(0,$(this).data('id').lastIndexOf("-")));
            $('#titulo').html('<h2 class="modal-title">'+"${confirmar}"+'</h2>');
            $('#cuerpo').html('<h3>'+"${deshabilitar}"+' '+decodeURIComponent($(this).data('id').substr($(this).data('id').lastIndexOf("-")+1))+'?</h3>');
            $('#basic').modal('show');
        });

        var form1 = $('#print-form');
        form1.validate({
            errorElement: 'span', //default input error message container
            focusInvalid: false, // do not focus the last invalid input
            rules: {
                visita: {
                    required: true
                },
                etiquetas: {
                    required: true
                }
            },
            errorPlacement: function ( error, element ) {
                // Add the `help-block` class to the error element
                error.addClass( 'form-control-feedback col-md-4' );
                if ( element.prop( 'type' ) === 'checkbox' ) {
                    error.insertAfter( element.parent( 'label' ) );
                } else {
                    //error.insertAfter( element ); //cuando no es input-group
                    error.insertAfter(element.parent('.input-group'));
                }
            },
            highlight: function ( element, errorClass, validClass ) {
                $( element ).addClass( 'form-control-danger' ).removeClass( 'form-control-success' );
                $( element ).parents( '.form-group' ).addClass( 'has-danger' ).removeClass( 'has-success' );
            },
            unhighlight: function (element, errorClass, validClass) {
                $( element ).addClass( 'form-control-success' ).removeClass( 'form-control-danger' );
                $( element ).parents( '.form-group' ).addClass( 'has-success' ).removeClass( 'has-danger' );
            },
            submitHandler: function (form) {
                $('#confirModal').modal('show');
            }
        });

        $('#btnPrint').click(function () {
            form1.valid();
        });

        $('#okPrint').click(function () {
            printSelected();
        });

        $('#etiquetas').select2();

        function printSelected() {
            var oTT = TableTools.fnGetInstance('lista_casos');
            var aSelectedTrs = oTT.fnGetSelected();
            var len = aSelectedTrs.length;
            if (len > 0) {
                var casas = [];
                //var codesLabLineal = [];
                for (var i = 0; i < len; i++) {
                    //console.log(table.row(aSelectedTrs[i]).data());
                    var codigoCasa = table.row(aSelectedTrs[i]).data()[0];
                    if (i + 1 < len) {
                        casas += codigoCasa + ",";
                    } else {
                        casas += codigoCasa;
                    }
                }
                //codesLab = reemplazar(codesLab, ".", "*");
                console.log(casas);
                getCodesLab(casas);

            } else {
                toastr.warning("seleccione al menos un caso");
            }
        }

        function getCodesLab(casas)
        {
            $.getJSON( "${getCodesUrl}"
                    , {casas : casas,
                     visita : $("#visita").val()}
                    , function( data )
                    {
                        var total = data.TOTAL;
                        var codigosLab="";
                        for(var indice =1;indice<=total;indice++){
                            if (indice < total) {
                                codigosLab += data["CODIGO"+indice] + ",";
                            } else {
                                codigosLab += data["CODIGO"+indice];
                            }
                        }
                        imprimir(codigosLab);
                    }
            ).fail(function(XMLHttpRequest, textStatus, errorThrown) {
                        alert( "error:" + errorThrown);
                    });
        }

        function imprimir(strBarCodes){
            $.getJSON("http://localhost:13001/print", {
                barcodes: strBarCodes,
                copias: 1,
                ajax:'false'
            }, function (data) {
                console.log(data);
                $('#confirModal').modal('toggle');
                toastr.success("etiquetas impresas");
            }).fail(function (jqXHR) {
                console.log(jqXHR);
                $('#confirModal').modal('toggle');
                if (jqXHR.status!=200 && jqXHR.status!=0) {
                    toastr.error("error al imprimir etiquetas","Error",{timeOut: 0});
                }
            });
        }

    });

    function ejecutarAccion() {
        window.location.href = $('#accionUrl').val();
    }
</script>
</body>
</html>