package my.examples.arc.servlet;

import my.examples.arc.dao.ArcDAO;
import my.examples.arc.dto.ArcWriteDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/write")
public class ArcWriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // jsp에 포워딩
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/views/write.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // id, 상품이름, 투자 금액과 투자 기간을 검사한다.
        HttpSession session = req.getSession();
        String id = (String)session.getAttribute("id");
        int gdsCd = Integer.parseInt(req.getParameter("gdsCd"));
        double investPrice = Double.parseDouble(req.getParameter("investPrice"));
        int investPeriod = Integer.parseInt(req.getParameter("investPeriod"));

        // 상품, 투자 금액과 투자 기간을 DB에 저장한다.
        ArcWriteDto arcWriteDto = new ArcWriteDto(id, gdsCd, investPeriod, investPrice);
        ArcDAO arcDAO = new ArcDAO();
        arcDAO.writeArc(arcWriteDto);

        // /list로 리다이렉션
        resp.sendRedirect("/list");
    }
}
