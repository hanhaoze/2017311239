package service.impl;

import dao.OperatorDao;
import dao.impl.OperatorDaoImpl;
import domain.Line;
import domain.Operator;
import domain.PageBean;
import domain.ProductInfo;
import service.OperatorService;

import java.util.List;
import java.util.Map;

public class OperatorServiceImpl implements OperatorService {
    private OperatorDao dao = new OperatorDaoImpl();
    public Operator login(Operator operator) {
        return dao.findOperatoridAndPassword(operator.getS_id(),operator.getS_password());
    }

    @Override
    public List<Line> findAllOptionalLine() {
        return dao.findAllOptionalLine();
    }

    @Override
    public PageBean<Operator> findOperatorByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        //创建新的PageBean对象
        PageBean<Operator> pb = new PageBean<Operator>();

        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        //调用dao查询List集合
        //计算开始记录的索引
        int start = (currentPage - 1) * rows;
        List<Operator>list = dao.findByPage(start,rows,condition);
        pb.setList(list);

        //计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public PageBean<ProductInfo> findProductByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        //创建新的PageBean对象
        PageBean<ProductInfo> pb = new PageBean<ProductInfo>();

        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //调用dao查询总记录数
        int totalCount = dao.findTotalProductCount(condition);
        pb.setTotalCount(totalCount);

        //调用dao查询List集合
        //计算开始记录的索引
        int start = (currentPage - 1) * rows;
        List<ProductInfo>list = dao.findProductByPage(start,rows,condition);
        pb.setList(list);

        //计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public void updateInfo(Operator operator) {
        dao.updateInfo(operator);

    }

    @Override
    public Operator findOperatorById(Operator operator) {
        return dao.findOperatorById(operator.getS_id());
    }

    @Override
    public void updatePassword(String operatorid, String newpassword) {
        dao.updatePassword(operatorid,newpassword);
    }

    @Override
    public void register(Operator operator) {
        dao.addOperator(operator);
    }
}

