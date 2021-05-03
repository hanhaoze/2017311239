package dao.impl;

import dao.OperatorDao;
import domain.Line;
import domain.Operator;
import domain.ProductInfo;
import domain.SelectLine;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OperatorDaoImpl implements OperatorDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public Operator findOperatoridAndPassword(String id, String password) {
        try {
            String sql = "select * from operator where s_id = ? and s_password = ?";
            Operator operator = template.queryForObject(sql, new BeanPropertyRowMapper<Operator>(Operator.class), id, password);
            return operator;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Line> findAllOptionalLine() {
        try {
            String sql = "select line.c_id,line.c_name,line.c_info,leader.t_id,t_name\n" +
                    "from line,leader\n" +
                    "where line.t_id=leader.t_id";
            List<Line> cs = template.query(sql, new BeanPropertyRowMapper<Line>(Line.class));
            return cs;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //定义模板初始化sql
        String sql = "select count(*) from operator where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        //遍历map
        Set<String> keySet = condition.keySet();
        //定义参数集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append(" and "+ key +" like ? ");
                params.add("%"+value+"%");//?条件的值
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public int findTotalProductCount(Map<String, String[]> condition) {
        //定义模板初始化sql
        String sql = "select count(*) from product_info where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        //遍历map
        Set<String> keySet = condition.keySet();
        //定义参数集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//?条件的值
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<Operator> findByPage(int start, int rows, Map<String, String[]> condition) {
        try {
            String sql = "select * from operator where 1=1";
            StringBuilder sb = new StringBuilder(sql);
            //遍历map
            Set<String> keySet = condition.keySet();
            //定义参数集合
            List<Object> params = new ArrayList<Object>();
            for (String key : keySet) {
                //排除分页条件参数
                if ("currentPage".equals(key) || "rows".equals(key)) {
                    continue;
                }

                //获取value
                String value = condition.get(key)[0];
                //判断value是否有值
                if (value != null && !"".equals(value)) {
                    //有值
                    sb.append(" and "+key+" like ? ");
                    params.add("%"+value+"%");//?条件的值
                }
            }
            //添加分页查询
            sb.append(" limit ? , ?");
            //添加分页查询参数值
            params.add(start);
            params.add(rows);
            System.out.println(sb.toString());
            System.out.println(params);
            return template.query(sb.toString(),new BeanPropertyRowMapper<Operator>(Operator.class),params.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ProductInfo> findProductByPage(int start, int rows, Map<String, String[]> condition) {
        try {
            String sql = "select * from product_info where 1=1";
            StringBuilder sb = new StringBuilder(sql);
            //遍历map
            Set<String> keySet = condition.keySet();
            //定义参数集合
            List<Object> params = new ArrayList<Object>();
            for (String key : keySet) {
                //排除分页条件参数
                if ("currentPage".equals(key) || "rows".equals(key)) {
                    continue;
                }

                //获取value
                String value = condition.get(key)[0];
                //判断value是否有值
                if (value != null && !"".equals(value)) {
                    //有值
                    sb.append(" and "+key+" like ? ");
                    params.add("%"+value+"%");//?条件的值
                }
            }
            //添加分页查询
            sb.append(" limit ? , ?");
            //添加分页查询参数值
            params.add(start);
            params.add(rows);
            System.out.println(sb.toString());
            System.out.println(params);
            return template.query(sb.toString(),new BeanPropertyRowMapper<ProductInfo>(ProductInfo.class),params.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateInfo(Operator operator) {
        try {
            String sql = "update operator set s_name =?,s_sex=?,s_age=?,s_phone=?,s_email=?,s_address=? where s_id=?";
            template.update(sql,operator.getS_name(),operator.getS_sex(),operator.getS_age(),operator.getS_phone(),operator.getS_email(),operator.getS_address(),operator.getS_id());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Operator findOperatorById(String s_id) {
        try {
            String sql = "select * from operator where s_id = ?";
            Operator operator = template.queryForObject(sql,new BeanPropertyRowMapper<Operator>(Operator.class),s_id);
            return operator;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updatePassword(String operatorid, String newpassword) {
        try {
            String sql = "update operator set s_password=? where s_id=?";
            template.update(sql,newpassword,operatorid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addOperator(Operator operator) {
        try {
            String sql = "insert into operator(s_id,s_password) values(?,?)";
            template.update(sql,operator.getS_id(),operator.getS_password());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<SelectLine> findAllSelectLine(String operatorid) {
        try {
            String sql = "select operator.s_id,operator.s_name,line.c_id,line.c_name,line.c_info,line.t_id,t_name,select_line.score\n" +
                    "from select_line,operator,line,leader\n" +
                    "where operator.s_id=select_line.s_id\n" +
                    "and select_line.c_id=line.c_id\n" +
                    "and line.t_id=leader.t_id\n" +
                    "and operator.s_id=?";
            List<SelectLine> scs = template.query(sql, new BeanPropertyRowMapper<SelectLine>(SelectLine.class),operatorid);
            return scs;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<SelectLine> findSelectLineAllOperator() {
        try {
            String sql = "select operator.s_id,operator.s_name,line.c_id,line.c_name,line.c_info,leader.t_id,t_name,select_line.score\n" +
                    "from select_line,operator,line,leader\n" +
                    "where operator.s_id=select_line.s_id\n" +
                    "and select_line.c_id=line.c_id\n" +
                    "and line.t_id=leader.t_id\n";
            List<SelectLine> scs = template.query(sql, new BeanPropertyRowMapper<SelectLine>(SelectLine.class));
            return scs;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addSelectLine(String operatorid, String lineid) {
        try {
            String sql = "insert into select_line(s_id,c_id) values(?,?)";
            template.update(sql,operatorid,lineid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOperatorById(String operatorid) {
        try {
            String sql = "delete from operator where s_id=?";
            template.update(sql,operatorid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addOperatorAllInfo(Operator s) {
        try {
            String sql = "insert into operator(s_id,s_name,s_sex,s_age,s_phone,s_email,s_address) values(?,?,?,?,?,?,?)";
            template.update(sql,s.getS_id(),s.getS_name(),s.getS_sex(),s.getS_age(),s.getS_phone(),s.getS_email(),s.getS_address());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
