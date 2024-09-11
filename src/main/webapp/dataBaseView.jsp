
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Proveedores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Lista de Proveedores</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>RUT</th>
            <th>Email</th>
            <th>Dirección</th>
            <th>Teléfono</th>
            <th>Contacto</th>
            <th>Teléfono de Contacto</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="provider" items="${listProviders}">
                <tr>
                    <td>${provider.id}</td>
                    <td>${provider.name}</td>
                    <td>${provider.rut}</td>
                    <td>${provider.email}</td>
                    <td>${provider.address}</td>
                    <td>${provider.phoneNumber}</td>
                    <td>${provider.contact}</td>
                    <td>${provider.phoneNumberContact}</td>
                    <td>
                        <a href="providerservlet?action=edit&id=${provider.id}" class="btn btn-primary">Editar</a>

                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="index.jsp" class="btn btn-success">Agregar Nuevo Proveedor</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous">

</script>
</body>
</html>