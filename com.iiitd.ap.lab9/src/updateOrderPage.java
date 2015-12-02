/*@author Praveen Kumar Jhanwar
 * roll no - 2014078 
 * @author Siddharth Singh
 * roll no - 2014105*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * Servlet implementation class updateOrderPage
 */
@WebServlet("/updateOrderPage")
public class updateOrderPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateOrderPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append(request.getParameterValues("ubtn")[0]).append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println(request.getParameterValues("ubtn")[0]);
		File log= new File("/Users/siddharthsingh/Documents/orders.txt");
		File log2= new File("/Users/siddharthsingh/Documents/temps.txt");
		ArrayList<String> status= new ArrayList<String>();
		status.add("recieved");
		status.add("preparation");
		status.add("bake");
		status.add("quality check");
		status.add("out for delivery");
		status.add("delivered");
		//file reading
		FileReader fr = new FileReader(log);
		String s=null;
		try {
		    BufferedReader br = new BufferedReader(fr);
		    
		    while ((s = br.readLine()) != null) {
			    String values[]=s.split(","); 
			    String finals=s;
			    if(values[4].equals(request.getParameterValues("ubtn")[0].toString()))
			    	{
			    		int val=status.indexOf(values[5]);
			    		if(val!=5)
			    		{
				    		values[5]=status.get(val+1);
			    			finals="";
				    		for(int i=0;i<values.length;i++)
				    			{
				    			finals+=values[i]+",";
				    			//System.out.println(finals);
				    			}
	//			    		s.replaceAll(final1,finals);
				    		System.out.println("fianlly challa" + s);
				    		}
			    	}
			    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/siddharthsingh/Documents/temps.txt", true)));
				out.println(finals);
				System.out.println(finals);
				out.close();
		    }
		}
		catch(Exception e)
		{
			
		}
		fr.close();
		log.delete();
		File ff=new File("/Users/siddharthsingh/Documents/orders.txt");
		log2.renameTo(ff);
		RequestDispatcher rd = request.getRequestDispatcher("currentOrders.jsp");
		rd.forward(request, response);
		
	}
}
