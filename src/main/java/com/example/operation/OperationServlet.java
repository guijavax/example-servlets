package com.example.operation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.example.entitie.OperationEntitie;


/**
 * 
 * @author gcarneib <br>
 * Classe que realiza as operacoes, no servlet 2
 */
public class OperationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 46907109138170168L;
	
	private static final Logger LOGGER = Logger.getLogger(HttpServlet.class);

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double v1 = parseDouble(req.getParameter("v1"));
		double v2 = parseDouble(req.getParameter("v2"));
		OperationEntitie entitie = new OperationEntitie(v1, v2);
		
		
		char operationType = req.getParameter("operation").toCharArray()[0];
		
		double result = result(entitie, operationType);
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Operation</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3> O resultado de " + entitie.getValue1() + operationType + entitie.getValue2() + " é: " + result + "</h3>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	private double parseDouble (String num) {
		try {
			return (num != null && !"".equals(num)) ? Double.parseDouble(num) : 0.0;			
		} catch(NumberFormatException e) {
			LOGGER.error(e.getMessage());
			return 0.0;
		}
	}
	
	private double result(OperationEntitie entitie, char operationType) {
		double v1 = entitie.getValue1();
		double v2 = entitie.getValue2();
		switch(operationType) {
			case '+':
				return v1 + v2;
			case '-':
				return v1 - v2;
			case '*':
				return v1 * v2;
			case '/':
				return v1 / v2;
			default:
				return 0.0;
		}
	}
}
