package servlets;

import services.CapService;
import services.RouteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditRouteServlet", urlPatterns = "/edit_route")
public class EditRouteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idTemp = Long.parseLong(request.getParameter("id"));
        System.out.println(idTemp);
        request.setAttribute("findRouteById", RouteService.findRouteById(idTemp));
        RequestDispatcher rd = request.getRequestDispatcher("pages/EditRoute.jsp");
        rd.forward(request, response);
    }
}
