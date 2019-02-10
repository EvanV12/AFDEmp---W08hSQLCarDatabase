package sqlprojectpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * Servlet implementation class FindCar
 */
@WebServlet("/FindCar")
public class FindCar extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCar() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        Statement statement=null;
        String SQLStr;
        
        String registration="";
        String factory="";
        String model="";
        String color="";
        String cc="";
        String regDate="";
        
        request.setCharacterEncoding("UTF-8");
        registration=request.getParameter("LicensePlate");
         factory=request.getParameter("Factory");
         model=request.getParameter("Model");
         color=request.getParameter("Color");
         cc=request.getParameter("cc");
         regDate=request.getParameter("RegDate");
        
        SQLStr = "SELECT car.registration AS 'Registration',car.factory AS 'Factory',car.model AS 'Model',car.colour AS 'Colour',car.cc AS 'CC',car.regdate AS 'Registration Date'"+"\n"+
                "FROM test.car"+"\n"+ 
                "WHERE car.registration LIKE '"+registration+"%' AND car.factory LIKE '"+factory+"%' AND car.model LIKE '"+model+"%' AND car.colour LIKE '"+color+"%' AND car.cc LIKE '"+cc+"%' AND car.regdate LIKE '"+regDate+"%';";
        
        // 
        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + "5.189.135.166:3011/test?useUnicode=yes&characterEncoding=UTF-8&useSSL=false", "java", "java");) {
            
            
            ResultSet rs= conn.createStatement().executeQuery(SQLStr);
            
            System.out.println(rs.next());
            
            if (rs.next() == false) {
 
                System.out.println("There are no such cars in the System!!!");
            } 
            else {
                PrintWriter out =response.getWriter();
 
                // Do...while Loop that shows each user's info
                do {
                    String registrationR=rs.getString("LicensePlate");
                    String factoryR=rs.getString("Factory");
                    String modelR=rs.getString("Model");
                    String colorR=rs.getString("Color");
                    String ccR=rs.getString("cc");
                    String regDateR=rs.getString("RegDate");
                    
                    out.println(registrationR+" "+factoryR+" "+modelR+" "+colorR+" "+ccR+" "+regDateR);
 
                } while (rs.next());
            }
            
           
            //statement = conn.createStatement();
            //statement.executeUpdate(SQLStr);
            response.getWriter().print("");
           
        } 
        
        catch (SQLException e) {
            e.printStackTrace();
        } 
        
        catch (Exception ex) {
            ex.printStackTrace();
        } 
        
        
        finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                
                }
            
            catch (final SQLException sqlEx) {
                    sqlEx.printStackTrace();
            }
            
        }
        
        
        //doGet(request, response);
    }
 
}
 
 