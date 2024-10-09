CREATE DATABASE DONATIVOSPRUEBA;
USE DONATIVOSPRUEBA;

CREATE TABLE Entidad (
    idEntidad VARCHAR(10) PRIMARY KEY, -- Cambiado a VARCHAR para el nuevo formato de idEntidad
    documentoIdentidad VARCHAR(20) NOT NULL UNIQUE, -- Documento de identidad
    password VARCHAR(255) NOT NULL, -- Contraseña en formato hash
    email VARCHAR(255) NOT NULL UNIQUE, -- Correo electrónico
    tipoEntidad ENUM('Persona', 'Empresa', 'Administrador') NOT NULL -- Tipo de entidad
);

CREATE TABLE Persona (
    idEntidad VARCHAR(10) NOT NULL PRIMARY KEY, -- idEntidad como clave primaria y foránea
    nombre VARCHAR(255) NOT NULL, -- Nombre completo de la persona
    telefono VARCHAR(15), -- Número telefónico de la persona
    FOREIGN KEY (idEntidad) REFERENCES Entidad(idEntidad) ON DELETE CASCADE
);

CREATE TABLE Empresa (
    idEntidad VARCHAR(10) NOT NULL PRIMARY KEY, -- idEntidad como clave primaria y foránea
    direccion VARCHAR(255) NOT NULL, -- Dirección de la empresa
    tipoEmpresa VARCHAR(50), -- Tipo de empresa
    telefono VARCHAR(15), -- Número telefónico de la empresa
    FOREIGN KEY (idEntidad) REFERENCES Entidad(idEntidad) ON DELETE CASCADE
);

CREATE TABLE Administrador (
    idEntidad VARCHAR(10) NOT NULL, -- Relación con la tabla Entidad
    FOREIGN KEY (idEntidad) REFERENCES Entidad(idEntidad) ON DELETE CASCADE -- Clave foránea hacia Entidad
);

-- Tabla Cuenta
CREATE TABLE Cuenta (
    idCuenta INT AUTO_INCREMENT PRIMARY KEY, -- Identificador único para la cuenta
    idEntidad VARCHAR(10) NOT NULL, -- Relación con la entidad
    numC VARCHAR(20) NOT NULL, -- Número de Cuenta
    cvc INT NOT NULL, -- Código de seguridad
    fV INT NOT NULL, -- Fecha de Vencimiento (en formato MMYY)
    tipoCuenta ENUM('Bancaria', 'Tarjeta de Crédito') NOT NULL, -- Tipo de cuenta
    FOREIGN KEY (idEntidad) REFERENCES Entidad(idEntidad) ON DELETE CASCADE -- Clave foránea hacia Entidad
);

SELECT * FROM entidad;
SELECT * FROM persona;
DELETE FROM Entidad WHERE idEntidad = "24P345p";
-- generar identidad --

DELIMITER //

CREATE PROCEDURE generarIdEntidad(
    IN documentoIdentidad VARCHAR(20),
    IN tipoEntidad ENUM('Persona', 'Empresa', 'Administrador'),
    IN email VARCHAR(255),
    OUT nuevoIdEntidad VARCHAR(10)
)
BEGIN
    DECLARE anioActual VARCHAR(2);
    DECLARE letraTipo CHAR(1);
    DECLARE ultimosTresDigitos VARCHAR(3);
    DECLARE letraEmail CHAR(1);

    -- Obtener los dos últimos dígitos del año actual
    SET anioActual = RIGHT(YEAR(CURDATE()), 2);

    -- Obtener la primera letra del tipo de entidad
    SET letraTipo = LEFT(tipoEntidad, 1);

    -- Obtener los últimos 3 dígitos del documento de identidad
    SET ultimosTresDigitos = RIGHT(documentoIdentidad, 3);

    -- Obtener la primera letra del email
    SET letraEmail = LEFT(email, 1);

    -- Concatenar para formar el nuevo idEntidad
    SET nuevoIdEntidad = CONCAT(anioActual, letraTipo, ultimosTresDigitos, letraEmail);
END //

DELIMITER ;



-- insertar persona---
DELIMITER //

CREATE PROCEDURE insertarPersona(
    IN documentoIdentidad VARCHAR(20),
    IN password VARCHAR(255),
    IN email VARCHAR(255),
    IN nombre VARCHAR(255),
    IN telefono VARCHAR(15)
)
BEGIN
    DECLARE idEntidad VARCHAR(10);

    -- Generar el idEntidad
    CALL generarIdEntidad(documentoIdentidad, 'Persona', email, idEntidad);

    -- Insertar en la tabla Entidad
    INSERT INTO Entidad (idEntidad, documentoIdentidad, password, email, tipoEntidad)
    VALUES (idEntidad, documentoIdentidad, password, email, 'Persona');

    -- Insertar en la tabla Persona
    INSERT INTO Persona (idEntidad, nombre, telefono)
    VALUES (idEntidad, nombre, telefono);
END //

DELIMITER ;

-- insertar empresa--
DELIMITER //

CREATE PROCEDURE insertarEmpresa(
    IN documentoIdentidad VARCHAR(20),
    IN password VARCHAR(255),
    IN email VARCHAR(255),
    IN direccion VARCHAR(255),
    IN tipoEmpresa VARCHAR(50),
    IN telefono VARCHAR(15)
)
BEGIN
    DECLARE idEntidad VARCHAR(10);

    -- Generar el idEntidad
    CALL generarIdEntidad(documentoIdentidad, 'Empresa', email, idEntidad);

    -- Insertar en la tabla Entidad
    INSERT INTO Entidad (idEntidad, documentoIdentidad, password, email, tipoEntidad)
    VALUES (idEntidad, documentoIdentidad, password, email, 'Empresa');

    -- Insertar en la tabla Empresa
    INSERT INTO Empresa (idEntidad, direccion, tipoEmpresa, telefono)
    VALUES (idEntidad, direccion, tipoEmpresa, telefono);
END //

DELIMITER ;

--insertar administrador--

DELIMITER //

CREATE PROCEDURE insertarAdministrador(
    IN documentoIdentidad VARCHAR(20),
    IN password VARCHAR(255),
    IN email VARCHAR(255)
)
BEGIN
    DECLARE idEntidad VARCHAR(10);

    -- Generar el idEntidad
    CALL generarIdEntidad(documentoIdentidad, 'Administrador', email, idEntidad);

    -- Insertar en la tabla Entidad
    INSERT INTO Entidad (idEntidad, documentoIdentidad, password, email, tipoEntidad)
    VALUES (idEntidad, documentoIdentidad, password, email, 'Administrador');

    -- Insertar en la tabla Administrador
    INSERT INTO Administrador (idEntidad)
    VALUES (idEntidad);
END //

DELIMITER ;
-- obtener persona --

DELIMITER //

CREATE PROCEDURE obtenerPersona(IN idEntidad VARCHAR(10))
BEGIN
    SELECT E.idEntidad, E.documentoIdentidad, E.password, E.email, P.nombre, P.telefono
    FROM Entidad E
    JOIN Persona P ON E.idEntidad = P.idEntidad
    WHERE E.idEntidad = idEntidad;
END //

DELIMITER ;

-- obtener emp --
DELIMITER //

CREATE PROCEDURE obtenerEmpresa(IN idEntidad VARCHAR(10))
BEGIN
    SELECT E.idEntidad, E.documentoIdentidad, E.password, E.email, Emp.direccion, Emp.tipoEmpresa, Emp.telefono
    FROM Entidad E
    JOIN Empresa Emp ON E.idEntidad = Emp.idEntidad
    WHERE E.idEntidad = idEntidad;
END //

DELIMITER ;

-- obtener admin --
DELIMITER //

CREATE PROCEDURE obtenerAdministrador(IN idEntidad VARCHAR(10))
BEGIN
    SELECT E.idEntidad, E.documentoIdentidad, E.email
    FROM Entidad E
    JOIN Administrador A ON E.idEntidad = A.idEntidad
    WHERE E.idEntidad = idEntidad;
END //

DELIMITER ;
-- update -- 
-- primero entidad --
DELIMITER //

CREATE PROCEDURE actualizarEyA(
    IN idEntidad VARCHAR(10),
    IN nuevoDocumentoIdentidad VARCHAR(20),
    IN nuevoPassword VARCHAR(255),
    IN nuevoEmail VARCHAR(255)
)
BEGIN
    IF nuevoDocumentoIdentidad IS NOT NULL THEN
        UPDATE Entidad
        SET documentoIdentidad = nuevoDocumentoIdentidad
        WHERE idEntidad = idEntidad;
    END IF;

    IF nuevoPassword IS NOT NULL THEN
        UPDATE Entidad
        SET password = nuevoPassword
        WHERE idEntidad = idEntidad;
    END IF;

    IF nuevoEmail IS NOT NULL THEN
        UPDATE Entidad
        SET email = nuevoEmail
        WHERE idEntidad = idEntidad;
    END IF;
END //

DELIMITER ;
-- persona -- 
DELIMITER //

CREATE PROCEDURE actualizarPersona(
    IN idEntidad VARCHAR(10),
    IN nuevoNombre VARCHAR(255),
    IN nuevoTelefono VARCHAR(15)
)
BEGIN
    IF nuevoNombre IS NOT NULL THEN
        UPDATE Persona
        SET nombre = nuevoNombre
        WHERE idEntidad = idEntidad;
    END IF;

    IF nuevoTelefono IS NOT NULL THEN
        UPDATE Persona
        SET telefono = nuevoTelefono
        WHERE idEntidad = idEntidad;
    END IF;

    -- Puedes agregar más campos según sea necesario
END //


DELIMITER ;
-- empresa --
DELIMITER //

CREATE PROCEDURE actualizarEmpresa(
    IN idEntidad VARCHAR(10),
    IN nuevaDireccion VARCHAR(255),
    IN nuevoTipoEmpresa VARCHAR(50),
    IN nuevoTelefono VARCHAR(15)

)
BEGIN
    -- Actualizar campos específicos de Empresa
    IF nuevaDireccion IS NOT NULL THEN
        UPDATE Empresa
        SET direccion = nuevaDireccion
        WHERE idEntidad = idEntidad;
    END IF;

    IF nuevoTipoEmpresa IS NOT NULL THEN
        UPDATE Empresa
        SET tipoEmpresa = nuevoTipoEmpresa
        WHERE idEntidad = idEntidad;
    END IF;

    IF nuevoTelefono IS NOT NULL THEN
        UPDATE Empresa
        SET telefono = nuevoTelefono
        WHERE idEntidad = idEntidad;
    END IF;
END //

DELIMITER ;
-- Listar todas las personas
DELIMITER //

CREATE PROCEDURE listarPersonas()
BEGIN
    SELECT E.idEntidad, E.documentoIdentidad, E.password, E.email, P.nombre, P.telefono
    FROM Entidad E
    JOIN Persona P ON E.idEntidad = P.idEntidad;
END //

DELIMITER ;

-- Listar todas las empresas
DELIMITER //

CREATE PROCEDURE listarEmpresas()
BEGIN
    SELECT E.idEntidad, E.documentoIdentidad, E.password, E.email, Emp.direccion, Emp.tipoEmpresa, Emp.telefono
    FROM Entidad E
    JOIN Empresa Emp ON E.idEntidad = Emp.idEntidad;
END //

DELIMITER ;


-- Listar todos los administradores
DELIMITER //

CREATE PROCEDURE listarAdministradores()
BEGIN
    SELECT * FROM Administrador;
END //

DELIMITER ;


-- Eliminar persona
DELIMITER //

CREATE PROCEDURE eliminarPersona(IN idEntidad VARCHAR(10))
BEGIN
    DELETE FROM Persona WHERE idEntidad = idEntidad;
    DELETE FROM Entidad WHERE idEntidad = idEntidad;
END //

DELIMITER ;

-- Eliminar empresa
DELIMITER //

CREATE PROCEDURE eliminarEmpresa(IN idEntidad VARCHAR(10))
BEGIN
    DELETE FROM Empresa WHERE idEntidad = idEntidad;
    DELETE FROM Entidad WHERE idEntidad = idEntidad;
END //

DELIMITER ;

-- Eliminar administrador
DELIMITER //

CREATE PROCEDURE eliminarAdministrador(IN idEntidad VARCHAR(10))
BEGIN
    DELETE FROM Administrador WHERE idEntidad = idEntidad;
    DELETE FROM Entidad WHERE idEntidad = idEntidad;
END //

DELIMITER ;



