# PerfuLandia
Caso PerfuLandia (Desarrollo FullStack 2025)

📌 ENDPOINTS PARA POSTMAN - API PerfuLandia

-----------------------------
🔹 1. ADMIN
-----------------------------
GET    /api/v1/admin                Listar todos los admins
POST   /api/v1/admin                Crear admin
Body (JSON): {"nombre": "admin1", "contraseña": "123456"}
PUT    /api/v1/admin/{id}           Actualizar admin
Body (JSON): {"nombre": "adminActualizado", "contraseña": "nueva123"}
DELETE /api/v1/admin/{id}           Eliminar admin

-----------------------------
🔹 2. GERENTE (Gestionado por Admin)
-----------------------------
GET    /api/v1/gerente/admin/{adminId}  Listar gerentes de un admin
POST   /api/v1/gerente               Crear gerente
Body (JSON): {
"nombre": "gerente1",
"contraseña": "ger123",
"sucursal": "Sucursal A",
"admin": {"id": 1}
}
PUT    /api/v1/gerente/{id}          Actualizar gerente
Body (JSON): {"nombre": "gerenteActualizado", "sucursal": "Sucursal B"}
DELETE /api/v1/gerente/{id}          Eliminar gerente

-----------------------------
🔹 3. EMPLEADO (Gestionado por Gerente)
-----------------------------
GET    /api/v1/empleado/gerente/{gerenteId}  Listar empleados de un gerente
POST   /api/v1/empleado            Crear empleado
Body (JSON): {
"nombre": "empleado1",
"contraseña": "emp123",
"codigoEmpleado": "EMP-001",
"jefe": {"id": 1}
}
PUT    /api/v1/empleado/{id}       Actualizar empleado
Body (JSON): {"nombre": "empleadoActualizado", "codigoEmpleado": "EMP-002"}
DELETE /api/v1/empleado/{id}       Eliminar empleado

-----------------------------
🔹 4. CLIENTE
-----------------------------
GET    /api/v1/cliente              Lista de todos los clientes

POST   /api/v1/cliente              Crear cliente (autoregistro)
Body (JSON): {"nombre": "Juan", "correo": "juan@test.com", "contraseña": "123"}
PUT    /api/v1/cliente/{id}         Actualizar perfil
Body (JSON): {"nombre": "Juan Actualizado", "correo": "juan.nuevo@test.com"}

🔹 Admin gestiona clientes:
GET    /api/v1/admin/clientes       Listar todos los clientes
DELETE /api/v1/admin/clientes/{id}  Eliminar cliente

-----------------------------
🔹 5. PRODUCTO (Gestionado por Empleado)
-----------------------------
GET    /api/v1/producto             Listar productos
POST   /api/v1/producto             Crear producto
Body (JSON): {"nombreProducto": "Laptop", "cantidadStock": 10, "precio": 1500.50}
PUT    /api/v1/producto/{id}        Actualizar producto
Body (JSON): {"nombreProducto": "Laptop Pro", "cantidadStock": 5, "precio": 2000.00}
DELETE /api/v1/producto/{id}        Eliminar producto

-----------------------------
🔹 6. COMPRA
-----------------------------
POST   /api/v1/compras              Realizar compra
Body (JSON): {"productoId": 1, "clienteId": 1, "cantidad": 2}
GET    /api/v1/compras              Listar compras (Admin/Empleado)
DELETE /api/v1/compras/{id}         Eliminar compra (Admin)


⚠️ NOTAS:
1. Reemplaza {id} con IDs reales
2. Para relaciones (ej: admin.id), asegúrate que el ID exista