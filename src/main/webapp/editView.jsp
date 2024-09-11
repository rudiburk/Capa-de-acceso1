<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Proveedor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
</head>
<body>
<section class="container">
    <h1>Editar Información del Proveedor</h1>
    <br>
    <div class="row">
        <form action="providerservlet?action=update" method="POST">
            <input type="hidden" name="id" value="${provider.id}">

            <label for="name" class="form-label">Nombre</label>
            <input type="text" class="form-control" name="name" id="name" value="${provider.name}" required>

            <label for="rut" class="form-label">Rut</label>
            <input type="text" class="form-control" name="rut" id="rut" value="${provider.rut}" required>

            <label for="email" class="form-label">Email</label>
            <input type="text" class="form-control" name="email" id="email" value="${provider.email}" required>

            <label for="address" class="form-label">Dirección</label>
            <input type="text" class="form-control" name="address" id="address" value="${provider.address}" required>

            <label for="phoneNumber" class="form-label">Teléfono</label>
            <input type="text" class="form-control" name="phoneNumber" id="phoneNumber" value="${provider.phoneNumber}" required>

            <label for="contact" class="form-label">Contacto</label>
            <input type="text" class="form-control" name="contact" id="contact" value="${provider.contact}" required>

            <label for="phoneNumberContact" class="form-label">Número de Contacto</label>
            <input type="text" class="form-control" name="phoneNumberContact" id="phoneNumberContact" value="${provider.phoneNumberContact}" required>
            <br>
            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
        </form>
    </div>
</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous">
</script>
</body>
</html>