package servlets.voyage;

import services.VoyageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteVoyageServlet", value = "/delete_voyage")
public class DeleteVoyageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idTemp = Long.parseLong(request.getParameter("id"));
        VoyageService.delete(idTemp);
        response.sendRedirect("/PortWebApp/AllVoyagesServlet");
    }
}
