/*@author Praveen Kumar Jhanwar
 * roll no - 2014078 
 * @author Siddharth Singh
 * roll no - 2014105*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class yourOrderPage
 */
@WebServlet("/yourOrderPage")
public class yourOrderPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public yourOrderPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void init(ServletConfig config) throws ServletException {  
        super.init(config);
        //Your code  
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String a = "";
		a=request.getParameter("username");
		String b= "";
		b=request.getParameter("address");
		String c="";
		c=request.getParameter("contact");
		
		HttpSession session = request.getSession();
		String d="";
		d=session.getAttribute("orderid").toString();
		session.setAttribute("username", a.toString());
		session.setAttribute("address", b.toString());
		session.setAttribute("contact", c.toString());
		RequestDispatcher rd = request.getRequestDispatcher("yourOrderPage.jsp");
        rd.forward(request, response);
        System.out.println(d+"order is here");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/siddharthsingh/Documents/orders.txt", true)));
		out.println(session.getAttribute("order")+","+a+","+b+","+c+","+d+","+"recieved");
		out.close();		
	}

}
