package servlets.ship;

import models.Ship;
import services.ShipService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddShipServlet", value = "/AddShipServlet")
public class AddShipServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("pages/AddShip.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String num = request.getParameter("num");
            int capacity = Integer.parseInt(request.getParameter("capacity"));

            Ship s = new Ship(0L, num, name, capacity);
            ShipService.add(s);

            response.sendRedirect("/PortWebApp/AllShipsServlet");
        }catch (Exception e){
            request.setAttribute("err", e.getMessage());
            doGet(request, response);
        }
    }
}
