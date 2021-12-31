package com.example.asm.controller;


import com.example.thijsp.Model.PhoneModel;
import com.example.thijsp.entity.Phone;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ListPhoneController extends HttpServlet {



    private PhoneModel phoneModel = new PhoneModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setCharacterEncoding("UTF-8");
        ArrayList<Phone> listProduct = phoneModel.findAll();

        req.setAttribute("list", listProduct);
        req.getRequestDispatcher("/phone/list.jsp").forward(req, resp);
    }
}
