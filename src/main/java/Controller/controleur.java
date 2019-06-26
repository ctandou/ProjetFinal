/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO;
import DAO.DAOException;
import DAO.DataSource;
import Model.DiscountCode;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ctandou
 */
@WebServlet(name = "controleur", urlPatterns = {"/controleur"})
public class controleur extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            DAO dao = new DAO(DataSource.getDataSource());

            request.setAttribute("listCode", dao.listCode());

            request.getRequestDispatcher("View/page.jsp").forward(request, response);

        } catch (DAOException e) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            DAO dao = new DAO(DataSource.getDataSource());
            String code = request.getParameter("Code");
            String taux = request.getParameter("Taux");
            
            switch (request.getParameter("action")) {
                case "add":
                    dao.ajouterCode(code, Float.parseFloat(taux));//transformer le string en float pour taux
                    break;
                    
                case "delete":
                    dao.deleteCode(code);
                    break;
                    
            }
        } catch (DAOException ex) {
            Logger.getLogger(controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
