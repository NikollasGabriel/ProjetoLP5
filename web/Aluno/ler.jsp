<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <title>Consultar Alunos</title>
    </head>
    <body align="center">
        <nav>
            <object width="100%" height="65px" data="./menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Consultar Alunos</h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Idade</th>
                        <th>Turma</th>
                        <th>Numero de faltas</th>
                        <th>Media das Notas</th>
                        <th>Situação</th>
                        <th colspan=2>Ação:</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${alunos}" var="aluno">
                        <tr>
                            <td><c:out value="${aluno.idPessoa}"></c:out></td>
                            <td><c:out value="${aluno.nomePessoa}"></c:out></td>
                            <td><c:out value="${aluno.idadePessoa}"></c:out></td>
                            <td><c:out value="${aluno.turma.idTurma}"></c:out></td>
                            <td><c:out value="${aluno.numeroFaltas}"></c:out></td>
                            <td><c:out value="${aluno.mediaNotas}"></c:out></td>
                            <td><c:out value="${aluno.situacao.getEstado()}"></c:out></td>
                            <td><a href="FrontController?action=PrepararEditarAluno&txtIdPessoa=<c:out value="${aluno.idPessoa}"/>"><i class="icon-edit"></i>Editar</a> </td>
                            <td><a href="FrontController?action=PrepararApagarAluno&txtIdPessoa=<c:out value="${aluno.idPessoa}"/>"><i class="icon-remove"></i>Excluir</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>            
            <form action="FrontController?action=PrepararGravarAluno" method="post" name="frmManterAluno" onsubmit="">
                <input type="submit" class="btn btn-default" value="Gravar">
            </form>
        </div>
    </body>
</html>
