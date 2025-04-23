# Proyecto: Cajero Automático

## Objetivo del Proyecto

Este proyecto simula el funcionamiento básico de un cajero automático en consola utilizando Java. Permite al usuario:
- Consultar el saldo disponible.
- Retirar dinero si hay suficiente saldo.
- Salir del sistema de manera segura.

El saldo se guarda en un archivo binario llamado `saldo.dat` para mantener la persistencia entre ejecuciones.

## Cómo Compilar y Ejecutar el Código

### Requisitos
- Tener instalado Java JDK 
- Un editor de texto o un entorno de desarrollo como Visual Studio, Eclipse, IntelliJ IDEA o NetBeans.

### Instrucciones

1. Guarda el archivo con el nombre `CajeroAutomatico.java`.
2. Abre una terminal o consola en el directorio donde se encuentra el archivo.
3. Compila el programa con el siguiente comando:
   ```bash
   javac CajeroAutomatico.java
   ```
4. Ejecuta el programa con:
   ```bash
   java CajeroAutomatico
   ```

> Nota: El archivo `saldo.dat` se creará automáticamente con un saldo inicial de Q1000 si no existe.

## Autor

**Gustavo Velásquez**