package servlets;

import services.ShipService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteShipServlet", urlPatterns = "/delete")
public class DeleteShipServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idTemp = Long.parseLong(request.getParameter("id"));
        System.out.println(idTemp);
        ShipService.delete(idTemp);
        response.sendRedirect("/PortWebApp/AllShipsServlet");
    }
}
