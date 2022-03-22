package servlets.ship;

import models.Ship;
import services.ShipService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditShipServlet", urlPatterns = "/edit_ship")
public class EditShipServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idTemp = Long.parseLong(request.getParameter("id"));
        System.out.println(idTemp);
        request.setAttribute("findShipById", ShipService.findShipById(idTemp));
        RequestDispatcher rd = request.getRequestDispatcher("pages/EditShip.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            String name = request.getParameter("name");
            String num = request.getParameter("num");
            int capacity = Integer.parseInt(request.getParameter("capacity"));

            ShipService.update(new Ship(id, num, name, capacity));

            response.sendRedirect("/PortWebApp/AllShipsServlet");
        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            doGet(request, response);
        }
    }
}
