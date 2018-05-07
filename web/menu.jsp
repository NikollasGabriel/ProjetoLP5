<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <style>
        body {
            padding:0px;
            margin:0px;
        }

        ul li { display: inline; }
        ul {
            padding:0;
            margin:0;
            float: left;
            width: 100%;
            background-color: #333;
            list-style:none;
            font:80% Tahoma;
            overflow: hidden;

        }

        li {
            float: left;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover:not(.active) {
            background-color: #1c38b2;
        }

        .active {
            background-color: #1c38b2;
        }
    </style>
    <head>
        <meta charset="utf-8">
    </head>
    <body>

        <ul>
            <li>
                <a class="active" href="index.jsp" target="_parent">Home</a>
            </li>
            <li>
                <a href="FrontController?action=LerDisciplina" target="_parent">Disciplina</a>
            </li>
            <li>
               <a href="FrontController?action=LerPessoa" target="_parent">Pessoa</a>
            </li>
            <li>
                <a href="FrontController?action=LerProva" target="_parent">Prova</a>
            </li>
            <li>
                <a href="FrontController?action=LerTurma" target="_parent">Turma</a>
            </li>
        </ul>
    </body>
</html>
