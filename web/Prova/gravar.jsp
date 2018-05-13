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

        <title>Cadastrar Prova</title>                                                                        
    </head>
    <body>
        <nav>
            <object width="100%" height="65px" data="./menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Cadastrar Prova</h1>

            <form action="FrontController?action=GravarProva" method="post" name="frmManterProva" onsubmit="">

                <div class="form-group">
                    <label for="usr">Valor:</label>
                    <input type="text" class="form-control" id="usr" name="txtValor">
                </div>
                <div class="form-group">
                    <label for="usr">Disciplina:</label>
                    <select class="selectpicker" name="txtIdDisciplina">
                        <option value="0" <c:if test="${disciplina.idDisciplina != null}"> selected</c:if>></option>
                        <c:forEach items="${disciplinas}" var="disciplina">
                            <option value="${disciplina.idDisciplina}">
                                ${disciplina.nomeDisciplina}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="usr">Aluno:</label>
                    <select class="selectpicker" name="txtIdAluno">
                        <option value="0" <c:if test="${aluno.idPessoa != null}"> selected</c:if>></option>
                        <c:forEach items="${alunos}" var="aluno">
                            <option value="${aluno.idPessoa}">
                                ${aluno.nomePessoa}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="usr">Professor:</label>
                    <select class="selectpicker" name="txtIdProfessor">
                        <option value="0" <c:if test="${professor.idPessoa != null}"> selected</c:if>></option>
                        <c:forEach items="${professores}" var="professor">
                            <option value="${professor.idPessoa}">
                                ${professor.nomePessoa}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-default" name="btnConfirmar" value="Confirmar">Confirmar</button>
            </form>
        </div>
    </body>
</html>