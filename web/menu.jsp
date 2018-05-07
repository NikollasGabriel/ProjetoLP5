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
                <a href="gravar.jsp" target="_parent">Gravar</a>
            </li>
            <li>
                <a href="ler.jsp" target="_parent">Ler</a>
            </li>
            <li>
                <a href="editar.jsp" target="_parent">Editar</a>
            </li>
            <li>
                <a href="excluir.jsp" target="_parent">Apagar</a>
            </li>
        </ul>
    </body>
</html>
