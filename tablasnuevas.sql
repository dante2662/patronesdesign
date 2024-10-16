USE DONATIVOSPRUEBA;

--Tabla Campania
CREATE TABLE Campania (
    idCampania VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,         -- Nombre de la campa�a
    descripcion TEXT,                     -- Descripci�n de la campa�a
    fechaInicio DATE NOT NULL,            -- Fecha de inicio
    fechaFin DATE NOT NULL,               -- Fecha de fin
    estado VARCHAR(50) NOT NULL,          -- Estado de la campa�a (Activa, Inactiva)
    tipo VARCHAR(50) NOT NULL,            -- Tipo de campa�a
    cantidad INT NOT NULL                 -- Cantidad relacionada con la campa�a 
);
--Tabla Donacion
CREATE TABLE Donacion (
    idDonacion VARCHAR(50) PRIMARY KEY,     -- 
    idCampania VARCHAR(50) NOT NULL,        -- ID de la campa�a 
    monto DECIMAL(10, 2) NOT NULL,          -- Monto de la donaci�n 
    fecha DATE NOT NULL,                    -- Fecha de la donaci�n
    estado VARCHAR(50) NOT NULL,            -- Estado de la donaci�n (Completada, Pendiente)
    tipo VARCHAR(50) NOT NULL,              -- Tipo de donaci�n (Monetaria, Alimentos)
    CONSTRAINT FK_Campania FOREIGN KEY (idCampania) REFERENCES Campania(idCampania)
);

CREATE PROCEDURE registerDonacion
    @idDonacion VARCHAR(50),
    @monto DECIMAL(10, 2),
    @tipo VARCHAR(50),
    @fecha DATE
AS
BEGIN
    INSERT INTO Donacion (idDonacion, idCampania, monto, tipo, fecha, estado)
    VALUES (@idDonacion, NULL, @monto, @tipo, @fecha, 'Pendiente'); -- Ajusta `idCampania` si es necesario
END;

CREATE PROCEDURE obtenerDonaciones
AS
BEGIN
    SELECT idDonacion, monto, tipo AS tipoDonativo, fecha
    FROM Donacion;
END;

CREATE PROCEDURE eliminarDonacion
    @idDonacion VARCHAR(50)
AS
BEGIN
    DELETE FROM Donacion
    WHERE idDonacion = @idDonacion;
END;

CREATE PROCEDURE actualizarDonacion
    @idDonacion VARCHAR(50),
    @monto DECIMAL(10, 2),
    @tipo VARCHAR(50),
    @fecha DATE,
    @estado VARCHAR(50)
AS
BEGIN
    UPDATE Donacion
    SET monto = @monto, tipo = @tipo, fecha = @fecha, estado = @estado
    WHERE idDonacion = @idDonacion;
END;

