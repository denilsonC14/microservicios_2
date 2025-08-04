from locust import HttpUser, task, between 
import random
import time

class MyUser(HttpUser):
    host = "http://localhost:8080"

    wait_time = between(0.5, 1.5)

    @task
    def crear_autor(self):
        nombre = f"Autor{random.randint(1, 1000)}"
        apellido = f"Apellido{random.randint(1, 1000)}"
        # Genera un identificador único usando timestamp y random
        unique = f"{int(time.time() * 1000)}{random.randint(1000,9999)}"
        email = f"{nombre.lower()}.{apellido.lower()}{unique}@email.com"[:20]  # máx 20 caracteres
        orcid = f"0000-0000-0000-{unique[-4:]}"[:20]  # máx 20 caracteres
        institucion = "PUCP"  # máx 50 caracteres
        nacionalidad = "Perú"  # máx 50 caracteres
        telefono = f"+51{random.randint(10000000, 99999999)}"[:20]  # máx 20 caracteres
        fecha_nacimiento = f"1982-12-{random.randint(1, 28):02d}"[:50]  # máx 50 caracteres

        payload = {
            "nombre": nombre[:50],
            "apellido": apellido[:50],
            "email": email,
            "orcid": orcid,
            "institucion": institucion,
            "nacionalidad": nacionalidad,
            "telefono": telefono,
            "fechaNacimiento": fecha_nacimiento
        }

        # Realizar la solicitud POST
        response = self.client.post("/publicaciones/autor", json=payload)