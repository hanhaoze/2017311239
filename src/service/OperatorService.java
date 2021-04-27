package service;

import domain.Line;
import domain.Operator;
import domain.PageBean;
import domain.ProductInfo;

import java.util.List;
import java.util.Map;

public interface OperatorService {
    PageBean<Operator> findOperatorByPage(String currentPage, String rows, Map<String, String[]> condition);

    PageBean<ProductInfo> findProductByPage(String currentPage, String rows, Map<String, String[]> condition);

    Operator login(Operator operator);

    List<Line> findAllOptionalLine();

    void updateInfo(Operator operator);

    void updatePassword(String operatorid, String newpassword);

    Operator findOperatorById(Operator operator);

    void register(Operator operator);


}
