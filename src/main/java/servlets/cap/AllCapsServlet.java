package servlets.cap;


import services.CapService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AllCapsServlet", value = "/AllCapsServlet")
public class AllCapsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("All", CapService.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("pages/AllCapsManager.jsp");
        rd.forward(request, response);
    }
}
