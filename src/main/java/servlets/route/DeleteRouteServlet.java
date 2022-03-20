package servlets.route;

import repositories.RouteRepository;
import services.RouteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteRouteServlet", value = "/delete_route")
public class DeleteRouteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long idTemp = Long.parseLong(request.getParameter("id"));
            RouteService.delete(idTemp);
            response.sendRedirect("/PortWebApp/AllRoutesServlet");
        }
        catch (Exception e){
            //logger
        }
    }
}
