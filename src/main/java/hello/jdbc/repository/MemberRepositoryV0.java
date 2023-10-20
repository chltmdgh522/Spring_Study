package hello.jdbc.repository;

import hello.jdbc.connection.DBConnectionUtil;
import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

/**
 * JDBC - DM 사용
 */

@Slf4j
public class MemberRepositoryV0 {
    public Member save(Member member) throws SQLException {
        String sql="insert into member(member_id, money) values(?,?)";

        Connection con=null;
        PreparedStatement pstmt=null; //DB에 쿼리날리기

        try {
            con= getConnection();
            pstmt=con.prepareStatement(sql); // 데이터베이스에 전달할 SQL과 파라미터로 전달할 데이터들을 준비한다
            pstmt.setString(1, member.getMemberId()); //파라미터에 대한 값 바인딩
            pstmt.setInt(2,member.getMoney());

            pstmt.executeUpdate(); //실행
            return member;
        } catch (SQLException e) {
            log.error("db error",e);
            throw e;
        }finally {
            close(con,pstmt,null);
        }

    }

    private void close(Connection cos, Statement stmt, ResultSet rs){

        if(rs !=null){
            try {
                rs.close();
            } catch (SQLException e) {
                log.error("error",e);
            }
        }
        if(stmt !=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                log.error("error",e);
            }
        }
        if(cos !=null){
            try {
                cos.close();
            } catch (SQLException e) {
                log.error("error",e);
            }
        }
    }
    private static Connection getConnection() throws SQLException {
        return DBConnectionUtil.getConnection();
    }
}
