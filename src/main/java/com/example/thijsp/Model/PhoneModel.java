package com.example.thijsp.Model;

import com.example.thijsp.entity.Phone;
import com.example.thijsp.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhoneModel {
    public static void main(String[] args) {
        PhoneModel phoneModel = new PhoneModel();
        phoneModel.save(new Phone(2,"demo","demo","demo",1));
//        ArrayList<Product> listGame = productModel.findAll();
//        System.out.println(listGame.size());

    }

    public ArrayList<Phone> findAll(){
        ArrayList<Phone> result = new ArrayList<>();
        Connection connection = ConnectionHelper.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from phones");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String brand = resultSet.getString("brand");
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    double price = resultSet.getDouble("price");
                    Phone phone = new Phone(id, name,brand, description, price);
                    result.add(phone);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean save(Phone phone) {
        Connection connection = ConnectionHelper.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement =
                        connection.prepareStatement("insert into phones (name, brand , description, price ) values (?,?,?,?)");
                preparedStatement.setString(1, phone.getName());
                preparedStatement.setString(2, phone.getBrand());
                preparedStatement.setString(3, phone.getDescription());
                preparedStatement.setDouble(4, phone.getPrice());

                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
}
