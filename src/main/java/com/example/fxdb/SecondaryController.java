package com.example.fxdb;

import java.math.BigDecimal;
import java.sql.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class SecondaryController {

    @FXML
    public TableView<Entity> myDBTable;

    @FXML
    public Button secondaryButton;

    @FXML
    private void switchToPrimary() throws IOException
    {
        App.setRoot("primary");
    }

    public void initialize() throws SQLException {

        TableColumn<Entity, Integer> col1 = new TableColumn<>("ID");
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Entity, String> col2 = new TableColumn<>("Name");
        col2.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Entity, BigDecimal> col3 = new TableColumn<>("Price");
        col3.setCellValueFactory(new PropertyValueFactory<>("price"));

        myDBTable.getColumns().add(col1);
        myDBTable.getColumns().add(col2);
        myDBTable.getColumns().add(col3);

        Connection c
                = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales", "root", "p4ssword");
        String sql = "select id, name, price from item;";
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next())
        {
            Entity e = new Entity();
            e.id = rs.getInt(1);
            e.name = rs.getString(2);
            e.price = rs.getBigDecimal(3);
            myDBTable.getItems().add(e);
        }


    }


}
