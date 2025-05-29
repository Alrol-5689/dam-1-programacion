@echo off
setlocal enabledelayedexpansion

echo Compilando todos los proyectos en la carpeta actual...

for /d %%P in (*) do (
    if exist "%%P\src" (
        echo ----------------------------
        echo Procesando proyecto: %%P
        echo ----------------------------

        rem Eliminar y recrear carpeta bin
        if exist "%%P\bin" (
            rd /s /q "%%P\bin"
        )
        mkdir "%%P\bin"

        rem Compilar .java directamente en src/
        for %%F in (%%P\src\*.java) do (
            javac -d "%%P\bin" -sourcepath "%%P\src" "%%F"
        )

        rem Compilar .java en subcarpetas de src/
        for /r %%F in (%%P\src\*\.java) do (
            javac -d "%%P\bin" -sourcepath "%%P\src" "%%F"
        )

        echo ✅ Proyecto %%P procesado
        echo.
    )
)

echo ----------------------------
echo Proceso de compilación terminado.
pause
