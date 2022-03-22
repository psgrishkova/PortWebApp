package servlets.route;

import services.RouteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteRouteServlet", value = "/delete_route")
public class DeleteRouteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long idTemp = Long.parseLong(request.getParameter("id"));
            RouteService.delete(idTemp);
            response.sendRedirect("/PortWebApp/AllRoutesServlet");
        } catch (Exception e) {
            //logger
        }
    }
}
