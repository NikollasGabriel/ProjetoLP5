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

        <title>Consultar Vice-Coordenadors</title>
    </head>
    <body align="center">
        <nav>
            <object width="100%" height="65px" data="./menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Consultar Vice-Coordenadores</h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Idade</th>
                        <th>Tempo de Serviço</th>
                        <th>Salário Base</th>
                        <th>Salário com abono</th>
                        <th colspan=2>Ação:</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${viceCoordenadores}" var="viceCoordenador">
                        <tr>
                            <td><c:out value="${viceCoordenador.idPessoa}"></c:out></td>
                            <td><c:out value="${viceCoordenador.nomePessoa}"></c:out></td>
                            <td><c:out value="${viceCoordenador.idadePessoa}"></c:out></td>
                            <td><c:out value="${viceCoordenador.tempoServico}"></c:out></td>
                            <td><c:out value="${viceCoordenador.salarioBase}"></c:out></td>
                            <td><c:out value="${viceCoordenador.salarioFinal}"></c:out></td>
                            <td><a href="FrontController?action=PrepararEditarViceCoordenador&txtIdViceCoordenador=<c:out value="${viceCoordenador.idPessoa}"/>"><i class="icon-edit"></i>Editar</a> </td>
                            <td><a href="FrontController?action=PrepararApagarViceCoordenador&txtIdViceCoordenador=<c:out value="${viceCoordenador.idPessoa}"/>"><i class="icon-remove"></i>Excluir</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>            
            <form action="FrontController?action=PrepararGravarViceCoordenador" method="post" name="frmLerViceCoordenador" onsubmit="">
                <input type="submit" class="btn btn-default" value="Gravar">
            </form>
        </div>
    </body>
</html>
