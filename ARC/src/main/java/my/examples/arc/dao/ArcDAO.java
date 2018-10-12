package my.examples.arc.dao;

import my.examples.arc.dto.ArcGdsAddDto;
import my.examples.arc.dto.ArcListDTO;
import my.examples.arc.dto.ArcWriteDto;
import my.examples.arc.dao.DbUtil;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ArcDAO {


    public List<ArcListDTO> getArcDtoList() {
        List<ArcListDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            InputStream in = getClass().getClassLoader().getResourceAsStream("MysqlInfo.secure");
            Properties properties= new Properties();
            properties.load(in);

            String url = String.format("jdbc:mysql://%s/%s",properties.getProperty("host"), properties.getProperty("database"));

            conn = DbUtil.connect(url, properties);
            String sql = "select case when a.gds_cd=1 then 'sangpum1'\n" +
                    "\twhen a.gds_cd=2 then 'sangpum2'\n" +
                    "\twhen a.gds_cd=3 then 'sangpum3'\n" +
                    "\twhen a.gds_cd=4 then 'sangpum4'\n" +
                    "\t\tEND as '상품코드', \n" +
                    "\ta.inv_prod as '투자기간(개월)',\n" +
                    "\tb.prf_rto as '수익률', \n" +
                    "\ta.my_inv_prc as '투자금액'\n" +
                    "from my_inv_lst a, inv_gds_lst b \n" +
                    "where a.gds_cd = b.gds_cd";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();


            while (rs.next()) {
                ArcListDTO arcListDto = new ArcListDTO();
                arcListDto.setGoodsName(rs.getString(1));
                arcListDto.setInvestmentPriod(rs.getInt(2));
                arcListDto.setProfitRatio(rs.getLong(3));
                arcListDto.setInvestmentPriod(rs.getInt(4));
                list.add(arcListDto);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return list;
    }


    public int login(String id, String password) {
        Connection conn =null;

        PreparedStatement ps;
        ResultSet rs;
        try{
        String sql = "SELECT id FROM member WHERE id = ?";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();

        if (rs.next()) {
          if(rs.getString(1).equals(password)){
            return 1; //로그인성공.
            }else return 0; //비밀번호틀림
          }
            return -1; //아이디없음.
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return -2; //DB오류.
      }

    public int addArc(ArcGdsAddDto arcGdsAddDto){
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            InputStream in = getClass().getClassLoader().getResourceAsStream("MysqlInfo.secure");
            Properties properties= new Properties();
            properties.load(in);

            String url = String.format("jdbc:mysql://%s/%s",properties.getProperty("host"), properties.getProperty("database"));

            conn = DbUtil.connect(url, properties);

            String sql = "insert into inv_gds_lst(igl_idx, gds_cd, prf_rto, cms) values (null, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, arcGdsAddDto.getGdsCd());
            ps.setLong(2, arcGdsAddDto.getPrfRto());
            ps.setFloat(3, arcGdsAddDto.getCms());
            count = ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            DbUtil.close(conn,ps);
        }
        return count;
    }

    public int writeArc(ArcWriteDto arcWriteDto){
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            InputStream in = getClass().getClassLoader().getResourceAsStream("MysqlInfo.secure");
            Properties properties= new Properties();
            properties.load(in);

            String url = String.format("jdbc:mysql://%s/%s",properties.getProperty("host"), properties.getProperty("database"));

            conn = DbUtil.connect(url, properties);
          
            String sql = "insert into my_inv_lst(my_idx, id, gds_cd, inv_prod, my_inv_prc) values (null, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, arcWriteDto.getId());
            ps.setInt(2, arcWriteDto.getGdsCd());
            ps.setInt(3, arcWriteDto.getInvestPeriod());
            ps.setDouble(4, arcWriteDto.getInvestPrice());

            count = ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            DbUtil.close(conn,ps);
        }
        return count;
    }
}
