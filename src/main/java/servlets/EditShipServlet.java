package servlets;

import services.ShipService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditShipServlet", urlPatterns = "/edit")
public class EditShipServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idTemp = Long.parseLong(request.getParameter("id"));
        System.out.println(idTemp);
        request.setAttribute("findShipById", ShipService.findShipById(idTemp));
        RequestDispatcher rd = request.getRequestDispatcher("pages/EditShip.jsp");
        rd.forward(request, response);
    }
}
