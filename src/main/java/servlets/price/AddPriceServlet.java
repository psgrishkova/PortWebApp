package servlets.price;

import models.Price;
import services.PriceService;
import services.RouteService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddPriceServlet", value = "/AddPriceServlet")
public class AddPriceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("getAllRoutes", RouteService.getAll());
        RequestDispatcher rd = request.getRequestDispatcher("pages/AddPrice.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(request.getParameter("route"));
            String category = request.getParameter("category");
            Double price = Double.parseDouble(request.getParameter("price"));
            Price s = new Price(id, category, price);
            PriceService.add(s);
            response.sendRedirect("/PortWebApp/AllPricesServlet");
        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            doGet(request, response);
        }
    }
}
