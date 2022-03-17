package servlets;

import services.RouteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddPriceServlet", value = "/add_price")
public class AddPriceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id=Long.parseLong(request.getParameter("id"));
        System.out.println(id);
        request.setAttribute("id",id);
        request.setAttribute("getAllRoutes", RouteService.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("pages/AddPrice.jsp");
        rd.forward(request, response);
    }
}
