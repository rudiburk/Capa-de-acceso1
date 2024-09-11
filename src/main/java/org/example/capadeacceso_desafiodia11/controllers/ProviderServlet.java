package org.example.capadeacceso_desafiodia11.controllers;

import java.io.*;
import java.lang.ref.ReferenceQueue;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.capadeacceso_desafiodia11.dao.daoimpl.ProviderDAOimpl;
import org.example.capadeacceso_desafiodia11.model.ProviderDTO;
import org.example.capadeacceso_desafiodia11.service.ProviderService;
import org.example.capadeacceso_desafiodia11.service.serviceimpl.ProviderServiceImpl;

@WebServlet(name = "ProviderServlet", value = "/providerservlet")
public class ProviderServlet extends HttpServlet {
    private ProviderService objProviderService;

    @Override
    public void init() {
        objProviderService = new ProviderServiceImpl();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "list";
        }
        try {
            switch (action){
                case "new":
                    showNewForm(request,response);
                    break;
                case "insert":
                    insertProvider(response, request);
                    break;
                case "delete":
                    deleteProvider(request,response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateProvider(request, response);
                    break;
                default:
                    listProviders(request,response);
                    break;
            }
        }catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void updateProvider(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String rut = request.getParameter("rut");
        String email = request.getParameter("email");
        String address= request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String contact = request.getParameter("contact");
        String phoneNumberContact = request.getParameter("phoneNumberContact");
        ProviderDTO provider = new ProviderDTO(id, name, rut, email, address, phoneNumber, contact, phoneNumberContact);
        objProviderService.updateProvider(provider);
        response.sendRedirect("providerservlet?action=list");

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProviderDTO existingProvider = objProviderService.selectProvider(id);
        request.setAttribute("provider", existingProvider);
        request.getRequestDispatcher("editView.jsp").forward(request,response);
    }

    private void deleteProvider(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        objProviderService.deleteProvider(id);
        response.sendRedirect("dataBaseView.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    private void listProviders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProviderDTO> listProviders = objProviderService.selectAllProviders();
        req.setAttribute("listProviders", listProviders);
        req.getRequestDispatcher("dataBaseView.jsp").forward(req,resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    private void insertProvider(HttpServletResponse res, HttpServletRequest req) throws SQLException, IOException{
        String name = req.getParameter("name");
        String rut = req.getParameter("rut");
        String email = req.getParameter("email");
        String address= req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        String contact = req.getParameter("contact");
        String phoneNumberContact = req.getParameter("phoneNumberContact");
        ProviderDTO newProvider = new ProviderDTO (name, rut, email, address, phoneNumber, contact, phoneNumberContact);
        objProviderService.insertProvider(newProvider);
        res.sendRedirect("providerservlet?action=list");
    }
}