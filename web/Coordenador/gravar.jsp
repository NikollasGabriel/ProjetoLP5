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

        <title>Cadastrar Coordenador</title>                                                                        
    </head>
    <body>
        <nav>
            <object width="100%" height="65px" data="./menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Cadastrar Coordenador</h1>

            <form action="FrontController?action=GravarCoordenador" method="post" name="frmGravarCoordenador" onsubmit="">

                <div class="form-group">
                    <label for="usr">Nome:</label>
                    <input type="text" class="form-control" id="usr" name="txtNomeCoordenador">
                </div>
                <div class="form-group">
                    <label for="usr">Idade:</label>
                    <input type="text" class="form-control" id="usr" name="txtIdadeCoordenador">
                </div>
                <div class="form-group">
                    <label for="usr">Tempo de Serviço:</label>
                    <input type="text" class="form-control" id="usr" name="txtTempoServico">
                </div>
                <div class="form-group">
                    <label for="usr">Salario base:</label>
                    <input type="text" class="form-control" id="usr" name="txtSalarioBase">
                </div>
                <div class="form-group">
                    <label for="usr">ViceCoordenador:</label>
                    <select class="selectpicker" name="txtIdViceCoordenador">
                        <option value="0" <c:if test="${viceCoordenador.idPessoa != null}"> selected</c:if>></option>
                        <c:forEach items="${viceCoordenadores}" var="viceCoordenador">
                            <option value="${viceCoordenador.idPessoa}">
                                ${viceCoordenador.nomePessoa}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-default" name="btnConfirmar" value="Confirmar">Confirmar</button>
            </form>
        </div>
    </body>
</html>