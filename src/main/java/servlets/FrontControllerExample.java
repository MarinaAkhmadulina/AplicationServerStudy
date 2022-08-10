package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/main")
public class FrontControllerExample extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (req.getParameter("stage").equals("catalog")) {
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/catalog");
            dispatcher.forward(req, resp);
        }
        if (req.getParameter("stage").equals("cart")) {
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/cart");
            dispatcher.forward(req, resp);
        } else {
            PrintWriter out = resp.getWriter();
            out.println("select fo parameter \"stage\" value \"catalog\" or \"cart\"");
        }
    }
}
