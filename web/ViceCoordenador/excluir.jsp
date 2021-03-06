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

        <title>Excluir Vice-Coordenador</title>                                                                        
    </head>
    <body>
        <nav>
            <object width="100%" height="65px" data="./menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Excluir Vice-Coordenador</h1>

            <form action="FrontController?action=ApagarViceCoordenador" method="post" name="frmApagarViceCoordenador" onsubmit="">

                <div class="form-group">
                    <label for="usr">Id:</label>
                    <input type="text" class="form-control" id="usr" name="txtIdViceCoordenador" value="${viceCoordenador.idPessoa}" readonly>
                </div>
                <div class="form-group">
                    <label for="usr">Nome:</label>
                    <input type="text" class="form-control" id="usr" name="txtNomeViceCoordenador" value="${viceCoordenador.nomePessoa}" readonly>
                </div>
                <div class="form-group">
                    <label for="usr">Idade:</label>
                    <input type="text" class="form-control" id="usr" name="txtIdadeViceCoordenador" value="${viceCoordenador.idadePessoa}" readonly>
                </div>
                <div class="form-group">
                    <label for="usr">Tempo de Servico:</label>
                    <input type="text" class="form-control" id="usr" name="txtTempoServico" value="${viceCoordenador.tempoServico}" readonly>
                </div>
                <div class="form-group">
                    <label for="usr">Salario Base:</label>
                    <input type="text" class="form-control" id="usr" name="txtSalario" value="${viceCoordenador.salarioBase}" readonly>
                </div>                
                <button type="submit" class="btn btn-default" name="btnConfirmar" value="Confirmar">Confirmar</button>
            </form>
        </div>
    </body>
</html>