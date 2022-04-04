<%-- 
    Document   : Agregar
    Created on : 23/03/2022, 03:46:38 PM
    Author     : jcatl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>proyecto store</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/hojadeestilos.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
</head>
<body>
    <header class ="header">
        <a href ="index.jsp" alt="Logotipo">
            <img class =" header__logo" src="img/icono.png">
        </a>
    </header>
    <nav class = "nav boxshadow">
        <a class ="nav__enlace"href="Controladores?accion=index">Lista Clientes</a>
        <a class ="nav__enlace" href="Controladores?accion=agregar">Agregar Cliente</a>
    </nav>
    <main class ="contenedor">
        <h1>Nuevo Cliente</h1>
        <div class="camisa">
            <div class ="camisa__Datos boxshadow">
                <form class ="formulario" action = "Controladores">
                    <div class="formulario__bloque">
                        <label class ="label" for ="Nombre">Nombre: </label>
                        <input required class ="caja" type="text" id ="Nombre" name = "Nombre">
                    </div>
                    <div class="formulario__bloque">
                        <label class ="label" for ="Edad">Edad: </label>
                        <input required class ="caja" type="number" id ="Edad" name = "Edad">
                    </div>
                    <div class="formulario__bloque">
                        <label class ="label" for ="Civil">Estado Civil: </label>
                        <select class ="caja" id ="Civil" name ="Civil"> <option>Soltero</option><option>Casado</option></select>
                    </div>
                    <div class="formulario__bloque">
                        <label class ="label" for ="Sexo">Sexo: </label>
                        <select class ="caja" id ="Sexo" name ="Sexo"><option>M</option><option>F</option></select>
                    </div>
                    <div class="formulario__bloque">
                        <label class ="label" for ="Trabaja">Trabaja: </label>
                        <select class ="caja" id ="Trabaja" name = "Trabaja"><option>SI</option><option>NO</option></select>
                    </div>
                    
                    <div class ="FormAgregar__Botones">
                        <button class = "formulario__boton" type="submit" name = "accion" value="add">CREAR CLIENTE</button>
                    </div>
                    
                </form>
                
            </div>
        </div>
         
    </main>
    <footer class ="footer">
        <p class = "footer__parrafo">Derechos reservados</p>
    </footer>
</body>
</html>