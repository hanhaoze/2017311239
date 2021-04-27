package dao.impl;

import dao.LineDao;
import domain.Line;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class LineDaoImpl implements LineDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public void addOptionalLine(Line l) {
        try {
            String sql = "insert into line values(?,?,?,?)";
            template.update(sql,l.getC_id(),l.getC_name(),l.getT_id(),l.getC_info());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Line findSelectLineByLineId(String cid) {
        try {
            String sql = "select * from line where c_id = ?";
            Line line = template.queryForObject(sql,new BeanPropertyRowMapper<Line>(Line.class),cid);
            return line;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteServiceById(String cid) {
        try {
            String sql = "delete from line where c_id=?";
            template.update(sql,cid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

    }
}
