package servlets;

import services.CapService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteCapServlet", value = "/delete_cap")
public class DeleteCapServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idTemp = Long.parseLong(request.getParameter("id"));
        System.out.println(idTemp);
        CapService.delete(idTemp);
        response.sendRedirect("/PortWebApp/AllCapsServlet");
    }
}
