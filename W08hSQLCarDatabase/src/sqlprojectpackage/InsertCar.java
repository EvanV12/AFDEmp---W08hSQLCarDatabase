package sqlprojectpackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertCar
 */
@WebServlet("/InsertCar")
public class InsertCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
		
		request.setCharacterEncoding("UTF-8");
		String registration=request.getParameter("LicensePlate");
		String factory=request.getParameter("Factory");
		String model=request.getParameter("Model");
		String color=request.getParameter("Color");
		String cc=request.getParameter("cc");
		String regDate=request.getParameter("RegDate");
		
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://" + "5.189.135.166:3011/test?useUnicode=yes&characterEncoding=UTF-8&useSSL=false", "java", "java");) {
			SQLStr = "INSERT INTO car " + "VALUES ('" + registration + "', '" + factory + "', '" + model + "', '" + color + "', '" + cc + "', '" + regDate + "');";
			
			statement = conn.createStatement();
			statement.executeUpdate(SQLStr);
			response.getWriter().print("<div style=\"width: 400px;" + "margin: auto;\">The car has been successfully inserted" + "<br><a href=\"index.htm\">home</a></div>");
			
		} catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } catch (Exception ex) {
        	ex.printStackTrace();
        } finally {
        	try {
        		if (statement != null) {
        			statement.close();
        		}
        		
        		}catch (final SQLException sqlEx) {
        			sqlEx.printStackTrace();
        	}
        }
        
	}


}

