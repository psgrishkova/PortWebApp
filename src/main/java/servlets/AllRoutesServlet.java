package servlets;

import services.CapService;
import services.RouteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AllRoutesServlet", value = "/AllRoutesServlet")
public class AllRoutesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("All", RouteService.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("jsp/AllRoutesAManager.jsp");
        rd.forward(request, response);
    }
}
