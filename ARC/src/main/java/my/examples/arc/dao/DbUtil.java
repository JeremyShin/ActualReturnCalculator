package my.examples.arc.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class DbUtil {
    private String host;
    private String database;
    private String user;
    private String password;
    File file = new File("ARC/out/MysqlInfo.secure");

    public void DbUtil() {
    }

    public String getHost() {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            host = bufferedReader.readLine();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return host;
    }

    public void setHost(String host) {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            host = bufferedReader.readLine();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        this.host = host;
    }

    public String getDatabase() {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            database = bufferedReader.readLine();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return database;
    }

    public void setDatabase(String database) {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            database = bufferedReader.readLine();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        this.database = database;
    }

    public String getUser() {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            user = bufferedReader.readLine();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return user;
    }

    public void setUser(String user) {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            user = bufferedReader.readLine();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        this.user = user;
    }

    public String getPassword() {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            password = bufferedReader.readLine();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return password;
    }

    public void setPassword(String password) {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            password = bufferedReader.readLine();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        this.password = password;
    }

    public static Connection connect(String dbUrl, Properties properties)
        throws RuntimeException {
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, properties);
        }catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return conn;
    }

    //insert, update, delete
    public static void close(Connection conn, PreparedStatement ps) {
        if(ps != null) {
            try{
                ps.close();
            }catch (SQLException ex) {}
        }
        if(conn != null) {
            try{
               conn.close();
            }catch (SQLException ex) {}
        }
    } //close

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if(rs != null) {
            try{
                rs.close();
            }catch (SQLException ex) {}
        }
        close(conn, ps);
    } //close
}
