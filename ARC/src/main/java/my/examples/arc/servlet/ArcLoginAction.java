package my.examples.arc.servlet;

import my.examples.arc.dao.ArcDAO;
import my.examples.arc.dto.ArcLoginDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/loginAction")
public class ArcLoginAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ID/password가맞는지확인.
        ArcDAO arcDao = new ArcDAO();
        PrintWriter out = resp.getWriter();

        int result = arcDao.login(req.getParameter("userId"), req.getParameter("userPassword"));

        if(result == 1) {
            out.println("<script>alert('hello!'); location.href='/list';</script>");
        }else {
            out.println("<script> alert('비밀번호가틀립니다.'); history.back();</script>");
        }
        out.close();
        //경고메시지.

        //맞다면list화면으로리다이렉트.
        // resp.sendRedirect("/list");
    }
}
