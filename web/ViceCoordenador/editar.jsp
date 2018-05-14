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

        <title>Editar ViceCoordenador</title>                                                                        
    </head>
    <body>
        <nav>
            <object width="100%" height="65px" data="./menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Editar ViceCoordenador</h1>

            <form action="FrontController?action=EditarViceViceCoordenador" method="post" name="frmEditarViceCoordenador" onsubmit="">

                <div class="form-group">
                    <label for="usr">Id:</label>
                    <input type="text" class="form-control" id="usr" name="txtIdViceCoordenador" value="${viceCoordenador.idViceCoordenador}" readonly>
                </div>
                <div class="form-group">
                    <label for="usr">Nome:</label>
                    <input type="text" class="form-control" id="usr" name="txtNome" value="${viceCoordenador.nome}">
                </div>
                <div class="form-group">
                    <label for="usr">Idade:</label>
                    <input type="text" class="form-control" id="usr" name="txtIdade" value="${viceCoordenador.idade}">
                </div>
                <div class="form-group">
                    <label for="usr">Tempo de Servico:</label>
                    <input type="text" class="form-control" id="usr" name="txtTempoServico" value="${viceCoordenador.tempoServico}">
                </div>
                <div class="form-group">
                    <label for="usr">Salario Base:</label>
                    <input type="text" class="form-control" id="usr" name="txtSalarioBase" value="${viceCoordenador.salarioBase}">
                </div>
                <div class="form-group">
                    <label for="usr">Salario Final:</label>
                    <input type="text" class="form-control" id="usr" name="txtSalarioFinal" value="${viceCoordenador.salarioFinal}" readonly>
                </div>
                <button type="submit" class="btn btn-default" name="btnConfirmar" value="Confirmar">Confirmar</button>
            </form>
        </div>
    </body>
</html>