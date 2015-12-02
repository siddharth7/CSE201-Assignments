/*@author Praveen Kumar Jhanwar
 * roll no - 2014078 
 * @author Siddharth Singh
 * roll no - 2014105*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PendingOrders
 */
@WebServlet("/PendingOrders")
public class pendingOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pendingOrders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		ArrayList<String> alldata2= new ArrayList<String>();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("/Users/siddharthsingh/Documents/orders.txt"));
			String line = null;
			while ((line = br.readLine()) != null) {
			      alldata2.add(line);
			      
			}
			br.close();
		}
		catch(Exception e)
		{
			
		}
		session.setAttribute("alldata2", alldata2);
		if(session.getAttribute("managerActive") == null)
		{
			if(verifyManager(request))
			{
				RequestDispatcher rd = request.getRequestDispatcher("pendingOrders.jsp");
				session.setAttribute("managerActive", true);
				rd.forward(request, response);
				return;
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("manager.jsp");
				session.setAttribute("managerActive", null);
				rd.forward(request, response);
			}
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("pendingOrders.jsp");
			session.setAttribute("managerActive", true);
			rd.forward(request, response);
		}
	}
	
	public boolean verifyManager(HttpServletRequest request)
	{
		if(request.getParameter("username").equals("manager") && request.getParameter("password").equals("aja"))
		{
			return true;
		}
		return false;
	}

}
