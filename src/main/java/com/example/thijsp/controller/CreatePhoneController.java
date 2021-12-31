package com.example.thijsp.controller;

import com.example.thijsp.Model.PhoneModel;
import com.example.thijsp.entity.Phone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class CreatePhoneController extends HttpServlet {

    private PhoneModel phoneModel = new PhoneModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/phone/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            String brand = req.getParameter("brand");
            double price = Double.parseDouble(req.getParameter("price"));
            String description = req.getParameter("description");
            Phone p = new Phone(name, brand, description, price);
            if (phoneModel.save(p)){
                resp.sendRedirect("/phone/list");

            }
            resp.sendRedirect("/phone/list");
        }catch (Exception ex) {
            resp.getWriter().println("Error");
        }
    }
}