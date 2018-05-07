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

        <title>Consultar Pessoas</title>
    </head>
    <body align="center">
        <nav>
            <object width="100%" height="65px" data="./menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Consultar Pessoas</h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Idade</th>
                        <th>Turma</th>
                        <th colspan=2>Ação:</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${pessoas}" var="pessoa">
                        <tr>
                            <td><c:out value="${pessoa.idPessoa}"></c:out></td>
                            <td><c:out value="${pessoa.nomePessoa}"></c:out></td>
                            <td><c:out value="${pessoa.idadePessoa}"></c:out></td>
                            <td><c:out value="${pessoa.turma.idTurma}"></c:out></td>
                            <td><a href="FrontController?action=PrepararEditarPessoa&txtIdPessoa=<c:out value="${pessoa.idPessoa}"/>"><i class="icon-edit"></i>Editar</a> </td>
                            <td><a href="FrontController?action=PrepararApagarPessoa&txtIdPessoa=<c:out value="${pessoa.idPessoa}"/>"><i class="icon-remove"></i>Excluir</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>            
            <form action="FrontController?action=PrepararGravarPessoa" method="post" name="frmManterPessoa" onsubmit="">
                <input type="submit" class="btn btn-default" value="Gravar">
            </form>
        </div>
    </body>
</html>
