package my.examples.arc.dao;

import my.examples.arc.dto.ArcGdsAddDTO;
import my.examples.arc.dto.ArcListDTO;
import my.examples.arc.dto.ArcWriteDTO;

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
            String sql1 = "set @num:=0";
            String sql2 =
                    "select @num:=@num+1 as number,\n" +
                            "\tgm.gds_nm,\n" +
                            "\tmil.inv_prod,\n" +
                            "\tigl.prf_rto,\n" +
                            "\tmil.my_inv_prc ,\n" +
                            "\tmil.my_inv_prc*igl.prf_rto*mil.inv_prod as price,\n" +
                            "\t'8%' as tax,\n" +
                            "\tigl.cms,\n" +
                            "\t(my_inv_prc+my_inv_prc*0.08)-igl.cms as realPrice\n" +
                            "\tfrom gds_mst gm, my_inv_lst mil, inv_gds_lst igl\n" +
                            "\twhere igl.gds_cd = mil.gds_cd\n" +
                            "\tand igl.gds_cd = gm.gds_cd;\n";
            ps = conn.prepareStatement(sql1);
            rs = ps.executeQuery();
            ps = conn.prepareStatement(sql2);
            rs = ps.executeQuery();


            while (rs.next()) {
                ArcListDTO arcListDto = new ArcListDTO();

                arcListDto.setNumber(rs.getInt(1));
                arcListDto.setGoodsName(rs.getString(2));
                arcListDto.setInvestmentPeriod(rs.getInt(3));
                arcListDto.setProfitRatio(rs.getFloat(4));
                arcListDto.setMyInvestmentPrice(rs.getLong(5));
                arcListDto.setProfits(rs.getInt(6));
                arcListDto.setTax(rs.getString(7));
                arcListDto.setCommisions(rs.getString(8));
                arcListDto.setRealProfits(rs.getLong(9));
                list.add(arcListDto);
            }

        } catch (Exception ex) {
            throw new RuntimeException("디비오류"+ex.toString());
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
            InputStream in = getClass().getClassLoader().getResourceAsStream("MysqlInfo.secure");
            Properties properties= new Properties();
            properties.load(in);

        String sql = "SELECT id, pw FROM member WHERE id = ?";
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

    public int addArc(ArcGdsAddDTO arcGdsAddDto){
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
            ps.setInt(1, arcGdsAddDto.getGoodsCode());
            ps.setFloat(2, arcGdsAddDto.getProfitRatio());
            ps.setFloat(3, arcGdsAddDto.getCommisions());
            count = ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            DbUtil.close(conn,ps);
        }
        return count;
    }

    public int writeArc(ArcWriteDTO arcWriteDto){
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
            ps.setInt(2, arcWriteDto.getGoodsCode());
            ps.setInt(3, arcWriteDto.getInvestmentPeriod());
            ps.setDouble(4, arcWriteDto.getInvestmentPrice());

            count = ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            DbUtil.close(conn,ps);
        }
        return count;
    }
}
