package my.examples.arc.servlet;

import my.examples.arc.dao.ArcDAO;
import my.examples.arc.dto.ArcWriteDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/write")
public class ArcWrite extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // jsp에 포워딩
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/views/write.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // id, 상품이름, 투자 금액과 투자 기간을 검사한다.
        HttpSession session = req.getSession(false);    // 이미 세션이 있다면 그 세션을 돌려주고, 세션이 없으면 null을 돌려준다.
        String userID = (String) session.getAttribute("userID");
        if(userID == null) {    // 로그인이 되어 있지 않으면 login 페이지로 이동
            resp.sendRedirect("/login");
            return;
        }
        try {
            int goodsCode = Integer.parseInt(req.getParameter("goodsCode"));
            double investmentPrice = Double.parseDouble(req.getParameter("investmentPrice"));
            int investmentPeriod = Integer.parseInt(req.getParameter("investmentPeriod"));

            // 상품, 투자 금액과 투자 기간을 DB에 저장한다.
            ArcWriteDTO arcWriteDto = new ArcWriteDTO(userID, goodsCode, investmentPeriod, investmentPrice);
            ArcDAO arcDAO = new ArcDAO();
            arcDAO.writeArc(arcWriteDto);
        } catch (NumberFormatException ex) {
            throw new RuntimeException("유효한 값 입력되지 않았습니다." + ex.toString());
        }

        // /list로 리다이렉션
        resp.sendRedirect("/list");
    }
}
