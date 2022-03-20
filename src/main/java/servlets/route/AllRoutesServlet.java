package servlets.route;
import services.RouteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AllRoutesServlet", value = "/AllRoutesServlet")
public class AllRoutesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("All", RouteService.getAll());

        }catch (Exception e){
            request.setAttribute("err", e.getMessage());
        }
        finally {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/AllRoutesAManager.jsp");
            rd.forward(request, response);
        }
    }
}
