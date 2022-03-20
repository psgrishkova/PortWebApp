package servlets.voyage;

import services.VoyageService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AllVoyagesServlet", value = "/AllVoyagesServlet")
public class AllVoyagesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("All", VoyageService.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("jsp/AllVoyagesManager.jsp");
        rd.forward(request, response);
    }
}
