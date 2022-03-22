package servlets.voyage;

import models.Voyage;
import services.CapService;
import services.RouteService;
import services.ShipService;
import services.VoyageService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "AddVoyageServlet", value = "/AddVoyageServlet")
public class AddVoyageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("getAllCaps", CapService.getAll());
        request.setAttribute("getAllShips", ShipService.getAll());
        request.setAttribute("getAllRoutes", RouteService.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("pages/AddVoyage.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long capId = Long.parseLong(request.getParameter("cap"));
            Long shipId = Long.parseLong(request.getParameter("ship"));
            Long routeId = Long.parseLong(request.getParameter("route"));
            LocalDateTime date = LocalDateTime.parse(request.getParameter("date"));

            Voyage s = new Voyage(0L, capId, routeId, shipId, date);
            VoyageService.add(s);

            response.sendRedirect("/PortWebApp/AllVoyagesServlet");
        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            doGet(request, response);
        }
    }
}
