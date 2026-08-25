package com.xworkz.controller;

import com.xworkz.dto.SignInDTO;
import com.xworkz.services.SingInService;
import com.xworkz.services.impl.SingInServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String email = req.getParameter("email");



        SignInDTO signInDTO = new SignInDTO(userName,email);
        System.out.println(signInDTO);

        SingInService singInService = new SingInServiceImpl();
        boolean isValid = singInService.validateAndSave(signInDTO);

        HttpSession session = req.getSession();
        session.setAttribute("userName", userName);


        req.setAttribute("message","You signIn successfully.");


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("SignIn.jsp");
        requestDispatcher.forward(req,resp);
    }
}
