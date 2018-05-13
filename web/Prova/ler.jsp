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

        <title>Consultar Provas</title>
    </head>
    <body align="center">
        <nav>
            <object width="100%" height="65px" data="./menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Consultar Provas</h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Valor</th>
                        <th>Aluno</th>
                        <th>Disciplina</th>
                        <th>Professor</th>
                        <th colspan=2>Ação:</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${provas}" var="prova">
                        <tr>
                            <td><c:out value="${prova.idProva}"></c:out></td>
                            <td><c:out value="${prova.valor}"></c:out></td>
                            <td><c:out value="${prova.aluno.nomePessoa}"></c:out></td>
                            <td><c:out value="${prova.disciplina.nomeDisciplina}"></c:out></td>
                            <td><c:out value="${prova.professor.nomePessoa}"></c:out></td>
                            <td><a href="FrontController?action=PrepararEditarProva&txtIdProva=<c:out value="${prova.idProva}"/>"><i class="icon-edit"></i>Editar</a> </td>
                            <td><a href="FrontController?action=PrepararApagarProva&txtIdProva=<c:out value="${prova.idProva}"/>"><i class="icon-remove"></i>Excluir</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>            
            <form action="FrontController?action=PrepararGravarProva" method="post" name="frmManterTurma" onsubmit="">
                <input type="submit" class="btn btn-default" value="Gravar">
            </form>
        </div>
    </body>
</html>
