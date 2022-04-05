<%-- 
    Document   : Buscar
    Created on : 23/03/2022, 03:47:07 PM
    Author     : jcatl
--%>

<%@page import = "Modelo.Cliente"%>
<%@page import = "ModeloDAO.ClienteDAO"%>
<%@page import = "java.util.List"%>
<%@page import = "java.util.Iterator"%>

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
    <nav class = "nav boxshadow buscador">
        <form class ="buscador" action = "Controladores">
            <button class ="nav__enlace botonBuscar" type="submit" name = "accion" value="buscar" >Buscar</button>
             <input required class ="buscar" type="number"  id ="idbuscar" name="idbuscar">
        </form>
    </nav>
    <main class ="contenedor">
        <h1>Resultados de la busqueda: </h1>

        <div class="grid ">
<%
    String p = (String)request.getAttribute("id");
    int id = Integer.parseInt(p);
    ClienteDAO dao = new ClienteDAO();
    List<Cliente> clientes = dao.listas();
    Iterator<Cliente> iter = clientes.iterator();
    Cliente cli = null;
    String sexo;
    while(iter.hasNext()){
        cli = iter.next();
        if(cli.getId() == id){
             if("M".equals(cli.getSexo())){
                sexo = "hombre";
            }
            else{
                sexo = "mujer";
            }
            
%>
            <div class =" producto boxshadow" boxshadow>
                <a href="Controladores?accion=editar&id=<%=cli.getId()%>">
                    <img src="img/<%=sexo%>.jpg" alt="image producto" class =" producto__imagen">
                    <div class="producto__datos">
                        <p class="producto__nombre"><%=cli.getNombre()%></p>
                        <p class="producto__precio"> Id: <%=cli.getId()%></p>
                        <p class="producto__precio"> puntaje: <%=cli.getPuntaje()%></p>
                    </div>
                </a>
            </div>
            <%}}%>
        </div>
    </main>
    <footer class ="footer">
        <p class = "footer__parrafo">Derechos reservados</p>
    </footer>
</body>
</html>