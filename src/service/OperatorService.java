package service;

import domain.*;

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

    List<SelectLine> findAllSelectLine(String operatorid);

    List<SelectLine> findSelectLineAllOperator();

    void addSelectLine(String operatorid, String lineid);

    void deleteSelectOperator(String[] sids);

    void deleteOperatorById(String operatorid);

    void addOperatorAllInfo(Operator updateOperator);






}
