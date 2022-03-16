package servlets;

import services.CapService;
import services.RouteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteRouteServlet", value = "/delete_route")
public class DeleteRouteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idTemp = Long.parseLong(request.getParameter("id"));
        System.out.println(idTemp);
        RouteService.delete(idTemp);
        response.sendRedirect("/PortWebApp/AllRoutesServlet");
    }
}
