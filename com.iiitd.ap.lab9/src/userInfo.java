/*@author Praveen Kumar Jhanwar
 * roll no - 2014078 
 * @author Siddharth Singh
 * roll no - 2014105*/

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class userInfo
 */
@WebServlet("/userInfo")
public class userInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		RequestDispatcher rd = request.getRequestDispatcher("userInfo.jsp");
//        rd.forward(request, response);
		//doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println(request.getParameterValues("pizza1_size")[0]);
		//System.out.println(request.getParameterValues("pizza2_size")[0]);
		//System.out.println(request.getParameterValues("pizza").length);
		String order="";
		String a="";
		String b="";
		String c="";
		for(int i=0;i<request.getParameterValues("pizza").length;i++)
			{
				//System.out.println(request.getParameterValues("pizza")[i]);
				a=request.getParameterValues("pizza")[i];
				for(int j=0;j<request.getParameterValues(a+"_size").length;j++)
				{
					//System.out.println(request.getParameterValues(a+"_size")[j]);
					b=request.getParameterValues(a+"_size")[j];
					//System.out.println(request.getParameter(a+"_"+b));
					c=request.getParameter(a+"_"+b);
					order=order+a+" "+b+" "+c+" ";
				}
			}
		for(int i=0;i<request.getParameterValues("side").length;i++)
		{
			//System.out.println(request.getParameterValues("pizza")[i]);
			a=request.getParameterValues("side")[i];
				c=request.getParameter(a+"_quantity");
				order=order+a+" "+c+" ";
			}
		System.out.println(order);
		HttpSession session = request.getSession();
		session.setAttribute("order", order);
		RequestDispatcher rd = request.getRequestDispatcher("userInfo.jsp");
        rd.forward(request, response);
	}

}
