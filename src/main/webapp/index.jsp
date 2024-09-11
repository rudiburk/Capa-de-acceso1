<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Proveedores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
</head>
<body>
    <section class="container">
        <h1><strong>Ingresa tus datos: </strong></h1>
        <br>
        <br>
        <div class="row">
            <form action="providerservlet?action=insert" method="POST">
                <label for="name" class="form-label">Nombre</label>
                <input type="text" class="form-control" name="name" id="name" placeholder="Nombre" aria-label="Nombre" required>

                <label for="rut" class="form-label">Rut</label>
                <input type="text" class="form-control" name="rut"  id="rut" placeholder="Rut" aria-label="Rut" required>

                <label for="address" class="form-label">Dirección</label>
                <input type="text" class="form-control" name="address" id="address" placeholder="Dirección" aria-label="Dirección" required>

                <label for="email" class="form-label">Email</label>
                <input type="text" class="form-control" name="email" id="email" placeholder="Email" aria-label="Email" required>

                <label for="phoneNumber" class="form-label">Teléfono</label>
                <input type="text" class="form-control" name="phoneNumber" id="phoneNumber" placeholder="Teléfono" aria-label="Teléfono" required>

                <label for="contact" class="form-label">Contácto</label>
                <input type="text" class="form-control" name="contact" id="contact" placeholder="Contácto" aria-label="Contácto" required>

                <label for="phoneNumberContact" class="form-label">Número de Contacto</label>
                <input type="text" class="form-control" name="phoneNumberContact" id="phoneNumberContact" placeholder="Número de Contácto" aria-label="Número de Contácto" required>
                <br>
                <button type="submit" class="btn btn-primary btn-lg" value="insertProvider">Ingresar</button>
            </form>
        </div>
    </section>

<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous">
</script>
</body>
</html>