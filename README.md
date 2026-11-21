# SMTP_Entrega_PSP

Entrega de la asignatura de PSP (Programación de Servicios y Procesos) del ciclo de DAM, abril de 2023. Pequeño programa en Java que envía un correo de prueba a través del servidor SMTP de Gmail con JavaMail.

## Qué hay

- `SMTP.java`: se conecta a `smtp.gmail.com` por el puerto 587 con STARTTLS, se autentica y envía un mensaje de texto.
- Compila con Java 17 y Maven. No he enviado ningún correo desde aquí, solo he comprobado que compila.

## Cómo probarlo

Las credenciales no están en el código: se leen de variables de entorno. Hace falta una cuenta de Gmail con una clave de aplicación.

```
export SMTP_USER=tu_cuenta@gmail.com
export SMTP_PASS=clave_de_aplicacion
export SMTP_TO=destinatario@ejemplo.com
mvn compile
mvn exec:java -Dexec.mainClass=org.jesuitasrioja.SMTP
```

## Licencia

MIT, ver [LICENSE](LICENSE).

---

# SMTP_Entrega_PSP (English)

Assignment for the PSP (Services and Processes Programming) subject of my DAM vocational course, April 2023. A small Java program that sends a test email through Gmail's SMTP server using JavaMail.

## What's inside

- `SMTP.java`: connects to `smtp.gmail.com` on port 587 with STARTTLS, authenticates and sends a plain-text message.
- It builds with Java 17 and Maven. I have not sent any email from here, I only checked that it compiles.

## Trying it

Credentials are not in the code: they are read from environment variables. You need a Gmail account with an app password.

```
export SMTP_USER=your_account@gmail.com
export SMTP_PASS=app_password
export SMTP_TO=recipient@example.com
mvn compile
mvn exec:java -Dexec.mainClass=org.jesuitasrioja.SMTP
```

## License

MIT, see [LICENSE](LICENSE).
