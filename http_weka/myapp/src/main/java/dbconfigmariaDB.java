import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

// In this file I've simulated jhipster connection in order to make necessary querys
// Tomcat was used as local server
// Maven was also used like jhipster
public class dbconfigmariaDB {

    // DATA BASE CONNECTION 
    String userName,password,url,driver;
    Connection con;
    Statement st;

    public dbconfigmariaDB() {
        userName="root";
        password="Picholudo2202";
        url="jdbc:mariadb://localhost:3307/jhipster";
        driver="org.mariadb.jdbc.Driver";
        String consulta="SELECT  * FROM resultado_prueba";
        //String consulta="SELECT pd, prueba_id, sum (informe_id) FROM resultado_prueba GROUP BY pd, prueba_id;"; <- one of the many attempts (failed)
        try {
            Class.forName(driver);
        con= DriverManager.getConnection(url, userName, password);
        st=con.createStatement();
        System.out.println("Connection is successful");
        PreparedStatement ps = con.prepareStatement(consulta); 
        ResultSet rs = ps.executeQuery(consulta); {

        while (rs.next()) {
            System.out.println(rs.getInt("id")+ " "+ rs.getInt("pd")+ " " + rs.getInt("pz")+" "+ rs.getInt("prueba_id")+" "+ rs.getInt("informe_id"));

        }
    } con.close();
} catch (Exception e) {
          e.printStackTrace();
        }

    }

    public static void main(String[] args) 
    {
        new dbconfigmariaDB();
    }

    }

    




