--Crear Persona
create procedure sp_CrearPersona @Dcentidad NVARCHAR(100), 
@Rsoci NVARCHAR(100), @Email NVARCHAR(100), @Contacto NVARCHAR(50), @Pw NVARCHAR(255),
@Tipo NVARCHAR(50)
as begin
insert into Usuarios(Dcentidad , Rsoci , Email , Contacto , Pw ,Tipo )
values(@Dcentidad , @Rsoci, @Email , @Contacto , @Pw ,@Tipo );
end;
--exec sp_CrearPersona  'c','b','2','4','5','6'
--select * from Usuarios
--Crear Empresa
create procedure sp_CrearEmpresa @Dcentidad NVARCHAR(100),
@Rsoci NVARCHAR(100), @Direccion NVARCHAR(100), @Contacto NVARCHAR(50), @Pw NVARCHAR(255),
@Tipo NVARCHAR(50)
as begin
insert into Usuarios(Dcentidad , Rsoci , Direccion , Contacto , Pw ,Tipo )
values(@Dcentidad , @Rsoci, @Direccion , @Contacto , @Pw ,@Tipo );
end;
--exec sp_CrearEmpresa 'd','b','2','4','5','6'
--select * from Usuarios
--Leer Persona
create procedure sp_BusquedaPorDoc 
@Dentidad NVARCHAR(100)
as begin 
select * from Usuarios where Dcentidad=@Dentidad;
end;
exec sp_BusquedaPorDoc @Dentidad='b';
--Actualizar Persona
create procedure sp_ActualizarInfoPersona
@Dcentidad NVARCHAR(100),@Rsoci NVARCHAR(100), @Email NVARCHAR(100), @Contacto NVARCHAR(50), @Pw NVARCHAR(255)
as begin 
update Usuarios
set 
 Rsoci=@Rsoci , Email=@Email , Contacto=@Contacto , Pw = @Pw
where Dcentidad=@Dcentidad;
end;
exec sp_ActualizarInfoPersona 'c','a','5','4','5'
select * from Usuarios
--Actualizar Empresa 
create procedure sp_ActualizarInfoEmpresa
@Dcentidad NVARCHAR(100),@Rsoci NVARCHAR(100), @Direccion NVARCHAR(100), @Contacto NVARCHAR(50), @Pw NVARCHAR(255)
as begin 
update Usuarios
set 
 Rsoci=@Rsoci , Direccion=@Direccion , Contacto=@Contacto , Pw = @Pw
where Dcentidad=@Dcentidad;
end;
exec sp_ActualizarInfoEmpresa 'd','a','5','4','5'
select * from Usuarios
--Eliminar Persona
create procedure sp_EliminarPersona
@Dentidad NVARCHAR(100)
as begin
delete from Usuarios where Dcentidad=@Dentidad;
end;
exec sp_EliminarPersona @Dentidad=10;
select * from Usuarios
--Eliminar Empresa
create procedure sp_EliminarEmpresa
@Dentidad NVARCHAR(100)
as begin
delete from Usuarios where Dcentidad=@Dentidad;
end;
exec sp_EliminarEmpresa @Dentidad=9;
select * from Usuarios












