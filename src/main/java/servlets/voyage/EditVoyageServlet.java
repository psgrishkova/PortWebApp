package servlets.voyage;

import models.Voyage;
import repositories.CapRepository;
import repositories.ShipRepository;
import services.RouteService;
import services.VoyageService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "EditVoyageServlet", value = "/edit_voyage")
public class EditVoyageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            Long cap = Long.parseLong(request.getParameter("cap"));
            Long ship = Long.parseLong(request.getParameter("ship"));
            Long route = Long.parseLong(request.getParameter("route"));
            LocalDateTime date = LocalDateTime.parse(request.getParameter("date"));

            VoyageService.update(new Voyage(id, cap, route, ship, date));

            response.sendRedirect("/PortWebApp/AllVoyagesServlet");
        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            doGet(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("getAllCaps", CapRepository.getAll());
        request.setAttribute("getAllShips", ShipRepository.getAll());
        request.setAttribute("getAllRoutes", RouteService.getAll());
        Long idTemp = Long.parseLong(request.getParameter("id"));
        request.setAttribute("findVoyageById", VoyageService.findVoyageById(idTemp));
        RequestDispatcher rd = request.getRequestDispatcher("pages/EditVoyage.jsp");
        rd.forward(request, response);
    }
}
