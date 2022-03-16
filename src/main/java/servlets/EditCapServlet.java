package servlets;

import services.CapService;
import services.ShipService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditCapServlet", value = "/edit_cap")
public class EditCapServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idTemp = Long.parseLong(request.getParameter("id"));
        System.out.println(idTemp);
        request.setAttribute("findCapById", CapService.findCapById(idTemp));
        RequestDispatcher rd = request.getRequestDispatcher("pages/EditCap.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
