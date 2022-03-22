package servlets.cap;


import services.CapService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
