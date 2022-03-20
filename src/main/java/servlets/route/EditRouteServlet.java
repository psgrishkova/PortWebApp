package servlets.route;

import models.Route;
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
            request.setAttribute("findRouteById", RouteService.findRouteById(idTemp));
            RequestDispatcher rd = request.getRequestDispatcher("pages/EditRoute.jsp");
            rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        try {

            String name = request.getParameter("name");
            String from = request.getParameter("from");
            String to = request.getParameter("to");

            RouteService.update(new Route(id, name, from, to));

            response.sendRedirect("/PortWebApp/AllRoutesServlet");
        }
        catch (Exception e){
            request.setAttribute("err", e.getMessage());
            doGet(request,response);
        }
    }
}
