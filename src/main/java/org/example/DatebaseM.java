//package org.example;
//
//import java.sql.*;
//import java.util.*;
//
//public class DatebaseM {
//    String driver = "com.mysql.cj.jdbc.Driver";
//    String url = "jdbc:mysql://127.0.0.1:3306/sakila?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
//    String user = "root";
//    String password = "054972";
//
//    Connection con = null;
//    Statement statement = null;
//    ResultSet rs = null;
//
//    Scanner sc = new Scanner(System.in);
//    String userQuery = null;
//
//    public DatebaseM() throws SQLException {
//        try {
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, user, password);
//            statement = con.createStatement();
//            rs = statement.executeQuery(userQuery);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<Map<String, Object>> executeQuery(String query) {
//        List<Map<String, Object>> results = new ArrayList<>();
//
//        try {
//            ResultSetMetaData metaData = rs.getMetaData();
//            int columnCount = metaData.getColumnCount();
//
//            while (rs.next()) {
//                Map<String, Object> row = new HashMap<>();
//                for (int i = 1; i <= columnCount; i++) {
//                    row.put(metaData.getColumnName(i), rs.getObject(i));
//                }
//                results.add(row);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        } finally {
//            if (con != null) con.close();
//            if (statement != null) statement.close();
//            if (rs != null) rs.close();
//        }
//        return results;
//    }
//}