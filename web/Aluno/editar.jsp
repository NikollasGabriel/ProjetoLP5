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

        <title>Editar Aluno</title>                                                                        
    </head>
    <body>
        <nav>
            <object width="100%" height="65px" data="./menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Editar Aluno</h1>

            <form action="FrontController?action=EditarAluno" method="post" name="frmManterPessoa" onsubmit="">

                <div class="form-group">
                    <label for="usr">Id:</label>
                    <input type="text" class="form-control" id="usr" name="txtIdPessoa" value="${aluno.idPessoa}" readonly>
                </div>
                <div class="form-group">
                    <label for="usr">Nome:</label>
                    <input type="text" class="form-control" id="usr" name="txtNomePessoa" value="${aluno.nomePessoa}">
                </div>
                <div class="form-group">
                    <label for="usr">Idade:</label>
                    <input type="text" class="form-control" id="usr" name="txtIdadePessoa" value="${aluno.idadePessoa}">
                </div>
                <div class="form-group">
                    <label for="usr">Numero de faltas:</label>
                    <input type="text" class="form-control" id="usr" name="txtNumeroFaltas" value="${aluno.numeroFaltas}">
                </div>
                <div class="form-group">
                    <label for="usr">Media das Notas:</label>
                    <input type="text" class="form-control" id="usr" name="txtMediaNotas" value="${aluno.mediaNotas}">
                </div>
                <div class="form-group">
                    <label for="usr">Situação:</label>
                    <input type="text" class="form-control" id="usr" name="txtSituacao" value="${aluno.situacao.getEstado()}">
                </div>
                <div class="form-group">
                    <label for="usr">Turma:</label>
                    <select class="selectpicker" name="txtIdTurma">
                        <option value="0" <c:if test="${turma.idTurma != null}"> selected</c:if>></option>
                        <c:forEach items="${turmas}" var="turma">
                            <option value="${turma.idTurma}" <c:if test="${turma.idTurma == aluno.turma.idTurma}"> selected</c:if>>
                                ${turma.periodoTurma}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-default" name="btnConfirmar" value="Confirmar">Confirmar</button>
            </form>
        </div>
    </body>
</html>