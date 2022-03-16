package servlets;

import services.CapService;
import services.ShipService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AllCapsServlet", value = "/AllCapsServlet")
public class AllCapsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("All", CapService.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("jsp/AllCapsManager.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
