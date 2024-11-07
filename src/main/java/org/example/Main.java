package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/sakila?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
        String user = "root";
        String password = "054972";

        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;

        Scanner sc = new Scanner(System.in);
        String userQuery = null;
        System.out.print("쿼리를 입력하세요 > ");
        userQuery = sc.nextLine();

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            statement = con.createStatement();
            rs = statement.executeQuery(userQuery);

            while(rs.next()) {

                String language_id = rs.getString("name");
                System.out.println(language_id);

            }

        } catch (Exception e) {

        } finally {
            if (con != null) con.close();
            if (statement != null) statement.close();
            if (rs != null) rs.close();
        }
    }
}