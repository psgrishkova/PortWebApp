package servlets;

import services.CapService;
import services.PriceService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeletePriceServlet", value = "/delete_price")
public class DeletePriceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idTemp = Long.parseLong(request.getParameter("id"));
        PriceService.delete(idTemp);
        response.sendRedirect("/PortWebApp/AllPricesServlet");
    }
}
