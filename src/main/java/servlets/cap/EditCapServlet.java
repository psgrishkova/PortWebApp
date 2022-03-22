package servlets.cap;

import models.Cap;
import services.CapService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditCapServlet", value = "/edit_cap")
public class EditCapServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idTemp = Long.parseLong(request.getParameter("id"));
        request.setAttribute("findCapById", CapService.findCapById(idTemp));
        RequestDispatcher rd = request.getRequestDispatcher("pages/EditCap.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            String name = request.getParameter("name");
            String tel = request.getParameter("tel");

            CapService.update(new Cap(id, name, tel));

            response.sendRedirect("/PortWebApp/AllCapsServlet");
        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            doGet(request, response);
        }
    }
}
