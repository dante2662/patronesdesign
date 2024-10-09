/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.*;

/**
 *
 * @author Dan
 */
public class FactoryImpleDAO implements FactoryDAO{
    private Connection connection;

    public FactoryImpleDAO(Connection connection) {
        this.connection = connection;
    }
     
    @Override
    public PersonaImpleDAO llamadaImplePerson() {
        return new PersonaImpleDAO(connection);
    }

    @Override
    public EmpresaImpleDAO llamadaImpleEmpres() {
       return new EmpresaImpleDAO(connection);
    }

    @Override
    public AdminImpleDAO llamadaImpleAdmin() {
        return new AdminImpleDAO(connection);
    }
    
}
