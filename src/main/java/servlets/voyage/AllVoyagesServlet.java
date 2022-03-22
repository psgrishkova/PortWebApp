package servlets.voyage;

import services.VoyageService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AllVoyagesServlet", value = "/AllVoyagesServlet")
public class AllVoyagesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("All", VoyageService.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("pages/AllVoyagesManager.jsp");
        rd.forward(request, response);
    }
}
