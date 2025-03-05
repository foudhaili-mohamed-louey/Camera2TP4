package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.lCameraDao;
import dao.CameraDaolmpl;
import PhotoShooting.entities.Camera;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {
    lCameraDao metier;

    @Override
    public void init() throws ServletException {
        metier = new CameraDaolmpl();
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();

        if (path.equals("/index.do")) {
            request.getRequestDispatcher("Camera.jsp").forward(request, response);
        } 
        else if (path.equals("/chercher.do")) {
            String motCle = request.getParameter("motCle");
            CameraModele model = new CameraModele();
            model.setMotCle(motCle);
            List<Camera> cameras = metier.CamerasParMC(motCle);
            model.setCameras(cameras);
            request.setAttribute("model", model);
            request.getRequestDispatcher("Camera.jsp").forward(request, response);
        } 
        else if (path.equals("/saisie.do")) {
            request.getRequestDispatcher("Saisie.jsp").forward(request, response);
        } 
        else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
            String type = request.getParameter("type");
            String name = request.getParameter("name");
            double resolution = Double.parseDouble(request.getParameter("resolution"));
            Camera camera = metier.save(new Camera(type, name, resolution));
            request.setAttribute("camera", camera);
            request.getRequestDispatcher("confirmation.jsp").forward(request, response);
        } 
        else if (path.equals("/editer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            Camera camera = metier.getCamera(id);
            request.setAttribute("camera", camera);
            request.getRequestDispatcher("editerCamera.jsp").forward(request, response);
        }
        else if (path.equals("/update.do")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String type = request.getParameter("type");
            String name = request.getParameter("name");
            double resolution = Double.parseDouble(request.getParameter("resolution"));
            Camera camera = new Camera(id,type, name, resolution);
            metier.updateCamera(camera);
            request.setAttribute("camera", camera);
       
            response.sendRedirect("chercher.do?motCle=");
        }
        else if (path.equals("/supprimer.do")) {
        	int id = Integer.parseInt(request.getParameter("id"));
            metier.deleteCamera(id);
            response.sendRedirect("chercher.do?motCle=");
        } 
        else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}