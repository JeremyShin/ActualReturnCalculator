package my.examples.arc.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/join")
public class ArcJoinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //리스트로포워딩해줌.
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/views/join.jsp");
        dispatcher.forward(req, resp);
    }

        //회원가입을하는경우.비밀번호.
}
