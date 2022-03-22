package servlets.route;

import services.RouteService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AllRoutesServlet", value = "/AllRoutesServlet")
public class AllRoutesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("All", RouteService.getAll());

        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher("pages/AllRoutesAManager.jsp");
            rd.forward(request, response);
        }
    }
}
