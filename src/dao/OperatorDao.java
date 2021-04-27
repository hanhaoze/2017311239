package dao;

import domain.Line;
import domain.Operator;
import domain.ProductInfo;

import java.util.List;
import java.util.Map;

public interface OperatorDao {
    Operator findOperatoridAndPassword(String id, String password);

    List<Line> findAllOptionalLine();

    int findTotalCount(Map<String, String[]> condition);

    int findTotalProductCount(Map<String, String[]> condition);

    List<Operator> findByPage(int start, int rows, Map<String, String[]> condition);

    List<ProductInfo> findProductByPage(int start, int rows, Map<String, String[]> condition);

    void updateInfo(Operator operator);

    void updatePassword(String operatorid, String newpassword);

    Operator findOperatorById(String s_id);

    void addOperator(Operator operator);

}
