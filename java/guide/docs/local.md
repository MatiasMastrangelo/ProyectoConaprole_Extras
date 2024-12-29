# Ejecución Local

En la siguiente guía encontrás los pasos para ejecutar localmente el proyecto backend.

### Pasos previos
1. [Descargar](https://www.oracle.com/es/java/technologies/downloads/#java21) e instalar JDK 21, o superior. 
Debes seleccionar el que corresponda a tu SO.
2. [Decargar](https://maven.apache.org/download.cgi) e instalar maven.
3. Clonar el repositorio del backend desde [github](https://github.com/ucudal/Conaprole_BackEnd).

### Ejecución
1. **Navega al directorio del proyecto**
   
   Abre una terminal o línea de comandos y navega al directorio raíz de tu proyecto (donde se encuentra el archivo `pom.xml`).

   ```bash
   cd /ruta/al/proyecto
   ```

2. **Compila el proyecto**
   
   Primero compila el proyecto para asegurarte de que no haya errores de compilación.

   ```bash
   mvn clean compile
   ```

3. **Ejecuta la aplicación Spring Boot**

   Ejecuta la aplicación con Maven, usando el siguiente comando.

   ```bash
   mvn spring-boot:run
   ```
   
4. **Verifica la ejecución**

   Accede desde tu navegador a la siguiente [http://localhost:8080/ping](http://localhost:8080/ping)
   Si todo esta bien, recibiras como respuesta: `pong`