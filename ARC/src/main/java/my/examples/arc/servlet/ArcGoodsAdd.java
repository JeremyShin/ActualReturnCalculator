package my.examples.arc.servlet;

import my.examples.arc.dao.ArcDAO;
import my.examples.arc.dto.ArcGdsAddDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goodsAdd")
public class ArcGoodsAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 포워딩
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/views/goodsAdd.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 상품 이름, 수익률, 수수료를 검사한다

        try {
            int gdsCd = Integer.parseInt(req.getParameter("goodsCode"));
            Float prfRto = Float.parseFloat(req.getParameter("profitRatio"));
            Float cms = Float.parseFloat(req.getParameter("commisions"));

            // 상품 이름, 수익률, 수수료를 DB에 저장한다.
            ArcGdsAddDTO arcGdsAddDto = new ArcGdsAddDTO(gdsCd, prfRto, cms);
            ArcDAO arcDAO = new ArcDAO();
            arcDAO.addArc(arcGdsAddDto);
        }catch (NumberFormatException ex){
            throw new RuntimeException("유효한 값 입력되지 않았습니다."+ ex.toString());
        }

        // /list로 리다이렉션
        resp.sendRedirect("/list");
    }
}
