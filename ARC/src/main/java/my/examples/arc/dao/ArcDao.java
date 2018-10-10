package my.examples.arc.dao;

import my.examples.arc.servlet.ArcListDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ArcDao {

    String host = "thjang-arc-20181008.mysql.database.azure.com";
    String database = "arc";
    String user = "arc@thjang-arc-20181008";
    String password = "school1017!";

    public List<ArcListDto> getArcDtoList() {
        List<ArcListDto> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String url = String.format("jdbc:mysql://%s/%s", host, database);
            Properties properties = new Properties();
            properties.setProperty("user", user);
            properties.setProperty("password", password);
            properties.setProperty("useSSL", "true");
            properties.setProperty("verifyServerCertificate", "true");
            properties.setProperty("requireSSL", "false");
            properties.setProperty("serverTimezone", "UTC");

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
                ArcListDto arcListDto = new ArcListDto();
                arcListDto.setGdsNm(rs.getString(1));
                arcListDto.setInvestPeriod(rs.getInt(2));
                arcListDto.setPrfRto(rs.getLong(3));
                arcListDto.setMyPrice(rs.getInt(4));
                list.add(arcListDto);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return list;
    }

    /*INV_GDS_LST
    igl_idx	int(10) unsigned
    gds_cd	int(10)
    prf_rto	float(7,2)
    cms	double(10,2)

    MEMBER
    mb_idx	int(10) unsigned
    id	varchar(20)
    name	varchar(20)
    pw	varchar(20)
    email	varchar(50)

    MY_INV_LST
    my_idx	int(10) unsigned
    id	varchar(20)
    gds_cd	varchar(20)
    inv_prod	int(10)
    my_inv_prc	double(10,2)*/


    public int addGoods(ArcListDto arcListDto) {
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String url = String.format("jdbc:mysql://%s/%s", host, database);
            Properties properties = new Properties();
            properties.setProperty("user", user);
            properties.setProperty("password", password);
            properties.setProperty("useSSL", "true");
            properties.setProperty("verifyServerCertificate", "true");
            properties.setProperty("requireSSL", "false");
            properties.setProperty("serverTimezone", "UTC");

            conn = DbUtil.connect(url, properties);
            String sql = "insert into inv_gds_lst (gds_cd, prf_rto, cms)\n" +
                    "values (?, ?, ?)";
            //db에넣어야지
            ps = conn.prepareStatement(sql);
            ps.setInt(1, arcListDto.getIdx());
            ps.setLong(2, arcListDto.getPrfRto());
            ps.setFloat(3, arcListDto.getCms());
            count = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DbUtil.close(conn, ps);
        }
        return count;
    }

    //내투자목록상품등록
    public int addMyGoods(ArcListDto arcListDto) {
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String url = String.format("jdbc:mysql://%s/%s", host, database);
            Properties properties = new Properties();
            properties.setProperty("user", user);
            properties.setProperty("password", password);
            properties.setProperty("useSSL", "true");
            properties.setProperty("verifyServerCertificate", "true");
            properties.setProperty("requireSSL", "false");
            properties.setProperty("serverTimezone", "UTC");

            conn = DbUtil.connect(url, properties);

            String sql = "insert into my_inv_lst (id, gds_cd, inv_prod, my_inv_prc)\n" +
                    "values (?, ?, ?, ?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, arcListDto.getId());
            ps.setInt(2, arcListDto.getGdsCd());
            ps.setInt(3, arcListDto.getInvestPeriod());
            ps.setDouble(4, arcListDto.getInvestPrice());
            count = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DbUtil.close(conn, ps);
        }
        return count;
    }
}
