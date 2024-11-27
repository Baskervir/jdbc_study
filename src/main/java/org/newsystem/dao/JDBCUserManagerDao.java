package org.newsystem.dao;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JDBCUserManagerDao implements UserManageDao {

    static private String driver = "com.mysql.cj.jdbc.Driver";
    static private String url = "jdbc:mysql://127.0.0.1:3306/sakila?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
    static private String user = "root";
    static private String password = "054972";

    @Override
    public List<UserDTO> findAll(int pageNum, int pageSize) {

        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            Class.forName(driver);
            conn  = DriverManager.getConnection(url, user, password);
            stat = conn.createStatement();
            rs = stat.executeQuery(String.format("select actor_id, first_name, last_name from actor limit %d, %d", (pageNum-1) * pageSize, pageSize));

            List<UserDTO> dtos = new ArrayList<>();

            while (rs.next()){

                int actorId = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                //long timestamp = rs.getLong(4);

                UserDTO newUserDTO = new UserDTO(actorId, firstName, lastName, System.currentTimeMillis());
                dtos.add(newUserDTO);

            }

            return dtos;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            closeSafe(conn);
            closeSafe(stat);
            closeSafe(rs);
        }
    }

    @Override
    public List<OneUserDTO> findOne(String firstName, String lastName) {

        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            Class.forName(driver);
            conn  = DriverManager.getConnection(url, user, password);
            stat = conn.createStatement();
            rs = stat.executeQuery(String.format("select actor_id, first_name, last_name from actor where first_name = \"%s\" and last_name = \"%s\"", firstName, lastName));

            List<OneUserDTO> dtos = new ArrayList<>();

            while (rs.next()){

                String first_name = rs.getString(1);
                String last_name = rs.getString(2);
                //actorId = rs.getInt(3);

                OneUserDTO newUserDTO = new OneUserDTO(first_name, last_name);
                dtos.add(newUserDTO);

            }

            return dtos;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            closeSafe(conn);
            closeSafe(stat);
            closeSafe(rs);
        }
    }

    @Override
    public List<OneUserDTO> addOne(String firstName, String lastName) {

        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            Class.forName(driver);
            conn  = DriverManager.getConnection(url, user, password);
            stat = conn.createStatement();
            rs = stat.executeQuery(String.format("INSERT INTO actor(first_name, last_name) VALUES (\"%s\", \"%s\")", firstName, lastName));

            List<OneUserDTO> dtos = new ArrayList<>();

            while (rs.next()){

                String first_name = rs.getString(1);
                String last_name = rs.getString(2);

                OneUserDTO newUserDTO = new OneUserDTO(first_name, last_name);
                dtos.add(newUserDTO);

            }

            return dtos;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            closeSafe(conn);
            closeSafe(stat);
            closeSafe(rs);
        }
    }





    private static void closeSafe(AutoCloseable conn) {
        if(conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
