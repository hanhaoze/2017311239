package dao.impl;

import dao.LeaderDao;
import domain.Leader;
import domain.Line;
import domain.Operator;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class LeaderDaoImpl implements LeaderDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Leader> findAll() {
        try {
            String sql = "select * from leader";
            List<Leader> teachers = template.query(sql, new BeanPropertyRowMapper<Leader>(Leader.class));
            return teachers;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Leader findLeaderidAndPassword(String id, String password) {
        try {
            String sql = "select * from leader where t_id = ? and t_password = ?";
            Leader leader = template.queryForObject(sql,new BeanPropertyRowMapper<Leader>(Leader.class),id,password);
            return leader;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateInfo(Leader leader) {
        try {
            String sql = "update leader set t_name =?,t_sex=?,t_phone=?,t_email=?,t_postion=? where t_id=?";
            template.update(sql,leader.getT_name(),leader.getT_sex(),leader.getT_phone(),leader.getT_email(),leader.getT_postion(),leader.getT_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Leader findLeaderById(String t_id) {
        try {
            String sql = "select * from leader where t_id = ?";
            Leader leader = template.queryForObject(sql,new BeanPropertyRowMapper<Leader>(Leader.class),t_id);
            return leader;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Line> findMySelfOptionalLine(String t_id) {
        try {
            String sql = "select * from line where t_id = ?";
            List<Line> lines = template.query(sql, new BeanPropertyRowMapper<Line>(Line.class),t_id);
            return lines;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updatePassword(String leaderid, String newpassword) {
        try {
            String sql = "update leader set t_password=? where t_id=?";
            template.update(sql,newpassword,leaderid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addLeaderAllInfo(Leader t) {
        try {
            String sql = "insert into leader(t_id,t_name,t_sex,t_postion,t_email) values(?,?,?,?,?)";
            template.update(sql,t.getT_id(),t.getT_name(),t.getT_sex(),t.getT_postion(),t.getT_email());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
