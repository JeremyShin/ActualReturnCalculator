package my.examples.arc.servlet;

import my.examples.arc.dao.ArcDAO;
import my.examples.arc.dto.ArcGdsAddDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/gdsadd")
public class ArcGdsAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 포워딩
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/views/gdsadd.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 상품 이름, 수익률, 수수료를 검사한다
        int gdsCd = Integer.parseInt(req.getParameter("gdsCd"));
        Float prfRto = Float.parseFloat(req.getParameter("prfRto"));
        Float cms = Float.parseFloat(req.getParameter("cms"));

        // 상품 이름, 수익률, 수수료를 DB에 저장한다.
        ArcGdsAddDto arcGdsAddDto = new ArcGdsAddDto(gdsCd, prfRto, cms);
        ArcDAO arcDAO = new ArcDAO();
        arcDAO.addArc(arcGdsAddDto);

        // /list로 리다이렉션
        resp.sendRedirect("/list");
    }
}
