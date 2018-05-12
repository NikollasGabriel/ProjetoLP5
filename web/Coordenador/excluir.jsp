<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!doctype html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/bootstrap.css">
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>

        <title>Excluir Coordenador</title>                                                                        
    </head>
    <body>
        <nav>
            <object width="100%" height="65px" data="./menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Excluir Coordenador</h1>

            <form action="FrontController?action=ApagarCoordenador" method="post" name="frmApagarCoordenador" onsubmit="">

                <div class="form-group">
                    <label for="usr">Id:</label>
                    <input type="text" class="form-control" id="usr" name="txtIdCoordenador" value="${coordenador.idCoordenador}" readonly>
                </div>
                <div class="form-group">
                    <label for="usr">Nome:</label>
                    <input type="text" class="form-control" id="usr" name="txtNomePessoa" value="${coordenador.nome}" readonly>
                </div>
                <div class="form-group">
                    <label for="usr">Idade:</label>
                    <input type="text" class="form-control" id="usr" name="txtIdadePessoa" value="${coordenador.idade}" readonly>
                </div>
                <div class="form-group">
                    <label for="usr">Salario Base:</label>
                    <input type="text" class="form-control" id="usr" name="txtSalario" value="${coordenador.salarioBase}" readonly>
                </div>
                <div class="form-group">
                    <label for="usr">Salario:</label>
                    <input type="text" class="form-control" id="usr" name="txtSalario" value="${coordenador.salarioFinal}" readonly>
                </div>
                <div class="form-group">
                    <label for="usr">ViceCoordenador:</label>
                    <select class="selectpicker" name="txtIdViceCoordenador" readonly>
                        <option value="0" <c:if test="${viceCoordenador.idViceCoordenador != null}"> selected</c:if>></option>
                        <c:forEach items="${viceCoordenadores}" var="viceCoordenador">
                            <option value="${viceCoordenador.idViceCoordenador}" <c:if test="${viceCoordenador.idViceCoordenador == coordenador.viceCoordenador.idViceCoordenador}"> selected</c:if>>
                                ${viceCoordenador.nome}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-default" name="btnConfirmar" value="Confirmar">Confirmar</button>
            </form>
        </div>
    </body>
</html>