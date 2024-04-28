package com.rionggo.inventorytracker.Repositories;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.rionggo.inventorytracker.Entities.SupplierEntity;
import com.rionggo.inventorytracker.Configurations.DatabaseConfiguration;

/**
 *  SupplierRepositories
 */
public class SupplierRepositories extends DatabaseConfiguration {

  /**
   * Get Suppliers
   * 
   * @return List<Object[]>
   */
  protected List<Object[]> getSuppliersRepo () {
    List<Object[]> SuppliersDataList = new ArrayList<>();
    Connection connection = getConnection();
    String queryString = "SELECT * FROM suppliers";

    try {
      PreparedStatement statement = connection
        .prepareStatement(queryString);

      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        String supplierId = resultSet
          .getString("supplier_id");
        String supplierName = resultSet
          .getString("supplier_name");
        String supplierContact = resultSet
          .getString("supplier_contact");
        String supplierAddress = resultSet
          .getString("supplier_address");
        String supplierEmail = resultSet
          .getString("supplier_email");

        Object[] rowData = {
          supplierId, supplierName,
          supplierContact, supplierAddress,
          supplierEmail
        };

        SuppliersDataList.add(rowData);
      }

      return (List<Object[]>) SuppliersDataList;

    } catch (SQLException exception) {
      exception.printStackTrace();
      return SuppliersDataList;

    } finally {
      try { if (connection != null) connection.close(); }
      catch (SQLException exception) { exception.printStackTrace(); }
    }
  }



  /**
   * Create Supplier
   * 
   * @param entity
   * @return boolean
   */
  protected boolean createSupplierRepo (SupplierEntity entity) {
    Connection connection = getConnection();
    String queryString = (
      "INSERT INTO suppliers ( " +
        "supplier_id,      "     +
        "supplier_name,    "     +
        "supplier_contact, "     +
        "supplier_address, "     +
        "supplier_email    "     +
      ")"                        +
      "VALUES (?, ?, ?, ?, ?)"
    );
        
    try {
      // Transaction Mode (ACID Principles)
      connection.setAutoCommit(false);

      PreparedStatement statement = connection
        .prepareStatement(queryString);

      Object[] entities = {
        entity.getSupplierId(),
        entity.getSupplierName(),
        entity.getSupplierContact(),
        entity.getSupplierAddress(),
        entity.getSupplierEmail(),
      };
      
      for (int index = 1; index < (entities.length + 1); index ++) 
        statement.setString(index, (String) entities[index]);

      if (statement.executeUpdate() > 0) {
        connection.commit();
        return true;
          
      } else {
        connection.rollback();
        return false;
      }

    } catch (SQLException exception) {
      exception.printStackTrace();

      try { connection.rollback(); }
      catch (SQLException rollbackException) {
        rollbackException.printStackTrace();
      }
      
      return false;

    } finally {
      try { 
        connection.setAutoCommit(true);
        if (connection != null) connection.close();
      }
      catch (SQLException exception) { exception.printStackTrace(); }
    }
  }


  
  /**
   * Update Supplier
   * 
   * @param entity
   * @return
   */
  protected boolean updateSupplierRepo (SupplierEntity entity) {
    Connection connection = getConnection();
    String queryString = (
      "UPDATE suppliers SET "       +
        "supplier_name      = ?, "  +
        "supplier_contact   = ?, "  +
        "supplier_address   = ?, "  +
        "supplier_email     = ?  "  +
      "WHERE supplier_id    = ?  "
    );
        
    try {
      // Transaction Mode (ACID Principles)
      connection.setAutoCommit(false);

      PreparedStatement statement = connection
        .prepareStatement(queryString);

      Object[] entities = {
        entity.getSupplierId(),
        entity.getSupplierName(),
        entity.getSupplierContact(),
        entity.getSupplierAddress(),
        entity.getSupplierEmail(),
      };
      
      for (int index = 1; index < (entities.length + 1); index ++) 
        statement.setString(index, (String) entities[index]);

      if (statement.executeUpdate() > 0) {
        connection.commit();
        return true;

      } else {
        connection.rollback();
        return false;
      }

    } catch (SQLException exception) {
      exception.printStackTrace();

      try { connection.rollback(); }
      catch (SQLException rollbackException) {
        rollbackException.printStackTrace();
      }
      
      return false;

    } finally {
      try { 
        connection.setAutoCommit(true);
        if (connection != null) connection.close();
      }
      catch (SQLException exception) { exception.printStackTrace(); }
    }
  }



  /**
   * Delete Supplier
   * 
   * @param supplierId
   * @return
   */
  protected boolean deleteSupplierRepo (String supplierId) {
    Connection connection = getConnection();
    String queryString = (
      "DELETE FROM suppliers WHERE supplier_id = ?"
    );
        
    try {
      // Transaction Mode (ACID Principles)
      connection.setAutoCommit(false);

      PreparedStatement statement = connection
        .prepareStatement(queryString);

      statement.setString(1, supplierId);

      if (statement.executeUpdate() > 0) {
        connection.commit();
        return true;
        
      } else {
        connection.rollback();
        return false;
      }

    } catch (SQLException exception) {
      exception.printStackTrace();

      try { connection.rollback(); }
      catch (SQLException rollbackException) {
        rollbackException.printStackTrace();
      }
      
      return false;

    } finally {
      try { 
        connection.setAutoCommit(true);
        if (connection != null) connection.close();
      }
      catch (SQLException exception) { exception.printStackTrace(); }
    }
  }



  /**
   * Search Suppliers
   * 
   * @return
   */
  protected List<Object[]> searchSuppliersRepo () {
    List<Object[]> SuppliersDataList = new ArrayList<>();
    Connection connection = getConnection();
    String queryString = (
      "SELECT * FROM employees WHERE (  " + 
        "supplier_id      LIKE '%?%' OR " +
        "supplier_name    LIKE '%?%' OR " +
        "supplier_contact LIKE '%?%' OR " +
        "supplier_address LIKE '%?%' OR " +
        "supplier_email   LIKE '%?%'    " +
      ")"
    );

    try {
      PreparedStatement statement = connection
        .prepareStatement(queryString);

      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        String supplierId = resultSet
          .getString("supplier_id");
        String supplierName = resultSet
          .getString("supplier_name");
        String supplierContact = resultSet
          .getString("supplier_contact");
        String supplierAddress = resultSet
          .getString("supplier_address");
        String supplierEmail = resultSet
          .getString("supplier_email");

        Object[] rowData = {
          supplierId, supplierName,
          supplierContact, supplierAddress,
          supplierEmail
        };

        SuppliersDataList.add(rowData);
      }

      return (List<Object[]>) SuppliersDataList;

    } catch (SQLException exception) {
      exception.printStackTrace();
      return SuppliersDataList;

    } finally {
      try { if (connection != null) connection.close(); }
      catch (SQLException exception) { exception.printStackTrace(); }
    }
  }

}
