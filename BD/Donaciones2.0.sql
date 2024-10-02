CREATE DATABASE IF NOT EXISTS DonacionesDB;
USE DonacionesDB;

-- Tabla para Entidades (Padre para Persona, Empresa y Administrador)
CREATE TABLE Entidad (
    idEntidad INT AUTO_INCREMENT PRIMARY KEY,
    rsoci VARCHAR(255) NOT NULL, -- Razón Social o nombre completo
    documentoIdentidad VARCHAR(20) NOT NULL UNIQUE, -- Documento de identidad (para login)
    password VARCHAR(255) NOT NULL, -- Contraseña en formato hash
    tipoEntidad ENUM('Persona', 'Empresa', 'Administrador') NOT NULL, -- Tipo de Entidad
    contacto VARCHAR(50), -- Información de contacto
    email VARCHAR(255) -- Correo electrónico
);

-- Tabla para Cuentas Bancarias, relacionadas con Entidad
CREATE TABLE Cuenta (
    numC INT NOT NULL, -- Número de Cuenta
    cvc INT NOT NULL, -- Código de seguridad
    fV INT NOT NULL, -- Fecha de Vencimiento (en formato MMYY por ejemplo)
    cCuenta INT NOT NULL, -- Código de la cuenta
    idEntidad INT NOT NULL, -- Relación con la entidad
    FOREIGN KEY (idEntidad) REFERENCES Entidad(idEntidad) ON DELETE CASCADE -- Clave foránea hacia Entidad
);

-- Tabla para Empresas, relacionadas con Entidad
CREATE TABLE Empresa (
    direccion VARCHAR(255) NOT NULL, -- Dirección de la empresa
    tipoEmpresa VARCHAR(50), -- Tipo de empresa
    idEntidad INT NOT NULL, -- Relación con la tabla Entidad
    FOREIGN KEY (idEntidad) REFERENCES Entidad(idEntidad) ON DELETE CASCADE -- Clave foránea hacia Entidad
);

-- Tabla para Personas, relacionadas con Entidad
CREATE TABLE Persona (
    tipoPersona VARCHAR(50), -- Tipo de persona
    idEntidad INT NOT NULL, -- Relación con la tabla Entidad
    FOREIGN KEY (idEntidad) REFERENCES Entidad(idEntidad) ON DELETE CASCADE -- Clave foránea hacia Entidad
);

-- Tabla para Campañas, relacionadas con Empresas
CREATE TABLE Campania (
    idCampania INT AUTO_INCREMENT PRIMARY KEY,
    nombreCampania VARCHAR(255) NOT NULL, -- Nombre de la campaña
    descripcion TEXT, -- Descripción de la campaña
    metaDonaciones DECIMAL(10, 2) NOT NULL, -- Monto meta de la campaña
    donacionesRecibidas DECIMAL(10, 2) DEFAULT 0, -- Donaciones acumuladas
    idEntidad INT NOT NULL, -- Relación con la entidad de la empresa que crea la campaña
    FOREIGN KEY (idEntidad) REFERENCES Entidad(idEntidad) ON DELETE CASCADE -- Clave foránea hacia Empresa (Entidad)
);

-- Tabla para Donativos, relacionados con campañas, personas y empresas
CREATE TABLE Donativo (
    idDonativo INT AUTO_INCREMENT PRIMARY KEY,
    tipoDonativo ENUM('Dinero', 'Ropa', 'Alimentos') NOT NULL, -- Tipo de donación
    idEmisor INT NOT NULL, -- Código de la entidad que dona (Persona o Empresa)
    idReceptor INT NOT NULL, -- Código de la entidad que recibe
    montoDonacion DECIMAL(10, 2), -- Monto si es una donación de dinero
    idCampania INT, -- Relación con la campaña (si aplica)
    FOREIGN KEY (idEmisor) REFERENCES Entidad(idEntidad) ON DELETE CASCADE, -- Clave foránea hacia Entidad
    FOREIGN KEY (idReceptor) REFERENCES Entidad(idEntidad) ON DELETE CASCADE, -- Clave foránea hacia Entidad
    FOREIGN KEY (idCampania) REFERENCES Campania(idCampania) ON DELETE SET NULL -- Clave foránea opcional hacia Campania
);
-- entidad--
DELIMITER //

CREATE PROCEDURE insertarEntidad(
    IN rsoci VARCHAR(255),
    IN documentoIdentidad VARCHAR(50),
    IN password VARCHAR(50),
    IN tipoEntidad VARCHAR(50),
    IN contacto VARCHAR(50),
    IN email VARCHAR(255)
)
BEGIN
    DECLARE entidadId INT;

    -- Insertar en la tabla Entidad
    INSERT INTO Entidad (rsoci, documentoIdentidad, password, tipoEntidad, contacto, email)
    VALUES (rsoci, documentoIdentidad, password, tipoEntidad, contacto, email);
    
    -- Obtener el ID de la entidad insertada
    SET entidadId = LAST_INSERT_ID();

    -- Insertar en la tabla específica según el tipo de entidad
    IF tipoEntidad = 'Empresa' THEN
        INSERT INTO Empresa (idEntidad, contacto) VALUES (entidadId, contacto);
    ELSEIF tipoEntidad = 'Persona' THEN
        INSERT INTO Persona (idEntidad, email) VALUES (entidadId, email);
    END IF;
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE actualizarEntidad(
    IN idEntidad INT,
    IN rsoci VARCHAR(255),
    IN documentoIdentidad VARCHAR(50),
    IN password VARCHAR(50),
    IN contacto VARCHAR(50),
    IN email VARCHAR(255)
)
BEGIN
    -- Actualizar en la tabla Entidad
    UPDATE Entidad
    SET rsoci = rsoci, documentoIdentidad = documentoIdentidad, password = password,
        contacto = contacto, email = email
    WHERE idEntidad = idEntidad;
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE listarEntidades()
BEGIN
    -- Seleccionar todas las entidades
    SELECT * FROM Entidad;
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE buscarEntidadPorId(
    IN idEntidad INT
)
BEGIN
    -- Buscar entidad por ID
    SELECT * FROM Entidad
    WHERE idEntidad = idEntidad;
END //

DELIMITER ;
-- empresa --
DELIMITER //

CREATE PROCEDURE insertarEmpresa(
    IN rsoci VARCHAR(255),
    IN documentoIdentidad VARCHAR(50),
    IN password VARCHAR(50),
    IN contacto VARCHAR(50)
)
BEGIN
    -- Llamar al procedimiento para insertar entidad
    CALL insertarEntidad(rsoci, documentoIdentidad, password, 'Empresa', contacto, NULL);
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE actualizarEmpresa(
    IN idEmpresa INT,
    IN contacto VARCHAR(50)
)
BEGIN
    -- Actualizar información específica de la empresa
    UPDATE Empresa
    SET contacto = contacto
    WHERE idEmpresa = idEmpresa;
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE listarEmpresas()
BEGIN
    -- Seleccionar todas las empresas
    SELECT * FROM Empresa;
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE buscarEmpresaPorId(
    IN idEmpresa INT
)
BEGIN
    -- Buscar empresa por ID
    SELECT * FROM Empresa
    WHERE idEmpresa = idEmpresa;
END //

DELIMITER ;
-- persona-- 
DELIMITER //

CREATE PROCEDURE insertarPersona(
    IN rsoci VARCHAR(255),
    IN documentoIdentidad VARCHAR(50),
    IN password VARCHAR(50),
    IN contacto VARCHAR(50),
    IN email VARCHAR(255)
)
BEGIN
    -- Llamar al procedimiento para insertar entidad
    CALL insertarEntidad(rsoci, documentoIdentidad, password, 'Persona', contacto, email);
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE actualizarPersona(
    IN idPersona INT,
    IN contacto VARCHAR(50),
    IN email VARCHAR(255)
)
BEGIN
    -- Actualizar información específica de la persona
    UPDATE Persona
    SET contacto = contacto, email = email
    WHERE idPersona = idPersona;
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE listarPersonas()
BEGIN
    -- Seleccionar todas las personas
    SELECT * FROM Persona;
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE buscarPersonaPorId(
    IN idPersona INT
)
BEGIN
    -- Buscar persona por ID
    SELECT * FROM Persona
    WHERE idPersona = idPersona;
END //

DELIMITER ;
-- campania --

DELIMITER //

CREATE PROCEDURE insertarCampania(
    IN idEmpresa INT,
    IN nombreCampania VARCHAR(255),
    IN metaDonaciones DECIMAL(10,2)
)
BEGIN
    -- Insertar en la tabla Campania
    INSERT INTO Campania (idEmpresa, nombreCampania, metaDonaciones)
    VALUES (idEmpresa, nombreCampania, metaDonaciones);
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE listarCampanias()
BEGIN
    -- Seleccionar todas las campañas
    SELECT * FROM Campania;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE buscarCampaniaPorId(
    IN idCampania INT
)
BEGIN
    -- Buscar campaña por ID
    SELECT * FROM Campania
    WHERE idCampania = idCampania;
END //

DELIMITER ;
