package servlets.price;



import services.PriceService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AllPricesServlet", value = "/AllPricesServlet")
public class AllPricesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("All", PriceService.getAllPriceLists());
        RequestDispatcher rd = request.getRequestDispatcher("jsp/AllPricesManager.jsp");
        rd.forward(request, response);
    }
}
