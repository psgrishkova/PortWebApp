package servlets;

import services.CapService;
import services.RouteService;
import services.ShipService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

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
}
