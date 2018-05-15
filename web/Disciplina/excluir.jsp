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

        <title>Excluir Disciplina</title>                                                                        
    </head>
    <body>
        <nav>
            <object width="100%" height="65px" data="./menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Excluir Disciplina</h1>

            <form action="FrontController?action=ApagarDisciplina" method="post" name="frmManterDisciplina" onsubmit="">

                <div class="form-group">
                    <label for="usr">Codigo da disciplina:</label>
                    <input type="text" class="form-control" id="usr" name="txtIdDisciplina" value="${disciplina.idDisciplina}" readonly>
                </div>
                <div class="form-group">
                    <label for="usr">Nome da disciplina:</label>
                    <input type="text" class="form-control" id="usr" name="txtNomeDisciplina" value="${disciplina.nomeDisciplina}" readonly>
                </div>
                <div class="form-group">
                    <label for="usr">Numero de creditos:</label>
                    <input type="text" class="form-control" id="usr" name="txtNumeroCreditos" value="${disciplina.numeroCreditos}" readonly>
                </div>
                <div class="form-group">
                    <label for="usr">Numero de vagas:</label>
                    <input type="text" class="form-control" id="usr" name="txtNumeroVagas" value="${disciplina.numeroVagas}" readonly>
                </div>                    
                <button type="submit" class="btn btn-default" name="btnConfirmar" value="Confirmar">Confirmar</button>
            </form>
        </div>

    </body>
</html>