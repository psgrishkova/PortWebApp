package servlets.route;

import models.Route;
import services.RouteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddRouteServlet", value = "/AddRouteServlet")
public class AddRouteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("pages/AddRoute.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String from = request.getParameter("from");
            String to = request.getParameter("to");

            Route s = new Route(0L, name, from, to);
            RouteService.add(s);

            response.sendRedirect("/PortWebApp/AllRoutesServlet");
        }
        catch (Exception e){
            request.setAttribute("err", e.getMessage());
            doGet(request, response);
        }
    }
}
