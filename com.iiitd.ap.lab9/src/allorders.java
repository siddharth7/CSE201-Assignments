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
@WebServlet("/allorders")
public class allorders extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		HttpSession session = req.getSession();
		//System.out.println(req.getParameter("userName"));
		//System.out.println(req.getParameter("password"));
		ArrayList<String> alldata= new ArrayList<String>();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("/Users/siddharthsingh/Documents/orders.txt"));
			String line = null;
			while ((line = br.readLine()) != null) {
			      alldata.add(line);
			      
			}
			br.close();
		}
		catch(Exception e)
		{
			
		}
		session.setAttribute("alldata", alldata);
		if(session.getAttribute("adminActive") == null){
			if(verify_admin(req)){
				RequestDispatcher rd = req.getRequestDispatcher("currentOrders.jsp");
				//resp.sendRedirect("currentOrders.jsp");
				session.setAttribute("adminActive", "true");
				rd.forward(req, resp);
				return;
			}
			
			else{
				RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
				req.setAttribute("wrong", true);
				session.setAttribute("adminActive", "false");
				rd.forward(req, resp);
			}
		}
		else{
			RequestDispatcher rd = req.getRequestDispatcher("currentOrders.jsp");
			session.setAttribute("adminActive", "true");
			rd.forward(req, resp);	
		}
	}
	
	public boolean verify_admin(HttpServletRequest request){
		if(request.getParameter("userName").equals("admin") && request.getParameter("password").equals("pass"))
			return true;
		else 
			return false;
	}
}