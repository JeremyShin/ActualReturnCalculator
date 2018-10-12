package my.examples.arc.servlet;

import my.examples.arc.dao.ArcDAO;
import my.examples.arc.dto.ArcLoginDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/loginAction")
public class ArcLoginActionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ID/password가맞는지확인.
        ArcDAO arcDao = new ArcDAO();

        //경고메시지.

        //맞다면list화면으로리다이렉트.
        resp.sendRedirect("/list");
    }
}
